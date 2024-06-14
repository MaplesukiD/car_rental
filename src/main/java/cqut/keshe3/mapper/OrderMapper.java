package cqut.keshe3.mapper;

import cqut.keshe3.domain.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Administrator
* @description 针对表【order】的数据库操作Mapper
* @createDate 2024-06-14 14:44:33
* @Entity cqut.keshe3.domain.Order
*/
@Mapper
public interface OrderMapper extends BaseMapper<Order> {

}




