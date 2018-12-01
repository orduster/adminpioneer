package cn.edu.nchu.adminpioneer.mapper;

import cn.edu.nchu.adminpioneer.entity.Structure;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface StructureMapper {
    @Select("select content,text from structure")
    Structure getStructure();

    @Update("update structure set content=#{content},text=#{text},time=#{time}")
    int updateStructure(Structure structure);

    @Insert("insert into structure values(#{content},text=#{text},time=#{time})")
    int addStructure(Structure structure);
}
