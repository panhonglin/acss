package scujcc.acss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import scujcc.acss.domain.Course;

import java.util.List;

/**
 * @author CZM
 * @create 2018-10-20 上午 12:52
 */
public interface CourseRepository extends JpaRepository<Course,Integer> {
    //TODO
    /**
     * @Author CZM
     * @Description 通过ID来找
     * @Date 下午 01:08 2018/10/20
     * @Param [courseId]
     * @return scujcc.acss.domain.Course
     **/
    public Course findByCourseId(Integer courseId);
    /**
     * @Author CZM
     * @Description 通过年级来找
     * @Date 下午 01:09 2018/10/20
     * @Param [grade]
     * @return java.util.List<scujcc.acss.domain.Course>
     **/
    public List<Course> findByGrade(Integer grade);
    /**
     * @Author CZM
     * @Description 通过课程代码来找
     * @Date 下午 01:09 2018/10/20
     * @Param [courseCode]
     * @return scujcc.acss.domain.Course
     **/
    public Course findByCourseCode(String courseCode);
    /**
     * @Author CZM
     * @Description 课程名称
     * @Date 下午 01:09 2018/10/20
     * @Param [courseName]
     * @return java.util.List<scujcc.acss.domain.Course>
     **/
    public List<Course> findByCourseName(String courseName);
    /**
     * @Author CZM
     * @Description 课程性质
     * @Date 下午 01:10 2018/10/20
     * @Param [courseType]
     * @return java.util.List<scujcc.acss.domain.Course>
     **/
    public List<Course> findByCourseType(String courseType);
    /**
     * @Author CZM
     * @Description 学分
     * @Date 下午 01:10 2018/10/20
     * @Param [credit]
     * @return java.util.List<scujcc.acss.domain.Course>
     **/
    public List<Course> findByCredit(Double credit);
    /**
     * @Author CZM
     * @Description 教师名字
     * @Date 下午 01:11 2018/10/20
     * @Param [teacherName]
     * @return java.util.List<scujcc.acss.domain.Course>
     **/
    public List<Course> findByTeacherName(String teacherName);
    /**
     * @Author CZM
     * @Description 选课人数
     * @Date 下午 01:11 2018/10/20
     * @Param [studentNumber]
     * @return java.util.List<scujcc.acss.domain.Course>
     **/
    public List<Course> findByStudentNumber(Integer studentNumber);
    /**
     * @Author CZM
     * @Description 上课时间
     * @Date 下午 01:11 2018/10/20
     * @Param [classTime]
     * @return java.util.List<scujcc.acss.domain.Course>
     **/
    public List<Course> findByClassTime(String classTime);
    /**
     * @Author CZM
     * @Description 上课地点
     * @Date 下午 01:11 2018/10/20
     * @Param [classLocations]
     * @return java.util.List<scujcc.acss.domain.Course>
     **/
    public List<Course> findByClassLocations(String classLocations);
    /**
     * @Author CZM
     * @Description 上课班级
     * @Date 下午 01:12 2018/10/20
     * @Param [classComposition]
     * @return java.util.List<scujcc.acss.domain.Course>
     **/
    public List<Course> findByClassCompositon(String classComposition);
    /**
     * @Author CZM
     * @Description 总学时
     * @Date 下午 01:12 2018/10/20
     * @Param [totalPerido]
     * @return java.util.List<scujcc.acss.domain.Course>
     **/
    public List<Course> findByTotalPerido(Double totalPerido);
    /**
     * @Author CZM
     * @Description 上课时长
     * @Date 下午 01:13 2018/10/20
     * @Param [courseLength]
     * @return java.util.List<scujcc.acss.domain.Course>
     **/
    public List<Course> findByCourseLength(Integer courseLength);
    /**
     * @Author CZM
     * @Description 上课周数
     * @Date 下午 01:14 2018/10/20
     * @Param [weekNumber]
     * @return java.util.List<scujcc.acss.domain.Course>
     **/
    public List<Course> findByWeekNumber(Integer weekNumber);
}
