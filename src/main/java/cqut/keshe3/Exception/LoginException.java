package cqut.keshe3.Exception;

/**
 登录异常类

 */
public class LoginException extends Exception{

    // 异常信息
    private String message;

    public LoginException(String message) {
        super(message);
        this.message = message;
    }
}
