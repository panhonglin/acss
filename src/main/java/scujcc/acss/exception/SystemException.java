package scujcc.acss.exception;
/**
 * @author CZM
 * @create 2018-10-20 下午 04:03
 */

import scujcc.acss.enums.ResultEnums;

/**
 *@ClassNmae SystemException
 *@Description 系统相关异常
 *@Author CZM
 *@Date 2018/10/20 下午 04:03
 *@Version 1.0
 **/
public class SystemException extends RuntimeException {
    private Integer code;
    private String msg;
    
    /**
     * @Author CZM
     * @Description 初始化异常
     * @Date 下午 04:11 2018/10/20
     * @Param [resultEnums]
     * @return 
     **/
    public SystemException(ResultEnums resultEnums){
        super(resultEnums.getMsg());
        this.code = resultEnums.getCode();
    }

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
