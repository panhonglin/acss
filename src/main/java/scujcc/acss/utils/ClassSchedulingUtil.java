package scujcc.acss.utils;

import org.springframework.beans.factory.annotation.Autowired;
import scujcc.acss.domain.Classroom;
import scujcc.acss.domain.Course;
import scujcc.acss.domain.Teacher;
import scujcc.acss.repository.ClassroomRepository;
import scujcc.acss.repository.CourseRepository;
import scujcc.acss.repository.TeacherRepository;
import sun.nio.cs.FastCharsetProvider;

import java.util.*;

/**
 * 排课相关的工具
 * @author CZMs
 * @create 2018-10-20 上午 11:38
 */
public class ClassSchedulingUtil {

    //大三的年级
    private Integer juniorGrade;
    //星期几
    private String[] weekString = {"周一","周二","周三","周四","周五"};
    //第几节课
    private String[] whichClass = {"第1,2节","第3,4节","第5,6节","第7,8节"};

    //教室、教室、课程的jap接口
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private ClassroomRepository classroomRepository;
    @Autowired
    private CourseRepository courseRepository;

    public ClassSchedulingUtil(Integer juniorGrade){
        this.juniorGrade = juniorGrade;
    }

    /**
     * @Author CZM
     * @Description 获取需要排课的年级
     * @Date 下午 05:04 2018/10/21
     * @Param []
     * @return java.lang.Integer
     **/
    public Integer getJuniorGrade() {
        return juniorGrade;
    }

    /**
     * @Author CZM
     * @Description 设置需要排课的年级
     * @Date 下午 05:04 2018/10/21
     * @Param [juniorGrade]
     * @return void
     **/
    public void setJuniorGrade(Integer juniorGrade) {
        this.juniorGrade = juniorGrade;
    }

    /**
     * @Author CZM
     * @Description 指定单个课程的上课时间
     * @Date 上午 10:43 2018/10/21
     * @Param [teacher, course, times] [教师，课程，时间表]
     * @return java.lang.Object
     **/
    public Object designatedSingleClassTime(Teacher teacher, Course course, String[] times){
//        teacher.updateTeacherDesignationClassTime(times);
        //course.updateCourseDesignationClassTime(times);
        //return teacherRepository.save(teacher);
        return null;
    }

    /**
     * @Author CZM
     * @Description 指定多个课程的上课时间
     * @Date 上午 10:56 2018/10/21
     * @Param [teacher, courses, times]
     * @return java.lang.Object
     **/
    public Object designatedMultipleClassTime(Teacher teacher, Course[] courses,String[] times){
        //TODO
        //teacher.updateTeacherDesignationClassTime(times);
        //course.updateCourseMultiDesignationClassTime(courses);
        return teacherRepository.save(teacher);
    }

    /**
     * @Author CZM
     * @Description 指定单个课程的不能上课的时间
     * @Date 上午 10:44 2018/10/21
     * @Param [teacher, course, times] [教师，课程，时间表]
     * @return java.lang.Object
     **/
    public Object designatedSingleNotClassTime(Teacher teacher,Course course,String[] times){
        //TODO
        //teacher.updateTeacherDesignationClassTime(times);
        //course.updateCourseDesignationNotClassTime(times);
        return teacherRepository.save(teacher);
    }

    /**
     * @Author CZM
     * @Description 指定多个课程不能上课的时间
     * @Date 上午 10:56 2018/10/21
     * @Param [teacher, course, times]
     * @return java.lang.Object
     **/
    public Object designatedMultipleNotClassTime(Teacher teacher,Course[] course,String[] times){
        //teacher.updateTeacherDesignationClassTime(times);
        //course.updateCourseMultiDesignationNotClassTime(courses);
        return teacherRepository.save(teacher);
    }

    /**
     * @Author CZM
     * @Description 指定上课地点
     * @Date 上午 10:45 2018/10/21
     * @Param [teacher, course, locations] [教室，课程，地点]
     * @return java.lang.Object
     **/
    public Object designatedSingleClassLocation(Teacher teacher,Course course,String[] locations){
        //TODO
        //teacher.updateTeacherDesignatedClassLocation(locations);
        //course.updateCourseDesignatedClassLocation(locations);
        return teacherRepository.save(teacher);
    }

    /**
     * @Author CZM
     * @Description 指定多个课程的上课地点
     * @Date 上午 10:57 2018/10/21
     * @Param [teacher, course, locations]
     * @return java.lang.Object
     **/
    public Object designatedMultipleClassLOcations(Teacher teacher,Course[] course,String[] locations){
        //T0D0
        //teacher.updateTeacherDesignatedClassLocation(locations);
        //course.updateCourseMultiDesignationClassLocations(locations);
        return teacherRepository.save(teacher);
    }

    /**
     * @Author CZM
     * @Description 指定单个课程上课的时间和地点
     * @Date 上午 10:47 2018/10/21
     * @Param [teacher, course, locations, times]
     * @return java.lang.Object
     **/
    public Object designatedSingleClassLocationAndTime(Teacher teacher,Course course,String[] locations,String[] times){
        //TODO
        //teacher.updateTeacherMultiDesignationClassLocationsAndTime(times,locations);
        //course.updatedesignatedClassLocationAndTime(times,locations);
        return teacherRepository.save(teacher);
    }

    /**
     * @Author CZM
     * @Description 指定多个课程的上课地点和时间
     * @Date 上午 10:58 2018/10/21
     * @Param [teacher, courses, locations, times]
     * @return java.lang.Object
     **/
    public Object designatedMultipleClassLOcationsAndTimes(Teacher teacher,Course[] courses,String[] locations,String[] times){
        //teacher.updateTeacherMultiDesignationClassLocationsAndTime(times,locations);
        //course.updateTeacherMultiDesignationClassLocationsAndTime(times,locations);
        return teacherRepository.save(teacher);
    }

    /**
     * @Author CZM
     * @Description 指定上课时间，不指定具体是那个课程
     * @Date 上午 11:01 2018/10/21
     * @Param [teacher, times]
     * @return java.lang.Object
     **/
    public Object designatedTimes(Teacher teacher,String[] times){
        //teacher.setTeacherDesignationClassTime(times);
        //return teacherRepository.save(teacher);
        return null;
    }

    /**
     * @Author CZM
     * @Description 指定上课地点，不指定具体是那个课程
     * @Date 上午 11:01 2018/10/21
     * @Param [teacher, locations]
     * @return java.lang.Object
     **/
    public Object designatedLocations(Teacher teacher,String[] locations){
        return teacherRepository.save(teacher);
    }

    /**
     * @Author CZM
     * @Description 指定上课时间和地点，不指定是那个具体的课程
     * @Date 上午 11:01 2018/10/21
     * @Param [teacher, locations, times]
     * @return java.lang.Object
     **/
    public Object designatedLocationsAndTimes(Teacher teacher,String[] locations,String[] times) {
        return teacherRepository.save(teacher);
    }
    
    /**
     * @Author CZM
     * @Description 排课算法，所有的数据均从数据库和对象中获取
     * @Date 下午 02:34 2018/10/21
     * @Param []
     * @return void
     **/
    public void scheduling(){
        //初始化教室的时间表
        this.initClassroomTime();
        //把教室被占用的时间标记出来
        this.clearOccupied();
        //先给C++方向排课，C++课程基本在C208计算机实验室（C++）
        List<Course> courses = courseRepository.findAllByClassCompositionAndGrade("C++",this.juniorGrade);
        for (int i =0;i<courses.size();i++) {
            courses.get(i).setClassLocations(new String[]{"C208计算机实验室（C++)"});
            courseRepository.save(courses.get(i));
        }

        //给其他的方向排课
    }

    /**
     * @Author CZM
     * @Description 将教室的时间进行初始化，其中，周五的下午不排课，晚上不排课
     * @Date 下午 05:21 2018/10/22
     * @Param []
     * @return void
     **/
    public void initClassroomTime(){
        List<Classroom> classrooms = classroomRepository.findAll();
        for (int i =0;i<classrooms.size();i++) {
            HashMap<String,HashMap<String,Boolean>> classroomTime = new HashMap<String, HashMap<String, Boolean>>();
            for (int j = 0;j<weekString.length;i++) {
                HashMap<String,Boolean> line = new HashMap<String, Boolean>();
                for (int k = 0;k<whichClass.length;k++) {
                    //周五下午不上课
                    line.put(whichClass[k],whichClass[k].equals("周五")?false:true);
                }
                classroomTime.put(weekString[j],line);
            }
            classrooms.get(i).setClassroomUseTime(classroomTime);
            classroomRepository.save(classrooms.get(i));
        }
    }

    /**
     * @Author CZM
     * @Description 将大一大二占用的教室时间置为不可用，即false
     * @Date 下午 05:08 2018/10/21
     * @Param []
     * @return void
     **/
    public void clearOccupied(){
        List<Course> courses = courseRepository.findAll();
        for (int i = 0;i<courses.size();i++) {
            if (courses.get(i).getGrade() != this.juniorGrade) {
                for (int j = 0;j<courses.get(i).getClassLocations().length;j++) {
                    if (this.inJuniorClassroom(courses.get(i).getClassLocations()[j])) {
                        Classroom updateClassroom = classroomRepository.findByClassroomName(courses.get(i).getClassLocations()[j]);
                        for (String weekKey:courses.get(i).getClassTime().keySet()) {
                            for (String classKey:courses.get(i).getClassTime().get(weekKey).keySet()) {
                                updateClassroom.getClassroomUseTime().get(weekKey).put(classKey,false);
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * @Author CZM
     * @Description 检测是否为大三的实验室，是返回true，否返回false
     * @Date 下午 05:42 2018/10/21
     * @Param [classroomName]
     * @return java.lang.Boolean
     **/
    private Boolean inJuniorClassroom(String classroomName){
        List<Classroom> classrooms = classroomRepository.findAll();
        for (int i =0;i<classrooms.size();i++) {
            if (classroomName.equals(classrooms.get(i).getClassroomName())) {
                return true;
            }
        }
        return false;
    }

    //TODO
    /*
     * @Author CZM
     * @Description 根据指定的教室和专业方向进行排序
     * @Date 下午 05:48 2018/10/22
     * @Param [disciplineName, classroomName]
     * @return void
     **/
    //public void schedulingWithDisciplineAndClassroom(String disciplineName,String classroomName){
    public void schedulingWithDiscipline(String classroomName){
        //获取相关的数据
        List<Course> courses = null;
        HashMap<String,Teacher> teachers = null;
        List<Classroom> classrooms = null;

        //若有指定的专业和教室，则按指定的来获取
        /*
        if ("".equals(disciplineName)) {
            courses = courseRepository.findAllByClassCompositionAndGrade(disciplineName,this.juniorGrade);
        } else {
            courses = courseRepository.findAllByGrade(this.juniorGrade);
        }
        */

        teachers = new HashMap<String,Teacher>();
        for (int i =0;i<courses.size();i++) {
            teachers.put(courses.get(i).getTeacherName(),teacherRepository.findByTeacherName(courses.get(i).getTeacherName()));
        }

        if ("".equals(classroomName)) {
            classrooms = new ArrayList<Classroom>();
            classrooms.add(classroomRepository.findByClassroomName(classroomName));
        } else {
            classrooms  = classroomRepository.findAll();
        }

        //遍历课程，并进行安排
        for (int i = 0;i<courses.size();i++){
            Teacher teacher = teachers.get(courses.get(i).getTeacherName());
            //先判断有无指定的教室或时间或二者都有
            //先判断有无指定教室
            if (!"".equals(this.getFirstDesciplineClasslocation(courses.get(i).getClassLocations()))) { //如果有指定教室，以第一个教室为准
                if (null != courses.get(i).getClassTime()) { //既有指定教室，又有指定时间
                    //if (null != teacher.getTeacherDesignationNotClassTime())
                } else { //只有指定地点，无指定时间
                    if (null != teacher.getTeacherDesignationNotClassTime()) { //指定了地点并指定了不能上课的时间

                    } else {

                    }
                }

            } else if (null != courses.get(i).getClassTime()){ //如果有指定的时间但无指定地点

            } else { //既无指定时间又无指定地点
                if (null != teacher.getTeacherDesignationNotClassTime()) { //指定了不能上课的时间

                } else {

                }
            }
        }
    }

    /*
    private boolean desciplineClasslocations(String[] classLocations){
        for (int i =0;i<classLocations.length;i++) {
            if (!"".equals(classLocations[i])) {
                return true;
            }
        }
        return false;
    }
    */

    private String getFirstDesciplineClasslocation(String[] classLocations){
        for (int i=0;i<classLocations.length;i++) {
            if (!"".equals(classLocations[i])) {
                return classLocations[i];
            }
        }
        return "";
    }

}
