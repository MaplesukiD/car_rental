package cqut.keshe3.mapper;

import cqut.keshe3.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Administrator
* @description 针对表【user】的数据库操作Mapper
* @createDate 2024-06-14 14:12:59
* @Entity cqut.keshe3.domain.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

}




