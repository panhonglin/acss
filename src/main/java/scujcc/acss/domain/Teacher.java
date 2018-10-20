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
public class Teacher {
    //TODO
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //自增的ID
    private Integer teacherId;
    //教师姓名
    private String teacherName;
    //教学班组成
    private String[] classComposition;

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }


    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String[] getClassComposition() {
        return classComposition;
    }

    public void setClassComposition(String[] classComposition) {
        this.classComposition = classComposition;
    }

    /**
     * @Author CZM
     * @Description 转换为字符串
     * @Date 下午 01:16 2018/10/20
     * @Param []
     * @return java.lang.String
     **/
    @Override
    public String toString() {
        return super.toString();
    }
}
