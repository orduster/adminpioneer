package cn.edu.nchu.adminpioneer.mapper;

import cn.edu.nchu.adminpioneer.entity.Activity;
import cn.edu.nchu.adminpioneer.utils.SqlProviderUtil;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ActivityMapper {

    @Select("select id,name from activity limit #{pageNumber},#{pageSize}")
    List<Activity> showActivity(@Param("pageSize") int pageSize, @Param("pageNumber") int pageNumber);

    @Select("select count(*) from activity")
    int count();

    @Delete("delete from activity where id = #{id}")
    int deleteById(int id);

    @DeleteProvider(type = SqlProviderUtil.class, method = "deleteActivityByIds")
    int deleteByIds(String ids);

    @Insert("insert into Activity values(null,#{name},#{introduction},#{url},#{content},#{text})")
    int addActivity(Activity activity);

    @Select("select id,name,introduction,url,content from Activity where id=#{id}")
    Activity getActivityById(int id);

    @Update("update Activity set name=#{name},introduction=#{introduction},url=#{url},content=#{content},text=#{text} where id=#{id}")
    int updateActivity(Activity activity);
}
