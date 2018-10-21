package scujcc.acss.utils;

import org.junit.Assert;
import org.junit.Test;
import scujcc.acss.domain.Course;

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
}