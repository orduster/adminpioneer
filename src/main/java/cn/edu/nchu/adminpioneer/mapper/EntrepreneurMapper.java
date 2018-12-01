package cn.edu.nchu.adminpioneer.mapper;

import cn.edu.nchu.adminpioneer.entity.Entrepreneur;
import cn.edu.nchu.adminpioneer.utils.SqlProviderUtil;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface EntrepreneurMapper {
    @Select("select id,name from entrepreneur limit #{pageNumber},#{pageSize}")
    List<Entrepreneur> showEntrepreneur(@Param("pageSize") int pageSize, @Param("pageNumber") int pageNumber);

    @Select("select count(*) from entrepreneur")
    int countEntrepreneur();

    @Delete("delete from entrepreneur where id = #{id}")
    int deleteById(@Param("id") int id);

    @DeleteProvider(type = SqlProviderUtil.class, method = "deleteEntrepreneurByIds")
    int deleteByIds(String ids);

    @Insert("insert into entrepreneur values(null,#{name},#{introduction},#{url},#{content},#{text})")
    int addEntrepreneur(Entrepreneur entrepreneur);

    @Select("select id,name,introduction,url,content from entrepreneur where id=#{id}")
    Entrepreneur getEntrepreneurById(@Param("id") int id);

    @Update("update entrepreneur set name=#{name},introduction=#{introduction},url=#{url},content=#{content},text=#{text} where id=#{id}")
    int updateEntrepreneur(Entrepreneur entrepreneur);
}
