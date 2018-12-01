package cn.edu.nchu.adminpioneer.mapper;

import cn.edu.nchu.adminpioneer.entity.College;
import org.apache.ibatis.annotations.*;

/**
 * 学院简介
 */
public interface CollegeMapper {

    @Results({
            @Result(property = "time", column = "time")
    })
    @Select("select * from college")
    College getCollege();

    @Insert("insert into college values(#{content},#{text},#{time})")
    int addCollege(College college);

    @Update("update college set content=#{content},text=#{text},time=#{time}")
    int updateCollege(College college);

}
