package cqut.keshe3.controller;

import cqut.keshe3.Exception.LoginException;
import cqut.keshe3.common.Code;
import cqut.keshe3.common.Result;
import cqut.keshe3.domain.User;
import cqut.keshe3.dto.UserDto;
import cqut.keshe3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.security.SecureRandom;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author MaplesukiD
 * @since 2024/6/2 16:59
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate redisTemplate;

    @PostMapping("/login")
    public Result<String> login(@RequestBody User user){
        try {
            String token = userService.login(user);
            return new Result<>(Code.LOGIN_OK, token, Code.LOGIN_OK_MESSAGE);
        }catch (LoginException e){
            return new Result<>(Code.LOGIN_ERR, e.getMessage());
        }
    }

}
