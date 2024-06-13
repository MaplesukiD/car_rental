package cqut.keshe3.config;

import cqut.keshe3.common.LoginInterceptor;
import cqut.keshe3.common.RefreshTokenInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * 拦截器
 * @author MaplesukiD
 * @since 2024/6/2 17:13
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(refreshTokenInterceptor())
                .addPathPatterns("/**").order(0);
        registry.addInterceptor(loginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns(
                        "/user/login",
                        "/user/register",
                        "/user/me",
                        "/user/logout"
                ).order(1);
    }

    @Bean
    public RefreshTokenInterceptor refreshTokenInterceptor(){
        return new RefreshTokenInterceptor();
    }
    @Bean
    public LoginInterceptor loginInterceptor(){
        return new LoginInterceptor();
    }

}