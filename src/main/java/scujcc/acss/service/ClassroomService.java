package scujcc.acss.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scujcc.acss.domain.Classroom;
import scujcc.acss.repository.ClassroomRepository;

import javax.transaction.Transactional;

/**
 * 教室的是事务管理
 * @author CZM
 * @create 2018-10-20 上午 12:53
 */
@Service
public class ClassroomService {
    @Autowired
    private ClassroomRepository classroomRepository;
    //TODO
    @Transactional
    public void insert(Classroom classroom){
        classroomRepository.save(classroom);
    }
}
