package cn.edu.nchu.adminpioneer.mapper;

import cn.edu.nchu.adminpioneer.entity.File;
import cn.edu.nchu.adminpioneer.utils.SqlProviderUtil;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface FileMapper {
    /*添加文件*/
    @Insert("insert into file values(null,#{sort},#{name},#{url})")
    int addFile(File file);

    @Select("select * from file where id=#{id}")
    File getFile(@Param("id") int id);

    /*文件列表*/
    @Select("select * from file limit #{pageNumber},#{pageSize}")
    List<File> getAllFile(@Param("pageSize") int pageSize, @Param("pageNumber") int pageNumber);

    /*删除一个文件*/
    @Delete("delete from file where id=#{id}")
    int deleteFileById(@Param("id") int id);

    /*批量删除*/
    @DeleteProvider(type = SqlProviderUtil.class, method = "deleteFilesByIds")
    int deleteFilesByIds(String ids);

    @Select("select count(*) from file")
    int count();
}
