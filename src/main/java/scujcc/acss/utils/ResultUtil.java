package scujcc.acss.utils;

import scujcc.acss.domain.Result;
import scujcc.acss.enums.ResultEnums;

/**
 * 反馈相关的工具
 * @author CZM
 * @create 2018-10-20 上午 12:58
 */
public class ResultUtil {
    //TODO
    /**
     * @Author CZM
     * @Description 输出正确和相关数据
     * @Date 下午 01:16 2018/10/20
     * @Param [object]
     * @return scujcc.acss.domain.Result
     **/
    public static Result success(Object object){
        Result result = new Result();
        result.setCode(ResultEnums.SYSTEM_SUCCESS.getCode());
        result.setMsg(ResultEnums.SYSTEM_SUCCESS.getMsg());
        result.setData(object);
        return result;
    }
    /**
     * @Author CZM
     * @Description 输出正确和相关数据
     * @Date 下午 01:17 2018/10/20
     * @Param []
     * @return scujcc.acss.domain.Result
     **/
    public static Result success(){
        return success(null);
    }
    /**
     * @Author CZM
     * @Description 输出错误和相关信息
     * @Date 下午 01:16 2018/10/20
     * @Param [code, msg]
     * @return scujcc.acss.domain.Result
     **/
    public static Result error(Integer code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
