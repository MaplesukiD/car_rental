package cqut.keshe3.Exception;

/**
 通用异常类
 */
public class CommonException extends Exception{

    // 异常信息
    private String message;

    public CommonException(String message) {
        super(message);
        this.message = message;
    }
}
