package scujcc.acss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import scujcc.acss.domain.Course;

import java.util.List;

/**
 * @author CZM
 * @create 2018-10-20 下午 05:59
 */
public interface CourseRepository extends JpaRepository<Course,Integer> {
    public Course findByCourseId(Integer courseId);
    public List<Course> findAllByGrade(Integer grade);
    public Course findByCourseCode(String courseCode);
    public List<Course> findAllByCourseName(String courseName);
    public List<Course> findAllByCourseType(String courseType);
    public List<Course> findAllByCredit(Double credit);
    public List<Course> findAllByTeacherName(String teacherName);
    public List<Course> findAllByStudentNumber(Integer studentNumber);
    public List<Course> findAllByTotalPeriod(Double totalPeriod);
    public List<Course> findAllByCourseLength(Integer courseLength);
    public List<Course> findAllByWeekNumber(Integer weekNumber);
}
