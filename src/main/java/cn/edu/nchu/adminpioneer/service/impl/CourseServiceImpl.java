package cn.edu.nchu.adminpioneer.service.impl;

import cn.edu.nchu.adminpioneer.entity.Course;
import cn.edu.nchu.adminpioneer.mapper.CourseMapper;
import cn.edu.nchu.adminpioneer.service.CourseService;
import cn.edu.nchu.adminpioneer.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public Course getCourse() {
        return courseMapper.getCourse();
    }

    @Override
    public int updateCourse(Course course) {
        course.setTime(new TimeUtils().getNowTime());
        return courseMapper.updateCourse(course);
    }

    @Override
    public int addCourse(Course course) {
        course.setTime(new TimeUtils().getNowTime());
        return courseMapper.addCourse(course);
    }
}
