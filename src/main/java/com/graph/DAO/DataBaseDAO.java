package com.graph.DAO;

import com.graph.Domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface DataBaseDAO {

    @Select("select * from user where username = #{username} and password = #{password}")
    User userLogin(@Param("username") String username, @Param("password") String password);

    @Insert("insert into user (username,phone,password,email) values(#{username},#{phone},#{password},#{email}) ")
    boolean userRegist(@Param("username") String username,@Param("phone") String phone,@Param("password") String password,@Param("email") String email);

    @Select("select * from user where username = #{username}")
    User userMessage(@Param("username")String username);

    @Update("update user set phone = #{phone},password = #{password},email = #{email} where username = #{username}")
    boolean userChange(@Param("username")String username,@Param("phone") String phone,@Param("password") String password, @Param("email")String email);
}
