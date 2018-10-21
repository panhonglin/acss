package scujcc.acss.domain;

import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Map;

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
    //private String[] classroomUseTime;
    private Map<String, Map<String,Boolean>> classroomUseTime;

    public Map<String, Map<String, Boolean>> getClassroomUseTime() {
        return classroomUseTime;
    }

    public void setClassroomUseTime(Map<String, Map<String, Boolean>> classroomUseTime) {
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

    /**
     * @Author CZM
     * @Description 转换为字符串
     * @Date 下午 01:08 2018/10/20
     * @Param []
     * @return java.lang.String
     **/
    @Override
    public String toString() {
        String string = "";
        string += "Classroom{";
        string += "classroomId="+classroomId;
        string += ", classroomNumber="+classroomNumber;
        string += ", classroomName='"+classroomName+"'";
        string += ", classroomSeatsNumber="+classroomSeatsNumber;
        string += ", classroomUseTime=[";
        for (String key1:classroomUseTime.keySet()){
            string += "key='"+key1+"', values=[";
            Map<String,Boolean> temp = classroomUseTime.get(key1);
            for (String key2:temp.keySet()) {
                string += "[ key='"+key2+"', value='"+temp.get(key2)+"'], ";
            }
            string += "], ";
        }
        string += "]}";
        return string;
    }
}
