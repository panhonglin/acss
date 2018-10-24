package scujcc.acss.controller;

import com.sun.media.sound.SoftTuning;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import scujcc.acss.domain.Course;
import scujcc.acss.domain.Teacher;
import scujcc.acss.repository.ClassroomRepository;
import scujcc.acss.repository.CourseRepository;
import scujcc.acss.repository.TeacherRepository;
import scujcc.acss.utils.ExcelUtil;
import scujcc.acss.utils.FileUploadUtil;

import java.util.List;
import java.util.Map;

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
    
    /**
     * @Author CZM
     * @Description 这是读取excel内容到数据库的测试案例，不要执行
     * @Date 上午 10:13 2018/10/24
     * @Param []
     * @return void
     **/

    /*
    @GetMapping(value ="/acss/test")
    public void test(){
        ExcelUtil dasan = new ExcelUtil("F:\\big_data_technology\\实战Hadoop\\排课系统\\大三方向课开设计划.xlsx");
        ExcelUtil dayi = new ExcelUtil("F:\\big_data_technology\\实战Hadoop\\排课系统\\大一大二课表.xls");
        Map<Integer, Map<String, String>> dasandata = dasan.read().toMap();
        Map<Integer, Map<String, String>> dayidata = dayi.read().toMap();
        for (int i =1;i<=dasandata.size();i++) {
            Map<String,String> temp = dasandata.get(i);
            Teacher teacher = new Teacher();
            teacher.setTeacherName(temp.get("教师"));
            teacher.setClassComposition(new String[]{temp.get("方向")});
            Course course = new Course();
            course.setGrade(Integer.valueOf(temp.get("年级")));
            course.setCourseCode(temp.get("课程号"));
            course.setCredit(Double.valueOf(temp.get("学分")));
            course.setTeacherName(temp.get("教师"));
            course.setStudentNumber(Integer.valueOf(temp.get("人数")));
            course.setTotalPeriod(Double.valueOf(temp.get("总学时")));
            course.setCourseType("专业方向课");
            course.setCourseName(temp.get("课程名称"));
            course.setCourseLength(Double.valueOf(temp.get("学分"))>2?4:2);
            course.setWeekNumber((int) (course.getTotalPeriod()/course.getCourseLength()));
            teacherRepository.save(teacher);
            courseRepository.save(course);
        }
        System.out.println("\n\nthis is line\n\n");
        for (int i =1;i<=dayidata.size();i++) {
            Map<String,String> temp = dayidata.get(i);
            Course course = new Course();
            course.setGrade(Integer.valueOf(temp.get("年级")));
            course.setCourseCode(temp.get("课程代码"));
            course.setCredit(Double.valueOf(temp.get("学分")));
            course.setTeacherName(temp.get("教师姓名"));
            course.setStudentNumber(Integer.valueOf(temp.get("选课人数")));
            course.setTotalPeriod(Double.valueOf(temp.get("总学时")));
            course.setCourseType("课程性质");
            course.setCourseName(temp.get("课程名称"));
            course.setCourseLength(Double.valueOf(temp.get("学分"))>2?4:2);
            course.setWeekNumber((int) (course.getTotalPeriod()/course.getCourseLength()));
            course.setClassTime(ExcelUtil.splitClassTime(temp.get("上课时间")));
            course.setClassLocations(ExcelUtil.splitClassLocations(temp.get("上课地点")));
            course.setClassComposition(ExcelUtil.splitClassComposition(temp.get("教学班组成")));
            courseRepository.save(course);
        }
    }
    */

}
