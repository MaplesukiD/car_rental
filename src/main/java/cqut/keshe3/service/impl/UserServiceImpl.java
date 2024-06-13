package cqut.keshe3.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cqut.keshe3.Exception.CommonException;
import cqut.keshe3.domain.Car;
import cqut.keshe3.domain.User;
import cqut.keshe3.dto.UserDto;
import cqut.keshe3.service.UserService;
import cqut.keshe3.mapper.UserMapper;
import cqut.keshe3.utils.UserHolder;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;
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


    // 登录
    @Override
    public String login(User user) throws CommonException {
        // 1. 取出username 、 password 、 type
        String username = user.getUsername();
        String password = user.getPassword();

        // 2. 匹配用户名
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        lqw.eq(User::getUsername, username);
        User user1 = userMapper.selectOne(lqw);
        if(user1 == null){
            throw new CommonException("用户名不存在");
        }

        // 3. 继续匹配密码
        if(!user1.getPassword().equals(password)){
            throw new CommonException("密码错误");
        }

        // 4. 查看账号活跃状态
        if(user1.getAvailable() == 0){
            throw new CommonException("您已被禁用");
        }

        // 5. 将信息放入缓存
        String token= UUID.randomUUID().toString();
        UserDto userDto=BeanUtil.copyProperties(user1,UserDto.class);
        redisTemplate.opsForValue().set(token, userDto, 1, TimeUnit.HOURS);
        return token;
    }

    // 注册
    @Override
    public void register(User user) throws CommonException {
        // 传入数据：用户名、密码、真名、年龄、性别、身份证、地址
        // 缺少数据：类型、活跃状态

        // 1.添加缺少数据
        user.setAvailable(1);
        user.setType(1);

        // 2.查询账号是否存在
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        lqw.eq(User::getUsername, user.getUsername());
        User temp = userMapper.selectOne(lqw);
        if(temp != null){
            throw new CommonException("账号已存在");
        }

        // 3.插入账号
        userMapper.insert(user);
    }

    // 退出
    @Override
    public void logout(String token) {
        redisTemplate.delete(token.substring(7));
        UserHolder.removeUser();
    }

    // 分页查询（条件）
    @Override
    public Page<User> getUserPage(int currentPage, int pageSize, String username, String sex, String address) {
        // 1.构建分页构造器
        Page<User> page = new Page<>(currentPage, pageSize);

        // 2.构造条件构造器
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();

        // 3.添加条件
        // 3.1 添加username条件，不为空时模糊匹配
        lqw.like(StringUtils.isNotEmpty(username), User::getUsername, username);
        // 3.2 添加sex条件，不为空时匹配
        lqw.eq(StringUtils.isNotEmpty(sex), User::getSex, sex);
        // 3.3 添加address条件，不为空时模糊匹配
        lqw.like(StringUtils.isNotEmpty(address), User::getAddress, address);
        // 3.4 只查用户
        lqw.eq(User::getType, 1);

        //4.查询
        return userMapper.selectPage(page, lqw);
    }

}




