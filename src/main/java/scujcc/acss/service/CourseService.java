package scujcc.acss.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scujcc.acss.repository.CourseRepository;

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
}
