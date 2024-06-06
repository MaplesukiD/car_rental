package cqut.keshe3.common;

/**
 *
 *
 * Code常量
 * 规定返回状态值和相关含义
 * @author MaplesukiD
 * @since 2024/6/2 17:04
 */
public class Code {
    //成功
    public static final Integer SAVE_OK = 50011;
    public static final String SAVE_OK_MESSAGE="创建成功";

    public static final Integer DELETE_OK = 50021;
    public static final String DELETE_OK_MESSAGE="删除成功";

    public static final Integer UPDATE_OK = 50031;
    public static final String UPDATE_OK_MESSAGE="修改成功";

    public static final Integer GET_OK = 50041;
    public static final String GET_OK_MESSAGE="查询成功";

    public static final Integer LOGIN_OK = 50051;
    public static final String LOGIN_OK_MESSAGE="登录成功";

    public static final Integer PUSH_OK = 50061;
    public static final String PUSH_OK_MESSAGE="发布成功";

    public static final Integer LOGOUT_OK = 50071;
    public static final String LOGOUT_OK_MESSAGE = "退出成功";

    //失败
    public static final Integer SAVE_ERR = 50010;
    public static final String SAVE_ERR_MESSAGE="注册失败";

    public static final Integer DELETE_ERR = 50020;
    public static final String DELETE_ERR_MESSAGE="删除失败";

    public static final Integer UPDATE_ERR = 50030;
    public static final String UPDATE_ERR_MESSAGE="修改失败";

    public static final Integer GET_ERR = 50040;
    public static final String GET_ERR_MESSAGE="查询失败";

    public static final Integer LOGIN_ERR = 50050;
    public static final String LOGIN_ERR_MESSAGE="登录失败";

    public static final Integer PUSH_ERR = 50060;
    public static final String PUSH_ERR_MESSAGE="发布失败";

}
