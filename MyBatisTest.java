import cq.emm.pojo.Student;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.apache.ibatis.io.Resources;
import org.junit.Test;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class MyBatisTest {
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    @Before
    public void init(){
        //定义读取文件名
        String resources="mybatis-config.xml";
        //创建流
        Reader reader=null;
        try {
            reader=Resources.getResourceAsReader(resources);
            SqlSessionFactory sqlMapper=new
                    SqlSessionFactoryBuilder().build(reader);
            sqlSession=sqlMapper.openSession();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    @Test
    public void findAllStudentTest(){
        List<Student> list=
                sqlSession.selectList("cq.emm.mapper.StudentMapper.findAllStudent");
        for (Student student:list){
            System.out.println(student);
        }
    }
    @After
    public void destory(){
        sqlSession.commit();
        sqlSession.close();
    }
}
