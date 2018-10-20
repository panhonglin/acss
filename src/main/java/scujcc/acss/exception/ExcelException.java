package scujcc.acss.exception;
/**
 * @author CZM
 * @create 2018-10-20 下午 04:04
 */

import scujcc.acss.enums.ResultEnums;

/**
 *@ClassNmae ExcelException
 *@Description Excel相关的异常
 *@Author CZM
 *@Date 2018/10/20 下午 04:04
 *@Version 1.0
 **/
public class ExcelException extends RuntimeException {
    private Integer code;
    private String msg;
    
    /**
     * @Author CZM
     * @Description 初始化异常
     * @Date 下午 04:10 2018/10/20
     * @Param [resultEnums]
     * @return 
     **/
    public ExcelException(ResultEnums resultEnums){
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
