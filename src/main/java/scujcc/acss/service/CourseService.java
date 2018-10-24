package scujcc.acss.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scujcc.acss.domain.Course;
import scujcc.acss.repository.CourseRepository;

import javax.transaction.Transactional;
//潘虹霖的提交测试
/**
 * 课程的事务管理
 * @author CZM
 * @create 2018-10-20 上午 12:55
 */

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;
    //TODO
    @Transactional
    /**
     * @Author CZM
     * @Description 插入一个课程
     * @Date 下午 05:21 2018/10/20
     * @Param [course]
     * @return void
     **/
    public void insert(Course course){
        courseRepository.save(course);
    }
}