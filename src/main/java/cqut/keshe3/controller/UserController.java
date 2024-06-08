package cqut.keshe3.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cqut.keshe3.Exception.CommonException;
import cqut.keshe3.common.Code;
import cqut.keshe3.common.Result;
import cqut.keshe3.domain.Car;
import cqut.keshe3.domain.User;
import cqut.keshe3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author MaplesukiD
 * @since 2024/6/2 16:59
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     登录
     * @param user
     * @return: cqut.keshe3.common.Result<java.lang.String>
     */
    @PostMapping("/login")
    public Result<String> login(@RequestBody User user){
        try {
            String token = userService.login(user);
            return new Result<>(Code.LOGIN_OK, token, Code.LOGIN_OK_MESSAGE);
        }catch (CommonException e){
            return new Result<>(Code.LOGIN_ERR, e.getMessage());
        }
    }

    /**
     用户注册
     * @param user
     * @return: cqut.keshe3.common.Result<java.lang.String>
     */
    @PostMapping("/register")
    public Result<String> register(@RequestBody User user){
        try {
            userService.register(user);
            return new Result<>(Code.SAVE_OK, Code.SAVE_OK_MESSAGE);
        }catch (CommonException e){
            return new Result<>(Code.SAVE_ERR, e.getMessage());
        }
    }

    @PostMapping("/logout/{token}")
    public Result<String> logout(@PathVariable String token){
        userService.logout(token);
        return new Result<>(Code.LOGOUT_OK, Code.LOGOUT_OK_MESSAGE);
    }

    /**
     分页查询（条件：用户名、性别、地址）
     * @param currentPage
     * @param pageSize
     * @param username
     * @param sex
     * @param address
     * @return: cqut.keshe3.common.Result<com.baomidou.mybatisplus.extension.plugins.pagination.Page<cqut.keshe3.domain.User>>
     */
    @GetMapping("/page")
    public Result<Page<User>> getPage(@RequestParam int currentPage, @RequestParam int pageSize, @RequestParam String username, @RequestParam String sex, @RequestParam String address) {
        Page<User> userPage = userService.getUserPage(currentPage, pageSize, username, sex, address);
        return new Result<>(Code.GET_OK, userPage, Code.GET_OK_MESSAGE);
    }

    /**
     根据id查询用户信息
     * @param id
     * @return: cqut.keshe3.common.Result<cqut.keshe3.domain.User>
     */
    @GetMapping
    public Result<User> getUserById(@RequestParam Integer id){
        User user = userService.getById(id);
        return new Result<>(Code.GET_OK, user, Code.GET_OK_MESSAGE);
    }

    /**
     更新用户信息
     * @param user
     * @return: cqut.keshe3.common.Result<java.lang.String>
     */
    @PutMapping
    public Result<String> updateUser(@RequestBody User user){
        System.out.println(user);
        userService.updateById(user);
        return new Result<>(Code.UPDATE_OK, Code.UPDATE_OK_MESSAGE);
    }

    /**
     新增用户信息
     * @param user
     * @return: cqut.keshe3.common.Result<java.lang.String>
     */
    @PostMapping
    public Result<String> addUser(@RequestBody User user){
        userService.save(user);
        return new Result<>(Code.SAVE_OK, Code.SAVE_OK_MESSAGE);
    }

}
