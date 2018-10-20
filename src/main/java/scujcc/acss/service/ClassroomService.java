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
    /**
     * @Author CZM
     * @Description 插入单个教室到数据库
     * @Date 下午 01:17 2018/10/20
     * @Param [classroom]
     * @return void
     **/
    public void insertSingle(Classroom classroom){
        classroomRepository.save(classroom);
    }
    /**
     * @Author CZM
     * @Description 通过某个关键字删除单个对象
     * @Date 下午 01:18 2018/10/20
     * @Param [id]
     * @return void
     **/
    @Transactional
    public void deleteSingleById(Integer id){
        classroomRepository.delete(classroomRepository.findByClassroomId(id));
    }
    @Transactional
    public void deleteSingleByClassroomNumber(Integer classroomNumber){
        classroomRepository.delete(classroomRepository.findByClassroomNumber(classroomNumber));
    }
    @Transactional
    public void deleteSingleByClassroomName(String classroomName){
        classroomRepository.delete(classroomRepository.findByClassroomName(classroomName));
    }
    /**
     * @Author CZM
     * @Description 通过某个关键字数组删除多个对象
     * @Date 下午 01:18 2018/10/20
     * @Param [id]
     * @return void
     **/
    @Transactional
    public void deleteMultipleById(Integer[] id){
        for (int i =0;i<id.length;i++) {
            this.deleteSingleById(id[i]);
        }
    }
    @Transactional
    public void deleteMultipleByClassroomNumber(Integer[] classroomNumber){
        for (int i =0;i<classroomNumber.length;i++) {
            this.deleteSingleByClassroomNumber(classroomNumber[i]);
        }
    }
    @Transactional
    public void deleteMultipleByClassroomName(String[] classroomName){
        for (int i =0;i<classroomName.length;i++) {
            this.deleteSingleByClassroomName(classroomName[i]);
        }
    }
}
