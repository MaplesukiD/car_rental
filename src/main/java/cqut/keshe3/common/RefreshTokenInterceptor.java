package cqut.keshe3.common;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSONUtil;
import cqut.keshe3.dto.UserDto;
import cqut.keshe3.utils.UserHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.concurrent.TimeUnit;


public class RefreshTokenInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取请求头中的token
        String token = request.getHeader("Authorization");
        if(ObjectUtils.isEmpty(token)){
            return true;
        }
        //消除Bearer
        String key=token.substring(7);
        //基于token获取redis用户
        Object user = redisTemplate.opsForValue().get(key);
        UserDto userDto= BeanUtil.toBean(user,UserDto.class);
        //将用户存在ThreadLocal
        UserHolder.saveUser(userDto);
        //刷新token有效期
        redisTemplate.expire(token,30, TimeUnit.MINUTES);
        return true;

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        UserHolder.removeUser();
    }
}
