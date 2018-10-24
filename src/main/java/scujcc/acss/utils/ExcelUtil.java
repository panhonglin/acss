package scujcc.acss.utils;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 读取EXCEL相关的工具
 * @author CZM
 * @create 2018-10-20 上午 12:58
 */
//这是黄涛的新测试，希望他能够成功
public class ExcelUtil {
    //TODO
    //两种Excel类型，一个是2003之前，一个是2003之后，二者文件结构不同
    private final static String xls = "xls";
    private final static String xlsx = "xlsx";
    //这是黄涛的测试
    //分支测试
    //文件地址
    private String fileAddress = "";
    //总行数
    private int totalRows = 0;
    //总列数
    private int totalCells = 0;
    //excel的list映射，每一行是一个excel行，通过数值来访问相关的数据
    private List<List<String>> excelList;
    //excel表map映射，可以通过键值来访问相关数据
    private Map<Integer,Map<String,String>> excelMap;

    public List<List<String>> getExcelList() {
        return excelList;
    }

    public void setExcelList(List<List<String>> excelList) {
        this.excelList = excelList;
    }

    /**
     * @Author CZM
     * @Description 初始化Excel工具，并读取相关的数据，需要制定文件的路径
     * @Date 下午 02:47 2018/10/20
     * @Param [fileAddress]
     * @return 
     **/
    public ExcelUtil(String fileAddress) {
        this.fileAddress = fileAddress;
    }


    /**
     * @Author CZM
     * @Description 将list转换为map，方便通过键值来获取数据，默认第一行为各项属相的键值
     * @Date 下午 03:23 2018/10/20
     * @Param []
     * @return java.util.Map<java.lang.Integer,java.util.Map<java.lang.String,java.lang.String>>
     **/
    public Map<Integer,Map<String,String>> toMap(){
        Map<Integer,Map<String,String>> data = new HashMap<Integer, Map<String, String>>();
        List<String> key = this.excelList.get(0);
        for (int i =1;i<this.excelList.size();i++) {
            List<String> line = this.excelList.get(i);
            Map<String,String> mapLine = new HashMap<String,String>();
            for (int j =0;j<line.size();j++) {
                mapLine.put(key.get(j),line.get(j));
            }
            data.put(i,mapLine);
        }
        this.excelMap = data;
        return data;
    }

    /**
     * @Author CZM
     * @Description 将工具的所有成员变量的值全部清除掉
     * @Date 下午 03:31 2018/10/20
     * @Param []
     * @return void
     **/
    public void clean(){
        this.excelMap = null;
        this.excelList = null;
        this.fileAddress = "";
        this.totalCells = 0;
        this.totalRows = 0;
    }

    /**
     * @Author CZM
     * @Description 将从表格中得到的一串的上课时间分割成时间map
     * @Date 下午 06:55 2018/10/21
     * @Param [classTimes]
     * @return java.util.HashMap<java.lang.String,java.util.HashMap<java.lang.String,java.lang.Boolean>>
     **/
    public static HashMap<String,HashMap<String,Boolean>> splitClassTime(String classTimes){
        String[] classTimeArray = classTimes.replaceAll("((\\')|\\{[\\u4e00-\\u9fa5]*\\d*-\\d*[\\u4e00-\\u9fa5]*\\|*[\\u4e00-\\u9fa5]*\\})","").split(";");
        HashMap<String,HashMap<String,Boolean>> classTimeMap = new HashMap<String,HashMap<String, Boolean>>();
        for (String time:classTimeArray) {
            if (classTimeMap.get(time.substring(0,"周一".length())) == null) {
                classTimeMap.put(time.substring(0,"周一".length()),new HashMap<String,Boolean>());
                classTimeMap.get(time.substring(0,"周一".length())).put(time.substring("周一".length(),time.length()),false);
            } else {
                if (classTimeMap.get(time.substring(0,"周一".length())).get(time.substring("周一".length(),time.length())) == null) {
                    classTimeMap.get(time.substring(0,"周一".length())).put(time.substring("周一".length(),time.length()),false);
                }
            }
        }
        return classTimeMap;
    }

    /**
     * @Author CZM
     * @Description 将教室位置分割成String数组
     * @Date 下午 05:50 2018/10/21
     * @Param [classLocations]
     * @return java.lang.String[]
     **/
    public static String[] splitClassLocations(String classLocations){
        return classLocations.replaceAll("\'","").split(";");
    }

    public static String[] splitClassComposition(String classComposition){
        return classComposition.replaceAll("\'","").split(",");
    }

    /**
     * @Author CZM
     * @Description 读取Excel相关数据并放入到序列中
     * @Date 下午 03:12 2018/10/20
     * @Param []
     * @return java.util.List<java.util.List<java.lang.String>>
     **/
    public ExcelUtil read() {
        List<List<String>> data = new ArrayList<List<String>>();
        InputStream inputStream = null;
        try {
            String type = this.getFileType();
            if ("unknown".equals(type)) {
                return null;
            }
            File file = new File(this.fileAddress);
            inputStream = new FileInputStream(file);
            data = read(inputStream,type);
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.excelList = data;
        return this;
    }

    private List<List<String>> read(InputStream inputStream, String type) {
        List<List<String>> data = null;
        try {
            Workbook workbook = null;
            if ("xls".equals(type)) {
                workbook = new HSSFWorkbook(inputStream);
            } else if ("xlsx".equals(type)) {
                workbook = new XSSFWorkbook(inputStream);
            }
            data = read(workbook);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    private List<List<String>> read(Workbook workbook) throws UnsupportedEncodingException {
        List<List<String>> data = new ArrayList<List<String>>();
        //Map<Integer,Map<String,String>> data = new HashMap<Integer,Map<String,String>>();
        Sheet sheet = workbook.getSheetAt(0);
        this.totalRows = sheet.getPhysicalNumberOfRows();
        if (this.totalRows >= 1 && sheet.getRow(0) != null) {
            this.totalCells = sheet.getRow(0).getPhysicalNumberOfCells();
        }
        for (int r = 0; r < this.totalRows; ++r) {
            Row row = sheet.getRow(r);
            if (null == row) {
                continue;
            }
            List<String> rowList = new ArrayList<String>();
            //Map<String,String> rowList = new HashMap<String,String>();
            for (int c = 0; c < this.getTotalCells(); ++c) {
                Cell cell = row.getCell(c);
                String cellValue = "";
                if (null != cell) {
                    switch (cell.getCellType()) {
                        //数字
                        case HSSFCell.CELL_TYPE_NUMERIC: cellValue = new String(((cell.getNumericCellValue() + "").replaceAll("\'","")).getBytes(),"utf-8");
                            break;
                        //字符串
                        case HSSFCell.CELL_TYPE_STRING:
                            cellValue = new String((cell.getStringCellValue().replaceAll("\'","")).getBytes(),"utf-8");
                            break;
                        //布尔类型
                        case HSSFCell.CELL_TYPE_BOOLEAN:
                            cellValue = new String(((cell.getBooleanCellValue() + "").replaceAll("\'","")).getBytes(),"utf-8");
                            break;
                        //公式
                        case HSSFCell.CELL_TYPE_FORMULA:
                            cellValue = new String(((cell.getCellFormula() + "").replaceAll("\'","")).getBytes(),"utf-8");
                            break;
                        //空值
                        case HSSFCell.CELL_TYPE_BLANK:
                            cellValue = "";
                            break;
                        //错误
                        case HSSFCell.CELL_TYPE_ERROR:
                            cellValue = "Invalid symbol";
                            break;
                        default:
                            cellValue = "unknown";
                            break;
                    }
                }
                rowList.add(cellValue);
            }
            data.add(rowList);
        }
        return data;
    }

    /**
     * @Author CZM
     * @Description 使用正则表达式进行文件类型的检测
     * @Date 下午 03:13 2018/10/20
     * @Param []
     * @return java.lang.String
     **/
    private String getFileType() {
        if (this.fileAddress.matches("^.+\\.(?i)([x|X][l|L][s|S])$")) {
            return xls;
        }
        if (this.fileAddress.matches("^.+\\.(?i)([x|X][l|L][s|S][x|X])$")) {
            return xlsx;
        }
        return "unknown";
    }

    public int getTotalRows() {
        return totalRows;
    }

    public int getTotalCells() {
        return totalCells;
    }

    public static String getXls() {
        return xls;
    }

    public static String getXlsx() {
        return xlsx;
    }

    public String getFileAddress() {
        return fileAddress;
    }

    public void setFileAddress(String fileAddress) {
        this.fileAddress = fileAddress;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public void setTotalCells(int totalCells) {
        this.totalCells = totalCells;
    }

    public Map<Integer, Map<String, String>> getExcelMap() {
        return excelMap;
    }

    public void setExcelMap(Map<Integer, Map<String, String>> excelMap) {
        this.excelMap = excelMap;
    }
}
/*
 * @Author CZM
 * @Description //TODO
 * @Date 上午 09:41 2018/10/24
 * @Param
 * @return
 161	C208计算机实验室（C++)	1	40
173	.net实验室	2	20
182	电子商务实验室（嵌入式）	3	64
183	计算机科技实验室	4	80
184	软件工程实验室	5	90
185	网络工程实验室（J2EE）	6	64
186	网络营销实验室（IT商务）	7	48
187	信息安全实验室	8	60
188	信息管理实验室	9	48
189	云计算实验室	10	48
328	C101	11	30

 **/