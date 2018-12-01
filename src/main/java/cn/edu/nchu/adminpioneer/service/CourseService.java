package cn.edu.nchu.adminpioneer.service;

import cn.edu.nchu.adminpioneer.entity.Course;

public interface CourseService {

    Course getCourse();

    int updateCourse(Course course);

    int addCourse(Course course);
}
