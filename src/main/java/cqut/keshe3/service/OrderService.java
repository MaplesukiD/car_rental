package cqut.keshe3.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cqut.keshe3.domain.Order;
import com.baomidou.mybatisplus.extension.service.IService;
import cqut.keshe3.dto.OrderDto;

import java.util.List;

/**
* @author MaplesukiD
* @description 针对表【order】的数据库操作Service
* @createDate 2024-05-30 22:24:10
*/
public interface OrderService extends IService<Order> {

    // 订单信息条件分页查询
    Page<OrderDto> getOrderPage(int currentPage, int pageSize, String startDate, String endDate, String userId, String carName);

    List<OrderDto> getAllByUserId(Integer userId);
}
