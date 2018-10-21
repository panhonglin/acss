package scujcc.acss.domain;

import sun.util.resources.ca.CalendarData_ca;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Map;

/**
 * 课程实体
 * @author CZM
 * @create 2018-10-20 上午 12:36
 */
@Entity
public class Course {
    /**
     * 四个、三个学分上四节课，分别上16周和12周，两个、一个学分上两节课，分别是16周，8周
     **/

    //TODO
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //自增的ID
    private Integer courseId;
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
    //private String[] classTime;
    private Map<String, Map<String,Boolean>> classTime;
    //上课地点
    private String[] classLocations;
    //上课班级
    private String[] classComposition;
    //总学时
    private Double totalPeriod;
    //上课时长
    private Integer courseLength;
    //上课周数
    private Integer weekNumber;

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
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

    public Map<String, Map<String, Boolean>> getClassTime() {
        return classTime;
    }

    public void setClassTime(Map<String, Map<String, Boolean>> classTime) {
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

    public Double getTotalPeriod() {
        return totalPeriod;
    }

    public void setTotalPeriod(Double totalPeriod) {
        this.totalPeriod = totalPeriod;
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

    /**
     * @Author CZM
     * @Description 转换为字符串
     * @Date 下午 01:14 2018/10/20
     * @Param []
     * @return java.lang.String
     **/
    @Override
    public String toString() {
        String string = "";
        string += "{";
        string += "courseId="+courseId;
        string += ", grade="+grade;
        string += ", courseCode='"+courseCode+"'";
        string += ", courseName='"+courseName+"'";
        string += ", courseType='"+courseType+"'";
        string += ", credit"+credit;
        string += ", teacherName='"+teacherName+"'";
        string += ", studentNumber="+studentNumber;
        string += ", classTime=[";
        for (String key1:classTime.keySet()){
            string += "key='"+key1+"', values=[";
            Map<String,Boolean> temp = classTime.get(key1);
            for (String key2:temp.keySet()) {
                string += "[ key='"+key2+"', value='"+temp.get(key2)+"'], ";
            }
            string += "], ";
        }
        string += "], ";
        string += ", classLocation=[";
        for (String s:classLocations) {
            string += "'"+s+"', ";
        }
        string += "], ";
        string += ", classComposition=[";
        for (String s:classComposition) {
            string += "'"+s+"', ";
        }
        string += "], totalPeriod=" + totalPeriod;
        string += ", courseLength=" + courseLength;
        string += ", weekNumber=" + weekNumber;
        string += "}";
        return string;
    }

    public void setWeekNumber(Integer weekNumber) {
        this.weekNumber = weekNumber;
    }
}
