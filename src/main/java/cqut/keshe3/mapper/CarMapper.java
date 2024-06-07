package cqut.keshe3.mapper;

import cqut.keshe3.domain.Car;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author HUAWEI
* @description 针对表【car】的数据库操作Mapper
* @createDate 2024-06-07 10:41:55
* @Entity cqut.keshe3.domain.Car
*/
@Mapper
public interface CarMapper extends BaseMapper<Car> {

}




