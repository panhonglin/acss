package scujcc.acss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import scujcc.acss.domain.Course;

/**
 * @author CZM
 * @create 2018-10-20 下午 05:59
 */
public interface CourseRepository extends JpaRepository<Course,Integer> {
}
