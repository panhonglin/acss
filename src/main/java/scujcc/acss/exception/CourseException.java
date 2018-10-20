package scujcc.acss.exception;

import scujcc.acss.enums.ResultEnums;

/**
 * 课程的异常
 * @author CZM
 * @create 2018-10-20 上午 12:43
 */
public class CourseException extends RuntimeException {
    private Integer code;
    private String msg;
    //TODO
    /**
     * @Author CZM
     * @Description 初始化异常
     * @Date 下午 01:16 2018/10/20
     * @Param [resultEnums]
     * @return 
     **/
    public CourseException(ResultEnums resultEnums){
        super(resultEnums.getMsg());
        this.code = resultEnums.getCode();
    }
    //TODO

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
}
