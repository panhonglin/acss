package scujcc.acss.domain;

/**
 * 反馈结果
 * @author CZM
 * @create 2018-10-20 上午 12:38
 */
public class Result<T> {
    //TODO
    //错误码
    private Integer code;
    //错误消息体
    private String msg;
    //具体内容
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
