package cqut.keshe3.service;

import cqut.keshe3.Exception.CommonException;
import cqut.keshe3.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author MaplesukiD
* @description 针对表【user】的数据库操作Service
* @createDate 2024-05-30 22:24:17
*/
public interface UserService extends IService<User> {

    // 登录
    String login(User user) throws CommonException;

    // 注册
    void register(User user) throws CommonException;

    // 退出
    void logout(String token);
}
