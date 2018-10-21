package scujcc.acss.domain;

import javax.persistence.*;

/**
 * 教师实体
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
    //教师指定的上课时间
    private String[] teacherDesignationClassTime;
    //教师指定的不能上课的时间
    private String[] teacherDesignationNotClassTime;
    //教师指定的上课地点
    private String[] teacherDesignationClassLocations;

    public void updateTeacherDesignationClassTime(String[] _teacherDesignationClassTime){
        if (this.teacherDesignationClassTime == null) {
            this.setTeacherDesignationClassTime(_teacherDesignationClassTime);
            return;
        }
        String[] temp = this.teacherDesignationClassTime;
        this.teacherDesignationClassTime = new String[temp.length+_teacherDesignationClassTime.length];
        int j =0;
        for (int i =0;i<temp.length;i++) {
            this.teacherDesignationClassTime[j++] = temp[i];
        }
        for (int i =0;i<_teacherDesignationClassTime.length;i++) {
            this.teacherDesignationClassTime[j++] = temp[i];
        }
    }

    public String[] getTeacherDesignationClassTime() {
        return teacherDesignationClassTime;
    }

    public void setTeacherDesignationClassTime(String[] teacherDesignationClassTime) {
            this.teacherDesignationClassTime = teacherDesignationClassTime;
    }

    public String[] getTeacherDesignationNotClassTime() {
        return teacherDesignationNotClassTime;
    }

    public void setTeacherDesignationNotClassTime(String[] teacherDesignationNotClassTime) {
        this.teacherDesignationNotClassTime = teacherDesignationNotClassTime;
    }

    public String[] getTeacherDesignationClassLocations() {
        return teacherDesignationClassLocations;
    }

    public void setTeacherDesignationClassLocations(String[] teacherDesignationClassLocations) {
        this.teacherDesignationClassLocations = teacherDesignationClassLocations;
    }

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
        String string = "";
        string += "{";
        string += "teacherId="+teacherId;
        string += ", teacherName="+teacherName;
        string += ", classComposition=[";
        for (String s:classComposition) {
            string += "'"+s+"', ";
        }
        string += "]";
        string += ", teacherDesignationClassTime=[";
        for (String s:teacherDesignationClassTime) {
            string += "'"+s+"', ";
        }
        string += "]";
        string += ", teacherDesignationNotClassTime=[";
        for (String s:teacherDesignationNotClassTime){
            string += "'"+"', ";
        }
        string += "]";
        string += ", teacherDesignationClassLocations=[";
        for (String s:teacherDesignationClassLocations){
            string += "'"+"', ";
        }
        string += "]";
        return string;
    }
}
