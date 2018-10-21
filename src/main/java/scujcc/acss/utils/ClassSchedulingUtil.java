package scujcc.acss.utils;

import javafx.beans.binding.ObjectExpression;
import org.springframework.beans.factory.annotation.Autowired;
import scujcc.acss.domain.Course;
import scujcc.acss.domain.Teacher;
import scujcc.acss.repository.ClassroomRepository;
import scujcc.acss.repository.CourseRepository;
import scujcc.acss.repository.TeacherRepository;

/**
 * 排课相关的工具
 * @author CZM
 * @create 2018-10-20 上午 11:38
 */
public class ClassSchedulingUtil {

    //教室、教室、课程的jap接口
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private ClassroomRepository classroomRepository;
    @Autowired
    private CourseRepository courseRepository;

    /**
     * @Author CZM
     * @Description 指定单个课程的上课时间
     * @Date 上午 10:43 2018/10/21
     * @Param [teacher, course, times] [教师，课程，时间表]
     * @return java.lang.Object
     **/
    public Object designatedSingleClassTime(Teacher teacher, Course course, String[] times){
//        teacher.updateTeacherDesignationClassTime(times);
        //return teacherRepository.save(teacher);
        return null;
    }

    /**
     * @Author CZM
     * @Description 指定多个课程的上课时间
     * @Date 上午 10:56 2018/10/21
     * @Param [teacher, courses, times]
     * @return java.lang.Object
     **/
    public Object designatedMultipleClassTime(Teacher teacher, Course[] courses,String[] times){
        //TODO
        return teacherRepository.save(teacher);
    }

    /**
     * @Author CZM
     * @Description 指定单个课程的不能上课的时间
     * @Date 上午 10:44 2018/10/21
     * @Param [teacher, course, times] [教师，课程，时间表]
     * @return java.lang.Object
     **/
    public Object designatedSingleNotClassTime(Teacher teacher,Course course,String[] times){
        //TODO
        return teacherRepository.save(teacher);
    }

    /**
     * @Author CZM
     * @Description 指定多个课程不能上课的时间
     * @Date 上午 10:56 2018/10/21
     * @Param [teacher, course, times]
     * @return java.lang.Object
     **/
    public Object designatedMultipleNotClassTime(Teacher teacher,Course[] course,String[] times){
        return teacherRepository.save(teacher);
    }

    /**
     * @Author CZM
     * @Description 指定上课地点
     * @Date 上午 10:45 2018/10/21
     * @Param [teacher, course, locations] [教室，课程，地点]
     * @return java.lang.Object
     **/
    public Object designatedSingleClassLocation(Teacher teacher,Course course,String[] locations){
        //TODO
        return teacherRepository.save(teacher);
    }

    /**
     * @Author CZM
     * @Description 指定多个课程的上课地点
     * @Date 上午 10:57 2018/10/21
     * @Param [teacher, course, locations]
     * @return java.lang.Object
     **/
    public Object designatedMultipleClassLOcations(Teacher teacher,Course[] course,String[] locations){
        return teacherRepository.save(teacher);
    }

    /**
     * @Author CZM
     * @Description 指定单个课程上课的时间和地点
     * @Date 上午 10:47 2018/10/21
     * @Param [teacher, course, locations, times]
     * @return java.lang.Object
     **/
    public Object designatedSingleClassLocationAndTime(Teacher teacher,Course course,String[] locations,String[] times){
        //TODO
        return teacherRepository.save(teacher);
    }

    /**
     * @Author CZM
     * @Description 指定多个课程的上课地点和时间
     * @Date 上午 10:58 2018/10/21
     * @Param [teacher, courses, locations, times]
     * @return java.lang.Object
     **/
    public Object designatedMultipleClassLOcationsAndTimes(Teacher teacher,Course[] courses,String[] locations,String[] times){
        return teacherRepository.save(teacher);
    }

    /**
     * @Author CZM
     * @Description 指定上课时间，不指定具体是那个课程
     * @Date 上午 11:01 2018/10/21
     * @Param [teacher, times]
     * @return java.lang.Object
     **/
    public Object designatedTimes(Teacher teacher,String[] times){
        //teacher.setTeacherDesignationClassTime(times);
        //return teacherRepository.save(teacher);
        return null;
    }

    /**
     * @Author CZM
     * @Description 指定上课地点，不指定具体是那个课程
     * @Date 上午 11:01 2018/10/21
     * @Param [teacher, locations]
     * @return java.lang.Object
     **/
    public Object designatedLocations(Teacher teacher,String[] locations){
        return teacherRepository.save(teacher);
    }
    
    /**
     * @Author CZM
     * @Description 指定上课时间和地点，不指定是那个具体的课程
     * @Date 上午 11:01 2018/10/21
     * @Param [teacher, locations, times]
     * @return java.lang.Object
     **/
    public Object designatedLocationsAndTimes(Teacher teacher,String[] locations,String[] times) {
        return teacherRepository.save(teacher);
    }
    
    /**
     * @Author CZM
     * @Description 排课算法，所有的数据均从数据库和对象中获取
     * @Date 下午 02:34 2018/10/21
     * @Param []
     * @return void
     **/
    public void scheduling(){

    }
}
