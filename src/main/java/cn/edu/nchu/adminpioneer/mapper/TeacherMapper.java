package cn.edu.nchu.adminpioneer.mapper;

import cn.edu.nchu.adminpioneer.entity.Teacher;
import cn.edu.nchu.adminpioneer.utils.SqlProviderUtil;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface TeacherMapper {

    @Select("select id,sort,name,position,description from teacher limit #{pageNumber},#{pageSize}")
    List<Teacher> showTeacher(@Param("pageSize") int pageSize, @Param("pageNumber") int pageNumber);

    @Select("select count(*) from teacher")
    int countTeacher();

    @Delete("delete from teacher where id = #{id}")
    int deleteById(@Param("id") int id);

    @DeleteProvider(type = SqlProviderUtil.class, method = "deleteTeacherByIds")
    int deleteByIds(String ids);

    @Insert("insert into teacher values(null,#{sort},#{name},#{position},#{description})")
    int addTeacher(Teacher teacher);

    @Select("select id,sort,name,position,description from teacher where id=#{id}")
    Teacher getTeacherById(@Param("id") int id);

    @Update("update teacher set sort=#{sort},name=#{name},position=#{position},description=#{description} where id=#{id}")
    int updateTeacher(Teacher teacher);

    @Select("select name,position,description from teacher where sort='校内导师团'")
    List<Teacher> onCampus();

    @Select("select name,position,description from teacher where sort='校外导师团'")
    List<Teacher> offCampus();
}
