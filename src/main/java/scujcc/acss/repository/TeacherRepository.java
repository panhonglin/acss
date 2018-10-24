package scujcc.acss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import scujcc.acss.domain.Teacher;

import java.util.List;

/**
 * 教师的JPA接口
 * @author CZM
 * @create 2018-10-20 上午 12:51
 */
public interface TeacherRepository extends JpaRepository<Teacher,Integer> {
    //TODO
    /**
     * @Author CZM
     * @Description 自增的ID
     * @Date 下午 01:14 2018/10/20
     * @Param [teacherId]
     * @return scujcc.acss.domain.Teacher
     **/
    public Teacher findByTeacherId(Integer teacherId);

    /**
     * @Author CZM
     * @Description 教师姓名
     * @Date 下午 01:15 2018/10/20
     * @Param [teacherName]
     * @return scujcc.acss.domain.Teacher
     **/
    public Teacher findByTeacherName(String teacherName);
    /**
     * @Author CZM
     * @Description 教学班组成
     * @Date 下午 01:16 2018/10/20
     * @Param [classComposition]
     * @return java.util.List<scujcc.acss.domain.Teacher>
     **/
    public List<Teacher> findByClassComposition(String lassComposition);
}
