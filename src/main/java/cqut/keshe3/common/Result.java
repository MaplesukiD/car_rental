package cqut.keshe3.common;

/**
 *
 * 返回给页面的统一格式的数据
 * @author MaplesukiD
 * @since 2024/6/2 17:10
 */
public class Result {

    private Object data;
    private Integer code;
    private String message;
    private String token;

    public Result() {

    }

    public Result(Integer code, Object data) {
        this.data = data;
        this.code = code;
    }

    public Result(Integer code, String message) {
        this.message = message;
        this.code = code;
    }

    public Result(Integer code, Object data, String message) {
        this.data = data;
        this.code = code;
        this.message = message;
    }

    public Result(Integer code, Object data, String token, String message) {
        this.data = data;
        this.code = code;
        this.token = token;
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getToken(){
        return token;
    }

}
