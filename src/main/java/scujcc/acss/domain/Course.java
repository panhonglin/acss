package scujcc.acss.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 课程实体
 * @author CZM
 * @create 2018-10-20 上午 12:36
 */
@Entity
public class Course {
    //TODO
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //自增的ID
    private Integer CourseId;
    //年级
    private Integer grade;
    //课程代码
    private String courseCode;
    //课程名称
    private String courseName;
    //课程性质
    private String courseType;
    //学分
    private Double credit;
    //教师名字
    private String teacherName;
    //选课人数
    private Integer studentNumber;
    //上课时间
    private String[] classTime;
    //上课地点
    private String[] classLocations;
    //上课班级
    private String[] classComposition;
    //总学时
    private Double totalPerido;
    //上课时长
    private Integer courseLength;
    //上课周数
    private Integer weekNumber;

    public Integer getCourseId() {
        return CourseId;
    }

    public void setCourseId(Integer courseId) {
        CourseId = courseId;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public Double getCredit() {
        return credit;
    }

    public void setCredit(Double credit) {
        this.credit = credit;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Integer getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(Integer studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String[] getClassTime() {
        return classTime;
    }

    public void setClassTime(String[] classTime) {
        this.classTime = classTime;
    }

    public String[] getClassLocations() {
        return classLocations;
    }

    public void setClassLocations(String[] classLocations) {
        this.classLocations = classLocations;
    }

    public String[] getClassComposition() {
        return classComposition;
    }

    public void setClassComposition(String[] classComposition) {
        this.classComposition = classComposition;
    }

    public Double getTotalPerido() {
        return totalPerido;
    }

    public void setTotalPerido(Double totalPerido) {
        this.totalPerido = totalPerido;
    }

    public Integer getCourseLength() {
        return courseLength;
    }

    public void setCourseLength(Integer courseLength) {
        this.courseLength = courseLength;
    }

    public Integer getWeekNumber() {
        return weekNumber;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public void setWeekNumber(Integer weekNumber) {
        this.weekNumber = weekNumber;
    }
}
