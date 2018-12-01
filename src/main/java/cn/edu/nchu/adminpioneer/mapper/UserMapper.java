package cn.edu.nchu.adminpioneer.mapper;

import cn.edu.nchu.adminpioneer.entity.User;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserMapper {
    @Select("select * from user where name=#{username} and password=#{password}")
    User findByUsernameAndPassword(User user);

    @Update("update user set name=#{username},password=#{password}")
    int updateUser(User user);
}
