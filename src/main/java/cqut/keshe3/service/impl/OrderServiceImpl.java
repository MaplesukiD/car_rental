package cqut.keshe3.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cqut.keshe3.domain.Order;
import cqut.keshe3.service.OrderService;
import cqut.keshe3.mapper.OrderMapper;
import org.springframework.stereotype.Service;

/**
* @author MaplesukiD
* @description 针对表【order】的数据库操作Service实现
* @createDate 2024-05-30 22:24:10
*/
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order>
    implements OrderService{

}




