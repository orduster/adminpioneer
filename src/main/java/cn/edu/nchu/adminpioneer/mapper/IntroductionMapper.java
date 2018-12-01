package cn.edu.nchu.adminpioneer.mapper;

import cn.edu.nchu.adminpioneer.entity.Introduction;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface IntroductionMapper {

    @Select("select * from introduction")
    Introduction getIntroduction();

    @Insert("insert into introduction values(#{content},#{text},#{time})")
    int addIntr(Introduction introduction);

    @Update("update introduction set content=#{content},text=#{text},time=#{time}")
    int updateIntr(Introduction introduction);
}
