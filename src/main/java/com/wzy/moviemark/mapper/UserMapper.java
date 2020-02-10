package com.wzy.moviemark.mapper;

import com.wzy.moviemark.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {


    @Select("select * from user where userName= #{userName} ")
    public User get(String userName);


    @Select(" select * from user LIMIT #{pageCap} OFFSET #{offset}")
    public List<User> listPage(int pageCap, int offset);

    @Select("select count(*) from user ")
    public int getUserCount();

    @Insert(" insert into user (userName, dispName, password, eMail) values (#{userName}, #{dispName}, #{password}, #{eMail})")
    public void create(User user);

    @Update(" update user set dispName=#{dispName} where userName=#{userName}")
    public void updateDispName(String userName, String dispName);
    @Update(" update user set password=#{password} where userName=#{userName}")
    public void updatePassword(String userName, String password);
    @Update(" update user set eMail=#{eMail} where userName=#{userName}")
    public void updateEMail(String userName, String eMail);
}
