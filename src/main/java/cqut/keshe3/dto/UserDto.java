package cqut.keshe3.dto;

import lombok.Data;

/**
    返回前端用户信息
 */

@Data
public class UserDto {

    /**
     * 用户id
     */
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 身份证号
     */
    private String identity;

    /**
     * 真名
     */
    private String realName;

    /**
     * 性别 0-男 1-女
     */
    private Integer sex;

    /**
     * 地址
     */
    private String address;

    /**
     * 类型 0-管理 1-用户
     */
    private Integer type;

}
