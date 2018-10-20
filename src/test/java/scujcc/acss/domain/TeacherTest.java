package scujcc.acss.domain;

import org.junit.Test;

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
}