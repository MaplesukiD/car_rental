package cqut.keshe3.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cqut.keshe3.common.Code;
import cqut.keshe3.common.Result;
import cqut.keshe3.domain.Order;
import cqut.keshe3.dto.OrderDto;
import cqut.keshe3.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author MaplesukiD
 * @since 2024/6/2 16:59
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     订单信息分页查询 条件
     * @param currentPage
     * @param pageSize
     * @param startDate
     * @param endDate
     * @param userId
     * @param carId
     * @return: cqut.keshe3.common.Result<com.baomidou.mybatisplus.extension.plugins.pagination.Page>
     */
    @GetMapping("/page")
    public Result<Page> getPage(@RequestParam int currentPage, @RequestParam int pageSize, @RequestParam String startDate, @RequestParam String endDate, @RequestParam String userId, @RequestParam String carId) {
        Page<OrderDto> orderPage = orderService.getOrderPage(currentPage, pageSize, startDate, endDate, userId, carId);
        return new Result<>(Code.GET_OK, orderPage, Code.GET_OK_MESSAGE);
    }

    /**
     根据id查询低昂单信息
     * @param id
     * @return: cqut.keshe3.common.Result<cqut.keshe3.domain.Order>
     */
    @GetMapping
    public Result<Order> getOrderById(@RequestParam Integer id){
        Order order = orderService.getById(id);
        if(order != null){
            return new Result<>(Code.GET_OK, order, Code.GET_OK_MESSAGE);
        }
        return new Result<>(Code.GET_ERR, Code.GET_ERR_MESSAGE);
    }

    /**
     更新订单信息
     * @param order
     * @return: cqut.keshe3.common.Result<java.lang.String>
     */
    @PutMapping
    public Result<String> update(@RequestBody Order order){
        orderService.updateById(order);
        return new Result<>(Code.UPDATE_OK, Code.UPDATE_OK_MESSAGE);
    }

    @GetMapping("/getAllByUserId")
    public Result getById(@RequestParam Integer userId){
        List<OrderDto> orderDtoList = orderService.getAllByUserId(userId);
        if(orderDtoList != null || orderDtoList.size() > 0){
            return new Result<>(Code.GET_OK, orderDtoList, Code.GET_OK_MESSAGE);
        }
        return new Result<>(Code.GET_ERR, Code.GET_ERR_MESSAGE);
    }

}
