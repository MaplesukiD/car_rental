package cqut.keshe3.mapper;

import cqut.keshe3.domain.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author MaplesukiD
* @description 针对表【order】的数据库操作Mapper
* @createDate 2024-05-30 22:24:10
* @Entity cqut.keshe3.domain.Order
*/
@Mapper
public interface OrderMapper extends BaseMapper<Order> {

}




