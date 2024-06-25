package cqut.keshe3.dto;

import lombok.Data;

/**
 * @ClassName UserRegisterDto
 * @Author zuenhu
 * @Date 2024/6/25 上午11:03
 */
@Data
public class UserRegisterDto {

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
    private String[] address;

    private String img;
    private String checkPass;
    private String password;

}
