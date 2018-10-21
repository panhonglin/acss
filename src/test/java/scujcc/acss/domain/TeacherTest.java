package scujcc.acss.domain;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author CZM
 * @create 2018-10-21 上午 12:24
 */
public class TeacherTest {

    @Test
    public void getTeacherName() {
        Teacher teacher = new Teacher();
        teacher.setTeacherId(0);
        teacher.setTeacherName("test");
        teacher.setClassComposition(new String[]{"class1","class2","class3"});
        System.out.println(teacher.toString());
    }

    @Test
    public void getClassroomToString(){
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
        Classroom classroom = new Classroom();
        classroom.setClassroomId(1);
        classroom.setClassroomName("test");
        classroom.setClassroomNumber(161);
        classroom.setClassroomSeatsNumber(20);
        classroom.setClassroomUseTime(map);
        System.out.println(classroom.toString());
    }
}