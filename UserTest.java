package cq.emm.pojo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import java.io.IOException;
import java.io.Reader;

public class UserTest {
    @Test
    public void userFindByIdTest(){
        String resources="mybatis-config.xml";
        //创建流
        Reader reader=null;
        try {
            //读取...xml文件内容到reader对象中
            reader = Resources.getResourceAsReader(resources);
        }catch (IOException e){
            e.printStackTrace();
        }
        //初始化 Mybatis数据库，创建SqlSessionFactory类的实例
        SqlSessionFactory sqlMapper=new
                SqlSessionFactoryBuilder().build(reader);
        //创建SqlSession实例
        SqlSession session=sqlMapper.openSession();
        //传入参数查询，返回结果
        User user=session.selectOne("findById",1);
        //输出结果
        System.out.println(user.getUname());
        //关闭session
        session.close();
    }
}