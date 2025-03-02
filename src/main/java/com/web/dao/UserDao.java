package com.web.dao;

import com.web.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface UserDao {
    @Insert("insert into users (name,pwd) values(#{name},#{pwd})")
    int save(User user);

    @Update("update users set name=#{name} where id = #{id}")
    int updateName(@Param("id") Integer id, @Param("name") String name);

    @Update("update users set pwd=#{pwd} where id = #{id}")
    int updatePwd(@Param("id") Integer id, @Param("pwd") String pwd);

    @Delete("delete from users where id = #{id}")
    int delete(Integer id);

    @Select("select * from users where id = #{id}")
    User getById(Integer id);

    @Select("select * from users ")
    List<User> getAll();

    @Select("select pwd from users where name = #{name}")
    String login(String name);


}
