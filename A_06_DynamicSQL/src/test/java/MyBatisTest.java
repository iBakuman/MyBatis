import com.example.dao.IUserDao;
import com.example.domain.QueryVo;
import com.example.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

// 测试MyBatis的CRUD操作
public class MyBatisTest {
    private InputStream in;
    private SqlSession sqlSession;
    private IUserDao userDao;

    @Before // 指示在测试方法之前执行
    public void init() throws Exception {
        // 1.读取配置文件，生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 2.获取SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 3.使用工程对象，创建dao对象
        userDao = factory.openSession().getMapper(IUserDao.class);
    }

    @After// 指示在测试方法之后执行
    public void destory() throws Exception {
        in.close();
    }

    @Test
    public void testFindAll() throws Exception {
        // 5.执行查询所有方法
        List<User> users = userDao.findAll();
        for (User user : users)
            System.out.println(user);

        System.out.println(System.getProperty("java.class.path"));
    }

    /**
     * 测试查询操作
     */
    @Test
    public void testFindById() {
        Integer id = 20;
        User user = userDao.findById(id);
        System.out.println(user);
    }

    /**
     * 测试模糊查询
     */
    @Test
    public void testFindByUsername() {
        List<User> users = userDao.findByUsername("%龚%");
        for (User user : users)
            System.out.println(user);
    }

    /**
     * 测试根据QueryVo来查找
     */
    @Test
    public void testFindByQueryVo(){
        QueryVo queryVo = new QueryVo();
        User user = new User();
        user.setUsername("龚胜辉");
        queryVo.setUser(user);
        List<User> users = userDao.findUserByVo(queryVo);
        for(User luser : users)
            System.out.println(luser);
    }
}
