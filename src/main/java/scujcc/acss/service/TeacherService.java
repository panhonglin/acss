package scujcc.acss.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scujcc.acss.domain.Teacher;
import scujcc.acss.repository.TeacherRepository;

import javax.transaction.Transactional;

/**
 * @author CZM
 * @create 2018-10-20 上午 12:55
 */
@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;
    //TODO
    @Transactional
    /**
     * 插入一个老师信息
     */
    public void insert(Teacher teacher){

        teacherRepository.save(teacher);
    }
}
