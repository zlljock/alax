package com.alax.mapper;

import com.alax.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * author: drew
 * date:2019/11/19
 * time:23:57
 */
@Mapper
public interface UserMapper {

   @Insert("insert into user(name,account_id,token,gmtCreate,gmtModified,avatarUrl) values(#{name},#{account_id},#{token},#{gmtCreate},#{gmtModified},#{avatarUrl})")
     void insertUser(User user) throws Exception ;

   @Select("select * from user where token=#{token}")
   /*参数不是类的加@Param*/
    User findByToken(@Param("token") String token);

    /*通过*/
    @Select("select * from user where id =#{id}")
    User findById( @Param("id") Integer id);
}
