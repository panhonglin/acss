package scujcc.acss.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 教室实体
 * @author CZM
 * @create 2018-10-20 上午 12:36
 */
@Entity
public class Classroom {
    //TODO
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //自增的ID
    private Integer classroomId;
    //教室的编号
    private Integer classroomNumber;
    //教室名字
    private String classroomName;
    //教室的座位数
    private Integer classroomSeatsNumber;
    //使用时间
    private String[] classroomUseTime;

    public String[] getClassroomUseTime() {
        return classroomUseTime;
    }

    public void setClassroomUseTime(String[] classroomUseTime) {
        this.classroomUseTime = classroomUseTime;
    }

    public Integer getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(Integer classroomId) {
        this.classroomId = classroomId;
    }

    public Integer getClassroomNumber() {
        return classroomNumber;
    }

    public void setClassroomNumber(Integer classroomNumber) {
        this.classroomNumber = classroomNumber;
    }

    public String getClassroomName() {
        return classroomName;
    }

    public void setClassroomName(String classroomName) {
        this.classroomName = classroomName;
    }

    public Integer getClassroomSeatsNumber() {
        return classroomSeatsNumber;
    }

    public void setClassroomSeatsNumber(Integer classroomSeatsNumber) {
        this.classroomSeatsNumber = classroomSeatsNumber;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
