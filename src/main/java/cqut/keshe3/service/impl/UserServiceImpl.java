package cqut.keshe3.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cqut.keshe3.Exception.LoginException;
import cqut.keshe3.common.Result;
import cqut.keshe3.domain.User;
import cqut.keshe3.dto.UserDto;
import cqut.keshe3.service.UserService;
import cqut.keshe3.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
* @author MaplesukiD
* @description 针对表【user】的数据库操作Service实现
* @createDate 2024-05-30 22:24:17
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate redisTemplate;


    @Override
    public String login(User user) throws LoginException {
        // 1. 取出username 、 password 、 type
        String username = user.getUsername();
        String password = user.getPassword();

        // 2. 匹配用户名
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        lqw.eq(User::getUsername, username);
        User temp = userMapper.selectOne(lqw);
        if(temp == null){
            throw new LoginException("用户名不存在");
        }

        // 3. 继续匹配密码
        if(!temp.getPassword().equals(password)){
            throw new LoginException("密码错误");
        }

        // 4. 查看账号活跃状态
        if(temp.getAvailable() == 0){
            throw new LoginException("您已被禁用");
        }

        // 5. 产看身份是否匹配
        UserDto userDto = BeanUtil.toBean(temp, UserDto.class);

        // 5. 将信息放入缓存
        String token = UUID.randomUUID().toString();
        if(redisTemplate.hasKey(token)){
            redisTemplate.delete(token);
        }
        redisTemplate.opsForValue().set(token, userDto, 1, TimeUnit.HOURS);
        return token;
    }

}




