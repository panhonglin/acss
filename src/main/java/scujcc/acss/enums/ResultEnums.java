package scujcc.acss.enums;

/**
 * 反馈结果变量
 * @author CZM
 * @create 2018-10-20 上午 12:37
 */
public enum  ResultEnums {
    /*
    列举各种异常信息的代码和错误信息
    系统用0-99
    文件用100-199
    EXCEL用200-299
    数据库用300-399
     */
    UNKNOW_ERROR(-1,"未知错误"),
    //系统
    SYSTEM_SUCCESS(0,"成功"),
    SYSTEM_FAILED(1,"失败"),
    SYSTEM_UPLOAD_FILE_TO_LARGE(2,"上传文件过大"),
    SYSTEM_UPLOAD_FILE_TIMEOUT(3,"上传文件超时"),
    SYSTEM_UPLOAD_FILE_TYPE_ILLEGAL(4,"上传文件类型非法"),
    //文件
    FILE_READ_FAILED(100,"文件读取失败"),
    FILE_WRITE_FAILED(101,"文件写入失败"),
    //Excel
    EXCEL_UNKNOW_KEY_NAME(201,"未知键名"),
    EXCEL_NULL_VALUE(202,"空值"),
    //数据库
    DATABASES_CONNECTION_FAILED(301,"数据库连接失败"),
    DATABASES_INSERTTION_FAILED(302,"数据库插入失败"),
    DATABASES_UPDATE_FAILED(303,"数据库更新失败"),
    DATABASES_DELETE_FAILED(304,"数据库删除失败"),
    DATABASES_NO_QUERY_RESULTS(305,"无查询结果"),
    ;

    //错误代码
    private Integer code;
    //错误消息
    private String msg;

    /**
     * @Author CZM
     * @Description 构造函数，负责初始化错误代码和错误信息
     * @Date 下午 01:16 2018/10/20
     * @Param [code, msg]
     * @return 
     **/
    ResultEnums(Integer code,String msg){
        this.code = code;
        this.msg = msg;
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

