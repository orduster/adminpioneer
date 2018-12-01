package cn.edu.nchu.adminpioneer.service.impl;

import cn.edu.nchu.adminpioneer.entity.Teacher;
import cn.edu.nchu.adminpioneer.mapper.TeacherMapper;
import cn.edu.nchu.adminpioneer.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public List<Teacher> showTeacher(int pageSize, int pageNumber) {
        return teacherMapper.showTeacher(pageSize, pageNumber);
    }

    @Override
    public int countTeacher() {
        return teacherMapper.countTeacher();
    }

    @Override
    public int deleteById(int id) {
        return teacherMapper.deleteById(id);
    }

    @Override
    public int deleteByIds(String ids) {
        return teacherMapper.deleteByIds(ids);
    }

    @Override
    public int addTeacher(Teacher teacher) {
        return teacherMapper.addTeacher(teacher);
    }

    @Override
    public Teacher getTeacherById(int id) {
        return teacherMapper.getTeacherById(id);
    }

    @Override
    public int updateTeacher(Teacher teacher) {
        return teacherMapper.updateTeacher(teacher);
    }

    @Override
    public List<Teacher> onCampus() {
        return teacherMapper.onCampus();
    }

    @Override
    public List<Teacher> offCampus() {
        return teacherMapper.offCampus();
    }
}
