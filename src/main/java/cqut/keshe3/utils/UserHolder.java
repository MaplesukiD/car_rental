package cqut.keshe3.utils;

import cqut.keshe3.dto.UserDto;

/**
 * @author MaplesukiD
 * @since 2024/6/12 19:13
 */
public class UserHolder {
    private static final ThreadLocal<UserDto> tl = new ThreadLocal<>();

    public static void saveUser(UserDto user){
        tl.set(user);
    }

    public static UserDto getUser(){
        return tl.get();
    }

    public static void removeUser(){
        tl.remove();
    }
}
