package com.atgongda.service;

import com.atgongda.entity.User;

/**
 * @author sushuai
 * @date 2019/03/03/23:00
 */
public interface UserService {

    /**
     * 通过username来查询该用户的信息，如果能查到，则该用户存在，如果不能让查到，则该用户不存在
     * @param username
     * @return
     */
    User selectUserByUserName(String username);


    boolean insertUser(User user);

}
