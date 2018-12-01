package cn.edu.nchu.adminpioneer.mapper;

import cn.edu.nchu.adminpioneer.entity.Team;
import cn.edu.nchu.adminpioneer.utils.SqlProviderUtil;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface TeamMapper {

    @Select("select id,name from team limit #{pageNumber},#{pageSize}")
    List<Team> showTeam(@Param("pageSize") int pageSize, @Param("pageNumber") int pageNumber);

    @Select("select count(*) from team")
    int countTeam();

    @Delete("delete from team where id = #{id}")
    int deleteById(@Param("id") int id);

    @DeleteProvider(type = SqlProviderUtil.class, method = "deleteTeamByIds")
    int deleteByIds(String ids);

    @Insert("insert into team values(null,#{name},#{introduction},#{url},#{content},#{text})")
    int addTeam(Team team);

    @Select("select id,name,introduction,url,content from team where id=#{id}")
    Team getTeamById(@Param("id") int id);

    @Update("update team set name=#{name},introduction=#{introduction},url=#{url},content=#{content},text=#{text} where id=#{id}")
    int updateTeam(Team team);

}
