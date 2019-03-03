package dao;

import com.atgongda.dao.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author sushuai
 * @date 2019/03/03/21:06
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class selectByIdDaoTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void testSelectById(){
        System.out.println("dao测试开始");
        System.out.println(userMapper.selectById(1));
        System.out.println("dao测试结束");
    }
}
