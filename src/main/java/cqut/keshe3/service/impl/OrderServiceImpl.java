package cqut.keshe3.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cqut.keshe3.domain.Car;
import cqut.keshe3.domain.Order;
import cqut.keshe3.domain.User;
import cqut.keshe3.dto.OrderDto;
import cqut.keshe3.mapper.CarMapper;
import cqut.keshe3.mapper.UserMapper;
import cqut.keshe3.service.OrderService;
import cqut.keshe3.mapper.OrderMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
* @author MaplesukiD
* @description 针对表【order】的数据库操作Service实现
* @createDate 2024-05-30 22:24:10
*/
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService{

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CarMapper carMapper;

    // 订单信息条件分页查询
    @Override
    public Page<OrderDto> getOrderPage(int currentPage, int pageSize, String startDate, String endDate, String userId, String carId) {
        // 1.构建分页构造器
        Page<Order> orderPage = new Page(currentPage, pageSize);
        Page<OrderDto> orderDtoPage = new Page<>();

        // 2.构造条件构造器
        LambdaQueryWrapper<Order> lqw = new LambdaQueryWrapper<>();

        // 3.添加条件
        // 3.1 添加userId条件，不为空时模糊匹配
        if(StringUtils.isNotEmpty(userId)){
            lqw.eq(Order::getUserId, Integer.parseInt(userId));
        }
        // 3.2 添加carId条件，不为空时模糊匹配
        if(StringUtils.isNotEmpty(carId)){
            lqw.eq(Order::getCarId, Integer.parseInt(carId));
        }
        // 3.3 添加时间范围 startDate
        lqw.ge(StringUtils.isNotEmpty(startDate), Order::getCreateTime, startDate);
        // 3.4 添加时间范围 endDate
        lqw.le(StringUtils.isNotEmpty(endDate), Order::getCreateTime, endDate);
        // 3.5 添加排序条件——按照createTime降
        lqw.orderByDesc(Order::getCreateTime);

        // 4.查询
        orderMapper.selectPage(orderPage, lqw);

        // 5.将orderPage拷贝到orderDtoPage中（除了records）
        BeanUtils.copyProperties(orderPage, orderDtoPage, "records");

        // 6.遍历records中存放的order信息
        List<OrderDto> orderDtoList = orderPage.getRecords().stream().map((item) -> {
            OrderDto orderDto = new OrderDto();

            // 6.1 将item拷贝到orderDto中，全部拷贝
            BeanUtils.copyProperties(item, orderDto);

            // 6.2 获取该订单对应的用户id和车辆id
            Integer userID = orderDto.getUserId();
            Integer carID = orderDto.getCarId();

            // 6.3 查询该订单对应的用户和车辆信息
            User user = userMapper.selectById(userID);
            Car car = carMapper.selectById(carID);

            // 6.4 把该订单的用户名和车名加入orderDto
            orderDto.setUsername(user.getUsername());
            orderDto.setCarName(car.getCarName());

            //6.5返回orderDto => 最终组合成 List集合
            return orderDto;

        }).collect(Collectors.toList());

        // 7.将orderDtoList加入到orderDtoPage中
        orderDtoPage.setRecords(orderDtoList);

        //8.返回orderDtoPage
        return orderDtoPage;
    }
}




