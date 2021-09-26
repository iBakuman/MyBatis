import com.example.dao.IUserDao;
import com.example.dao.impl.UserDaoImpl;
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
        userDao = new UserDaoImpl(factory);
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
     * 测试保存操作
     */
    @Test
    public void testSaveUser() throws Exception {
        User user = new User();
        user.setUsername("龚胜辉");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("湖南");
        System.out.println("保存前：user.getId() = " + user.getId() + ", user = " + user);
        userDao.saveUser(user);
        System.out.println("保存后：user.getId() = " + user.getId() + ", user = " + user);
    }

    /**
     * 测试更新操作
     */
    @Test
    public void testUpdate() {
        User user = new User();
        user.setUsername("龚胜辉");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("北京");
        user.setId(30);

        userDao.updateUser(user);
    }

    /**
     * 测试删除操作
     */
    @Test
    public void testDelete() {
        Integer id = 30;
        userDao.deleteUser(id);
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
     * 测试聚合函数
     */
    @Test
    public void testFindTotal() {
        int total = userDao.findTotal();
        System.out.println(total);
    }

}
