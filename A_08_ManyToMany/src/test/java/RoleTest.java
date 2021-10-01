import com.example.dao.IRoleDao;
import com.example.dao.IUserDao;
import com.example.domain.Role;
import com.example.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class RoleTest {
    private InputStream in;
    private SqlSession sqlSession;
    private IRoleDao roleDao;

    @Before // 指示在测试方法之前执行
    public void init() throws Exception {
        // 1.读取配置文件，生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 2.获取SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = factory.openSession();
        // 3.使用工程对象，创建dao对象
        roleDao = session.getMapper(IRoleDao.class);
    }

    @After// 指示在测试方法之后执行
    public void destory() throws Exception {
        in.close();
    }

    /**
     * 测试查询所有用户
     * @throws Exception
     */
    @Test
    public void testFindAllUsers() throws Exception {
        // 5.执行查询所有方法
        List<Role> roles = roleDao.findAll();
        for (Role role : roles) {
            System.out.println("-------------------");
            System.out.println(role);;
        }
        // System.out.println(System.getProperty("java.class.path"));
    }

}
