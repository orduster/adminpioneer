package cn.edu.nchu.adminpioneer.mapper;

import cn.edu.nchu.adminpioneer.entity.Works;
import cn.edu.nchu.adminpioneer.utils.SqlProviderUtil;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface WorksMapper {

    /*得到双创作品列表*/
    @Select("select id,name from works limit #{pageNumber},#{pageSize}")
    List<Works> getAllWorksLimit(@Param("pageSize") int pageSize, @Param("pageNumber") int pageNumber);

    /*增加作品*/
    @Insert("insert into works values(null,#{name},#{member},#{incident},#{url})")
    int addWorks(Works works);

    /*根据id来删除作评*/
    @Delete("delete from works where id=#{id}")
    int deleteWorksById(@Param("id") Integer id);

    @DeleteProvider(type = SqlProviderUtil.class, method = "deleteWorksByIds")
    int deleteWorksByIds(String ids);

    /*根据id来查找作品*/
    @Select("select * from works where id=#{id}")
    Works findWorksById(@Param("id") Integer id);

    /*更新*/
    @Update("update works set name=#{name},member=#{member},incident=#{incident},url=#{url} where id=#{id}")
    int updateWorksById(Works works);

    /*统计总数*/
    @Select("select count(*) from works")
    int countWorks();

}
