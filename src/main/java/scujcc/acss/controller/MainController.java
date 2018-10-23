package scujcc.acss.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import scujcc.acss.domain.Teacher;
import scujcc.acss.repository.ClassroomRepository;
import scujcc.acss.repository.CourseRepository;
import scujcc.acss.repository.TeacherRepository;
import scujcc.acss.utils.FileUploadUtil;

import java.util.List;

/**
 * 主要的控制器，负责相应请求
 * @author CZM
 * @create 2018-10-20 上午 12:33
 */
@RestController
public class MainController {

    private final static Logger logger = LoggerFactory.getLogger(MainController.class);
    @Autowired
    private ClassroomRepository classroomRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private TeacherRepository teacherRepository;

    //TODO
    /**
     * @Author CZM
     * @Description 上传文件用
     * @Date 下午 11:10 2018/10/20
     * @Param [request]
     * @return void
     **/
    @PostMapping(value = "/acss/upload")
    public void upload(@RequestBody HttpServletRequest request) throws Exception {
        (new FileUploadUtil()).getFile(request);
    }
    //高攀测试分支合并
}
