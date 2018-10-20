package scujcc.acss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import scujcc.acss.domain.Classroom;


/**
 * 教室的jpa接口
 * @author CZM
 * @create 2018-10-20 上午 12:50
 */
public interface ClassroomRepository extends JpaRepository<Classroom,Integer> {
    //TODO
    /**
     * @Author CZM
     * @Description //TODO 通过教室编号来找
     * @Date 下午 01:07 2018/10/20
     * @Param [classroomId]
     * @return scujcc.acss.domain.Classroom
     **/
    public Classroom findByClassroomId(Integer classroomId);
    /**
     * @Author CZM
     * @Description 通过教室编号来找
     * @Date 下午 01:07 2018/10/20
     * @Param [classroomNumber]
     * @return scujcc.acss.domain.Classroom
     **/
    public Classroom findByClassroomNumber(Integer classroomNumber);
    //通过教室名字来找
    /**
     * @Author CZM
     * @Description 通过教室名字来找
     * @Date 下午 01:08 2018/10/20
     * @Param [classroomName]
     * @return scujcc.acss.domain.Classroom
     **/
    public Classroom findByClassroomName(String classroomName);
    //public List<Classroom> findByUseTime(String[] UseTime);
}
