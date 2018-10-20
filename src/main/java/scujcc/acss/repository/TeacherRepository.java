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
    //自增的ID
    public Teacher findByTeacherId(Integer teacherId);
    //教师姓名
    public Teacher findByTeacherName(String teacherName);
    //教学班组成
    public List<Teacher> findByClassComposition(String classComposition);
}
