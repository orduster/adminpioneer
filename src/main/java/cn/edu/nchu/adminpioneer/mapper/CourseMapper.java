package cn.edu.nchu.adminpioneer.mapper;

import cn.edu.nchu.adminpioneer.entity.Course;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface CourseMapper {

    @Select("select content,text from course")
    Course getCourse();

    @Update("update course set content=#{content},text=#{text},time=#{time}")
    int updateCourse(Course course);

    @Insert("insert into course values(#{content},text=#{text},time=#{time})")
    int addCourse(Course course);
}
