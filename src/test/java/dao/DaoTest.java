package dao;

import com.atgongda.dao.UserMapper;
import com.atgongda.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 记住@Test前往不要忘写
 *
 * @author sushuai
 * @date 2019/03/03/21:06
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class DaoTest {

    @Autowired
    private UserMapper userMapper;

    /**
     * 通过id来获取User
     */
    @Test
    public void selecUsertById() {
        System.out.println("dao测试开始。。。。");
        System.out.println(userMapper.selectById(1));
        System.out.println("dao测试结束。。。。");


    }

    /**
     * 提示：如果username是中文，则查询为null
     * 解决方法：在jdbc.url后面添加  useUnicode=true&characterEncoding=utf-8  即可解决
     */
    @Test
    public void selectUserByUserName() {
        System.out.println("dao测试开始。。。。");
        System.out.println(userMapper.selectUserByUserName("张三"));
        System.out.println("dao测试结束。。。。");
    }


}
