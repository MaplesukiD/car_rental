package cqut.keshe3.mapper;

import cqut.keshe3.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author MaplesukiD
* @description 针对表【user】的数据库操作Mapper
* @createDate 2024-05-30 22:24:17
* @Entity cqut.keshe3.domain.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

}




