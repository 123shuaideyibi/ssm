package com.atgongda.dao;

import com.atgongda.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author sushuai
 * @date 2019/03/03/21:33
 */
public interface UserMapper {


    /**
     * 通过用户名查询用户信息
     * @param username
     * @return
     */
    User selectUserByUserName(@Param("username") String username);


    boolean insertUser(User user);

}
