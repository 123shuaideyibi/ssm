package com.atgongda.service;

import com.atgongda.entity.User;

/**
 * @author sushuai
 * @date 2019/03/03/23:00
 */
public interface UserService {

    /**
     * 根据id来查询用户信息
     * @param id
     * @return
     */
    User selectById(int id);
}
