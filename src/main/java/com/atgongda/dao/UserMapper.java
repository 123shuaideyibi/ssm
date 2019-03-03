package com.atgongda.dao;

import com.atgongda.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author sushuai
 * @date 2019/03/03/21:33
 */
public interface UserMapper {

    /**
     * 通过id查询用户的所有信息
     * @param id
     * @return
     */
    User selectById(@Param("id") int id);

}
