package cqut.keshe3.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cqut.keshe3.domain.Car;
import cqut.keshe3.domain.Check;
import cqut.keshe3.domain.User;
import cqut.keshe3.dto.CheckDto;
import cqut.keshe3.mapper.CarMapper;
import cqut.keshe3.mapper.CheckMapper;
import cqut.keshe3.mapper.UserMapper;
import cqut.keshe3.service.CheckService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
* @author MaplesukiD
* @description 针对表【check】的数据库操作Service实现
* @createDate 2024-05-30 22:24:05
*/
@Service
public class CheckServiceImpl extends ServiceImpl<CheckMapper, Check>
    implements CheckService{

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CarMapper carMapper;
    @Autowired
    private CheckMapper checkMapper;

    @Override
    public Page<CheckDto> getCheckPage(String carNumber, String startDate, String endDate, String status, Integer currentPage, Integer pageSize) {
        Page<Check> checkPage = new Page<>(currentPage, pageSize);
        Page<CheckDto> checkDtoPage = new Page<>();

        // 2.构造条件构造器
        LambdaQueryWrapper<Check> lqw = new LambdaQueryWrapper<>();
        if(StringUtils.isNotEmpty(carNumber)){
            LambdaQueryWrapper<Car> lqw2 = new LambdaQueryWrapper<>();
            lqw2.eq(Car::getCarNumber,carNumber);
            Car car=carMapper.selectOne(lqw2);
            lqw.eq(Check::getCarId, car.getId());
        }
        //添加状态筛选
        if(StringUtils.isNotEmpty(status)) {
            lqw.eq(Check::getStatus, Integer.parseInt(status));
        }
        // 3.3 添加时间范围 startDate
        lqw.ge(StringUtils.isNotEmpty(startDate), Check::getCheckDate, startDate);
        // 3.4 添加时间范围 endDate
        lqw.le(StringUtils.isNotEmpty(endDate), Check::getCheckDate, endDate);
        // 3.5 添加排序条件——按照createTime降
        lqw.orderByDesc(Check::getCheckDate);

        // 4.查询
        checkMapper.selectPage(checkPage, lqw);

        // 5.将CheckPage拷贝到CheckDtoPage中
        BeanUtils.copyProperties(checkPage, checkDtoPage,"records");

        // 6.遍历records中存放的Check信息
        List<CheckDto> checkDtoList = checkPage.getRecords().stream().map((item) -> {
            CheckDto checkDto = new CheckDto();

            // 6.1 将item拷贝到CheckDto中，全部拷贝
            BeanUtils.copyProperties(item, checkDto);

            // 6.2 获取该订单对应的用户id和车辆id
            Integer userID = checkDto.getUserId();
            Integer carID = checkDto.getCarId();

            // 6.3 查询该订单对应的用户和车辆信息
            User user = userMapper.selectById(userID);
            Car car = carMapper.selectById(carID);

            // 6.4 把该订单的用户名和车名和车牌号加入CheckDto
            checkDto.setUsername(user.getUsername());
            checkDto.setCarName(car.getCarName());
            checkDto.setCarNumber(car.getCarNumber());

            //6.5返回CheckDto => 最终组合成 List集合
            return checkDto;

        }).collect(Collectors.toList());

        // 7.将CheckDtoList加入到CheckDtoPage中
        checkDtoPage.setRecords(checkDtoList);

        //8.返回CheckDtoPage
        return checkDtoPage;
    }

    @Override
    public List<Check> getByCarId(Integer carId) {
        LambdaQueryWrapper<Check> lqw = new LambdaQueryWrapper<>();
        lqw.eq(carId != null, Check::getCarId, carId);
        List<Check> checkList = checkMapper.selectList(lqw);
        return checkList;
    }
}




