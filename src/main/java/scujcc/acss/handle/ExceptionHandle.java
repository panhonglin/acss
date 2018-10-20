package scujcc.acss.handle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import scujcc.acss.domain.Result;
import scujcc.acss.enums.ResultEnums;
import scujcc.acss.exception.*;
import scujcc.acss.utils.ResultUtil;

/**
 * 统一异常处理
 * @author CZM
 * @create 2018-10-20 上午 12:47
 */
@ControllerAdvice
public class ExceptionHandle {
    //日志
    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    /**
     * @Author CZM
     * @Description 统一异常处理
     * @Date 下午 01:07 2018/10/20
     * @Param [e]
     * @return scujcc.acss.domain.Result
     **/
    public Result handle(Exception e){
        //TODO
        if (e instanceof ClassroomException) {
            ClassroomException classroomException = (ClassroomException) e;
            return ResultUtil.error(classroomException.getCode(), classroomException.getMsg());
        } else if (e instanceof CourseException) {
            CourseException courseException = (CourseException) e;
            return ResultUtil.error(courseException.getCode(), courseException.getMsg());
        } else if (e instanceof TeacherException) {
            TeacherException teacherException = (TeacherException) e;
            return ResultUtil.error(teacherException.getCode(), teacherException.getMsg());
        } else if (e instanceof SystemException) {
            SystemException systemException = (SystemException) e;
            return ResultUtil.error(systemException.getCode(), systemException.getMsg());
        } else if (e instanceof FileException) {
            FileException fileException = (FileException) e;
            return ResultUtil.error(fileException.getCode(), fileException.getMsg());
        } else if (e instanceof DatabasesException) {
            DatabasesException databasesException = (DatabasesException) e;
            return ResultUtil.error(databasesException.getCode(), databasesException.getMsg());
        } else if (e instanceof ExcelException) {
            ExcelException excelException = (ExcelException) e;
            return ResultUtil.error(excelException.getCode(),excelException.getMsg());
        } else {
            logger.error("【系统异常】{}",e);
            return ResultUtil.error(ResultEnums.UNKNOW_ERROR.getCode(),ResultEnums.UNKNOW_ERROR.getMsg());
        }
    }
}
