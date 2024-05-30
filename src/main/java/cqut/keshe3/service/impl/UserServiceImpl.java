package cqut.keshe3.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cqut.keshe3.domain.User;
import cqut.keshe3.service.UserService;
import cqut.keshe3.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author MaplesukiD
* @description 针对表【user】的数据库操作Service实现
* @createDate 2024-05-30 22:24:17
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




