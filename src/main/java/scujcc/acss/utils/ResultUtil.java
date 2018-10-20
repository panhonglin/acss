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
    //输出正确和相关数据
    public static Result success(Object object){
        Result result = new Result();
        result.setCode(ResultEnums.SYSTEM_SUCCESS.getCode());
        result.setMsg(ResultEnums.SYSTEM_SUCCESS.getMsg());
        result.setData(object);
        return result;
    }
    public static Result success(){
        return success(null);
    }
    //输出错误和相关信息
    public static Result error(Integer code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
