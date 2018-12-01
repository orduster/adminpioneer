package cn.edu.nchu.adminpioneer.mapper;

import cn.edu.nchu.adminpioneer.entity.IndexImages;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IndexImagesMapper {

    @Select("select id,description from indeximages limit #{pageNumber},#{pageSize}")
    List<IndexImages> showIndexImages(@Param("pageSize") int pageSize, @Param("pageNumber") int pageNumber);

    @Delete("delete from indeximages where id = #{id}")
    int deleteById(int id);

    @Select("select count(*) from indeximages")
    int count();

    @Insert("insert into indeximages values(null,#{description},#{url})")
    int addIndexImages(IndexImages indexImages);

    @Update("update indeximages set description=#{description},url=#{url} where id=#{id}")
    int updateIndexImages(IndexImages indexImages);

    @Select("select * from indeximages")
    IndexImages getIndexImages(int id);

}
