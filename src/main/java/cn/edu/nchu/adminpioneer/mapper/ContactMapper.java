package cn.edu.nchu.adminpioneer.mapper;

import cn.edu.nchu.adminpioneer.entity.Contact;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ContactMapper {

    @Select("select address,tele,email from contact")
    Contact getContact();

    @Update("update contact set address=#{address},tele=#{tele},email=#{email}")
    int updateContact(Contact contact);

    @Insert("insert into contact values(#{address},#{tele},#{email})")
    int addContact(Contact contact);
}
