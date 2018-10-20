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
    //通过id来找
    public Classroom findByClassroomId(Integer classroomId);
    //通过教室编号来找
    public Classroom findByClassroomNumber(Integer classroomNumber);
    //通过教室名字来找
    public Classroom findByClassroomName(String classroomName);
    //public List<Classroom> findByUseTime(String[] UseTime);
}
