import com.example.dao.IStudentDao;
import com.example.dao.IUserDao;
import com.example.domain.Student;
import com.example.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * mybatis实现类
 */
public class MyBatis {
    public static void main(String[] args) throws Exception {
        // 1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 2.创建SqlSessionFactory工程
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        // 3.使用工厂生产SqlSession对象
        SqlSession session = factory.openSession();
        // 4.使用SqlSession创建Dao接口的代理对象
        IUserDao userDao = session.getMapper(IUserDao.class);
        IStudentDao studentDao = session.getMapper(IStudentDao.class);
        System.out.println(studentDao.getClass());// class com.sun.proxy.$Proxy4
        // 5.使用代理对象执行方法
        List<User> users = userDao.findAll();
        List<Student> students = studentDao.findAll();
        for (Student student : students)
            System.out.println(student);
        System.out.println("---------------");
        for (User user : users)
            System.out.println(user);
        // 6.释放资源
        session.close();
        in.close();
    }
}
