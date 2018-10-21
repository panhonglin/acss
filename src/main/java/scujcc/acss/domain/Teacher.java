package scujcc.acss.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.HashMap;
import java.util.Map;

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
    //private String[] teacherDesignationClassTime;
    //private Map<String, Map<String,Boolean>> teacherDesignationClassTime;
    //嵌套Map<String,Boolean>
    //private Map<String,Map> teacherDesignationClassTime;
    private HashMap<String,HashMap<String,Boolean>> teacherDesignationClassTime;
    //教师指定的不能上课的时间
    //private String[] teacherDesignationNotClassTime;
    //private Map<String,Map<String,Boolean>> teacherDesignationNotClassTime;
    //嵌套Map<String,Boolean>
    //private Map<String,Map> teacherDesignationNotClassTime;
    private HashMap<String,HashMap<String,Boolean>> teacherDesignationNotClassTime;
    //教师指定的上课地点
    private String[] teacherDesignationClassLocations;

    public HashMap<String, HashMap<String, Boolean>> getTeacherDesignationClassTime() {
        return teacherDesignationClassTime;
    }

    public void setTeacherDesignationClassTime(HashMap<String, HashMap<String, Boolean>> teacherDesignationClassTime) {
        this.teacherDesignationClassTime = teacherDesignationClassTime;
    }

    public HashMap<String, HashMap<String, Boolean>> getTeacherDesignationNotClassTime() {
        return teacherDesignationNotClassTime;
    }

    public void setTeacherDesignationNotClassTime(HashMap<String, HashMap<String, Boolean>> teacherDesignationNotClassTime) {
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
        for (String key1:teacherDesignationClassTime.keySet()){
            string += "key='"+key1+"', values=[";
            Map<String,Boolean> temp = teacherDesignationClassTime.get(key1);
            for (String key2:temp.keySet()) {
                string += "[ key='"+key2+"', value='"+temp.get(key2)+"'], ";
            }
            string += "], ";
        }
        string += "]";
        string += ", teacherDesignationNotClassTime=[";
        for (String key1:teacherDesignationNotClassTime.keySet()){
            string += "key='"+key1+"', values=[";
            Map<String,Boolean> temp = teacherDesignationNotClassTime.get(key1);
            for (String key2:temp.keySet()) {
                string += "[ key='"+key2+"', value='"+temp.get(key2)+"'], ";
            }
            string += "], ";
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
