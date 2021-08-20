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
        // 3.获取SqlSession对象
        sqlSession = factory.openSession();
        // 4.获取dao的代理对象
        userDao = sqlSession.getMapper(IUserDao.class);
    }

    @After// 指示在测试方法之后执行
    public void destory() throws Exception {
        sqlSession.commit();
        sqlSession.close();
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
        user.setId(20);

        userDao.updateUser(user);
    }

    /**
     * 测试删除操作
     */
    @Test
    public void testDelete() {
        Integer id = 20;
        userDao.deleteUser(id);
    }

    /**
     * 测试查询操作
     */
    @Test
    public void testFindById() {
        Integer id = 30;
        User user = userDao.findById(id);
        System.out.println(user);
    }

    /**
     * 测试模糊查询
     */
    @Test
    public void testFindByUsername() {
        List<User> users = userDao.findByUsername("%王%");
        for (User user : users)
            System.out.println(user);
    }

    /**
     * 测试使用实体类的包装对象作为查询条件
     */
    @Test
    public void testFindByVo() {
        QueryVo vo = new QueryVo();
        User user = new User();
        vo.setUser(user);
        user.setUsername("%王%");
        List<User> users = userDao.findByVo(vo);
        for(User luser : users)
            System.out.println(luser);
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
