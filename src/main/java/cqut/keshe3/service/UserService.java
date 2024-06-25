package cqut.keshe3.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cqut.keshe3.Exception.CommonException;
import cqut.keshe3.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;
import cqut.keshe3.dto.UserRegisterDto;

/**
* @author MaplesukiD
* @description 针对表【user】的数据库操作Service
* @createDate 2024-05-30 22:24:17
*/
public interface UserService extends IService<User> {

    // 登录
    String login(User user) throws CommonException;

    // 注册
    void register(UserRegisterDto userRegisterDto) throws CommonException;

    // 退出
    void logout(String token);

    // 分页查询（条件）
    Page<User> getUserPage(int currentPage, int pageSize, String username, String sex, String address);
}
