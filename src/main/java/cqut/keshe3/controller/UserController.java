package cqut.keshe3.controller;

import cqut.keshe3.Exception.CommonException;
import cqut.keshe3.common.Code;
import cqut.keshe3.common.Result;
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

}
