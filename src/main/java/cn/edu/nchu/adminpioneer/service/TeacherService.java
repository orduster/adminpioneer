package cn.edu.nchu.adminpioneer.service;

import cn.edu.nchu.adminpioneer.entity.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> showTeacher(int pageSize, int pageNumber);

    int countTeacher();

    int deleteById(int id);

    int deleteByIds(String ids);

    int addTeacher(Teacher teacher);

    Teacher getTeacherById(int id);

    int updateTeacher(Teacher teacher);

    List<Teacher> onCampus();

    List<Teacher> offCampus();
}
