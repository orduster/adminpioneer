package cn.edu.nchu.adminpioneer.mapper;

import cn.edu.nchu.adminpioneer.entity.Practice;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface PracticeMapper {
    @Select("select content,text from practice")
    Practice getPractice();

    @Update("update practice set content=#{content},text=#{text},time=#{time}")
    int updatePractice(Practice practice);

    @Insert("insert into practice values(#{content},text=#{text},time=#{time})")
    int addPractice(Practice practice);
}
