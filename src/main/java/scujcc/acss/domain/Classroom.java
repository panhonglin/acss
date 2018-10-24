package scujcc.acss.domain;


import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 教室实体
 * @author CZM
 * @create 2018-10-20 上午 12:36
 */
@Entity
public class    Classroom {
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
    //private Map<String, Map<String,Boolean>> classroomUseTime;
    //嵌套的map应当是Map<String,Boolean>
    //private Map<String,Map> classroomUseTime;
    @Column(length = 16777216)
    private HashMap<String,HashMap<String,Boolean>> classroomUseTime;

    public Classroom(){
        this.classroomUseTime = new HashMap<String,HashMap<String, Boolean>>();
        this.classroomSeatsNumber = 0;
        this.classroomName="";
    }

    /*
    Map<String, Map<String,Boolean>> map = new HashMap<String,Map<String,Boolean>>();
    String[] week = {"周一","周二","周三","周四","周五"};
    String[] classTime ={"第1,2节","第3,4节","第5,6节","第7,8节"};
        for (int i =0;i<week.length;i++) {
        Map<String,Boolean> map1 = new HashMap<>();
        for (int  j =0;j<classTime.length;j++) {
            map1.put(classTime[j],true);
        }
        map.put(week[i],map1);
    }
    */

    public HashMap<String, HashMap<String, Boolean>> getClassroomUseTime() {
        return classroomUseTime;
    }

    public void setClassroomUseTime(HashMap<String, HashMap<String, Boolean>> classroomUseTime) {
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
