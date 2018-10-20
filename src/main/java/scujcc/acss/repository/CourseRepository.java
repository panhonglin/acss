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
    //通过ID来找
    public Course findByCourseId(Integer courseId);
    //通过年级来找
    public List<Course> findByGrade(Integer grade);
    //通过课程代码来找
    public Course findByCourseCode(String courseCode);
    //课程名称
    public List<Course> findByCourseName(String courseName);
    //课程性质
    public List<Course> findByCourseType(String courseType);
    //学分
    public List<Course> findByCredit(Double credit);
    //教师名字
    public List<Course> findByTeacherName(String teacherName);
    //选课人数
    public List<Course> findByStudentNumber(Integer studentNumber);
    //上课时间
    public List<Course> findByClassTime(String classTime);
    //上课地点
    public List<Course> findByClassLocations(String classLocations);
    //上课班级
    public List<Course> findByClassCompositon(String classComposition);
    //总学时
    public List<Course> findByTotalPerido(Double totalPerido);
    //上课时长
    public List<Course> findByCourseLength(Integer courseLength);
    //上课周数
    public List<Course> findByWeekNumber(Integer weekNumber);
}
