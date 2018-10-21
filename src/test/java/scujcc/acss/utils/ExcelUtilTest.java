package scujcc.acss.utils;

import org.junit.Assert;
import org.junit.Test;
import scujcc.acss.domain.Course;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author CZM
 * @create 2018-10-20 下午 11:20
 */
public class ExcelUtilTest {

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