package scujcc.acss.utils;

import org.apache.poi.ss.formula.functions.T;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import scujcc.acss.domain.Course;
import scujcc.acss.domain.Teacher;
import scujcc.acss.repository.ClassroomRepository;
import scujcc.acss.repository.CourseRepository;
import scujcc.acss.repository.TeacherRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.zip.CheckedOutputStream;

import static org.junit.Assert.*;

/**
 * @author CZM
 * @create 2018-10-20 下午 11:20
 */
public class ExcelUtilTest {
    @Autowired
    TeacherRepository teacherRepository;
    @Autowired
    ClassroomRepository classroomRepository;
    @Autowired
    CourseRepository courseRepository;
    @Test
    public void sendData(){
        ExcelUtil dasan = new ExcelUtil("F:\\big_data_technology\\实战Hadoop\\排课系统\\大三方向课开设计划.xlsx");
        ExcelUtil dayi = new ExcelUtil("F:\\big_data_technology\\实战Hadoop\\排课系统\\大一大二课表.xls");
        Map<Integer, Map<String, String>> dasandata = dasan.read().toMap();
        Map<Integer, Map<String, String>> dayidata = dayi.read().toMap();
        for (int i =1;i<=dasandata.size();i++) {
            Map<String,String> temp = dasandata.get(i);
            Teacher teacher = new Teacher();
            teacher.setTeacherName(temp.get("教师"));
            teacher.setClassComposition(new String[]{temp.get("方向")});
            Course course = new Course();
            course.setGrade(Integer.valueOf(temp.get("年级")));
            course.setCourseCode(temp.get("课程号"));
            course.setCredit(Double.valueOf(temp.get("学分")));
            course.setTeacherName(temp.get("教师"));
            course.setStudentNumber(Integer.valueOf(temp.get("人数")));
            course.setTotalPeriod(Double.valueOf(temp.get("总学时")));
            course.setCourseType("专业方向课");
            course.setCourseName(temp.get("课程名称"));
            course.setCourseLength(Double.valueOf(temp.get("学分"))>2?4:2);
            course.setWeekNumber((int) (course.getTotalPeriod()/course.getCourseLength()));
            teacherRepository.save(teacher);
            courseRepository.save(course);
        }
        for (int i =1;i<=dayidata.size();i++) {
            Map<String,String> temp = dayidata.get(i);
            Course course = new Course();
            course.setGrade(Integer.valueOf(temp.get("年级")));
            course.setCourseCode(temp.get("课程号"));
            course.setCredit(Double.valueOf(temp.get("学分")));
            course.setTeacherName(temp.get("教师"));
            course.setStudentNumber(Integer.valueOf(temp.get("人数")));
            course.setTotalPeriod(Double.valueOf(temp.get("总学时")));
            course.setCourseType("专业方向课");
            course.setCourseLength(Integer.valueOf(temp.get("学分"))>2?4:2);
            course.setWeekNumber((int) (course.getTotalPeriod()/course.getCourseLength()));
            courseRepository.save(course);
        }
    }

    @Test
    public void toMap() {
        ExcelUtil excelUtil = new ExcelUtil("F:\\big_data_technology\\实战Hadoop\\排课系统\\大三方向课开设计划.xlsx");
        Assert.assertNotEquals(null, excelUtil.read());
        Assert.assertNotEquals(null, excelUtil.toMap());
        Assert.assertEquals("2016",excelUtil.getExcelMap().get(1).get("年级"));
        System.out.println(excelUtil.getExcelMap().get(1).get("课程号"));
    }

    @Test
    public void clean() {
        ExcelUtil excelUtil = new ExcelUtil("F:\\big_data_technology\\实战Hadoop\\排课系统\\大三方向课开设计划.xlsx");
        excelUtil.clean();
        //Assert.assertNotEquals(null, excelUtil.read());
    }

    @Test
    public void read() {
        ExcelUtil excelUtil = new ExcelUtil("F:\\big_data_technology\\实战Hadoop\\排课系统\\大三方向课开设计划.xlsx");
        Assert.assertNotEquals(null, excelUtil.read());
        Assert.assertEquals("年级", excelUtil.getExcelList().get(0).get(0));
    }

    @Test
    public void testInto(){
        ExcelUtil excelUti1 = new ExcelUtil("F:\\big_data_technology\\实战Hadoop\\排课系统\\大一大二课表.xls");
        ExcelUtil excelUti2 = new ExcelUtil("F:\\big_data_technology\\实战Hadoop\\排课系统\\大三方向课开设计划.xlsx");
        excelUti1.read();
        excelUti2.read();
        Map<Integer, Map<String,String>> map1 = excelUti1.toMap();
        Map<Integer, Map<String,String>> map2 = excelUti2.toMap();
        for (int i = 1;i<=map1.size();i++) {
            Course course = new Course();
            course.setCourseId(i);
            //course.setClassComposition();
        }
    }

    @Test
    public void testSplit(){
        ExcelUtil excelUti2 = new ExcelUtil("F:\\big_data_technology\\实战Hadoop\\排课系统\\大三方向课开设计划.xlsx");
        HashMap<String,HashMap<String,Boolean>> testMap = excelUti2.splitClassTime("'周三第9,10节{第5-5周|单周};周三第9,10节{第12-12周|双周};周五第5,6节{第5-15周|单周};周五第7,8节{第5-15周|单周};周一第1,2节{第6-11周};周二第3,4节{第6-11周};周二第9,10节{第5-5周|单周};周二第9,10节{第12-12周|双周}");
        String string = "";
        string += ", teacherDesignationNotClassTime=[";
        for (String key1:testMap.keySet()){
            string += "key='"+key1+"', values=[";
            Map<String,Boolean> temp =testMap.get(key1);
            for (String key2:temp.keySet()) {
                string += "[ key='"+key2+"', value='"+temp.get(key2)+"'], ";
            }
            string += "], ";
        }
        string += "]";
        System.out.println(string);
    }
}