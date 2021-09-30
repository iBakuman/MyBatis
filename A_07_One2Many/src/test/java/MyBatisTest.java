import com.example.dao.IAccountDao;
import com.example.dao.IUserDao;
import com.example.domain.Account;
import com.example.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

// 测试MyBatis的CRUD操作
public class MyBatisTest {
    private InputStream in;
    private SqlSession sqlSession;
    private IUserDao userDao;
    private IAccountDao accountDao;

    @Before // 指示在测试方法之前执行
    public void init() throws Exception {
        // 1.读取配置文件，生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 2.获取SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = factory.openSession();
        // 3.使用工程对象，创建dao对象
        userDao = session.getMapper(IUserDao.class);
        accountDao = session.getMapper(IAccountDao.class);
    }

    @After// 指示在测试方法之后执行
    public void destory() throws Exception {
        in.close();
    }

    /**
     * 测试查询所有账户
     *
     * @throws Exception
     */
    @Test
    public void testFindAllUsers() throws Exception {
        // 5.执行查询所有方法
        List<User> users = userDao.findAll();
        for (User user : users)
            System.out.println(user);

        System.out.println(System.getProperty("java.class.path"));
    }

    /**
     * 测试查询账户操作
     */
    @Test
    public void testFindUserById() {
        Integer id = 20;
        User user = userDao.findById(id);
        System.out.println(user);
    }

    /**
     * 测试查询所有账户
     */
    @Test
    public void testFindAllAccounts() {
        List<Account> accounts = accountDao.findAll();
        for (Account account : accounts)
            System.out.println(account);
    }
}
