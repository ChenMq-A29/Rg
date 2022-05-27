import cq.emm.pojo.Employee;
import cq.emm.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MybatisT {
    @Test
    public void findByIdTest(){
        SqlSession session= MyBatisUtils.getSession();
        Employee employee=
                session.selectOne("cq.emm.mapper.EmployeeMapper.findById",2);
        System.out.println(employee);
        session.commit();
        session.close();
    }
    @Test
    public void insertEmployeeTest(){
        SqlSession session=MyBatisUtils.getSession();
        Employee employee=new Employee();
        employee.setId(4);
        employee.setName("赵六");
        employee.setAge(55);
        employee.setPosition("总裁");
        int result=session.insert("cq.emm.mapper.EmployeeMapper.addEmployee",employee);
        if(result>0){
            System.out.println("成功插入"+result+"条数据");
        }else{
            System.out.println("插入数据失败");
        }
        System.out.println(employee.toString());
        session.commit();
        session.close();
    }
    @Test
    public void updateEmployeeTest(){
        SqlSession session=MyBatisUtils.getSession();
        Employee employee   =new Employee();
        employee.setId(2);
        employee.setName("小四");
        employee.setAge(23);
        employee.setPosition("经理");
        int result=session.update("cq.emm.mapper.EmployeeMapper.updateEmployee",employee);
        if(result>0){
            System.out.println("成功更新"+result+"条数据");
        }else{
            System.out.println("更新数据失败");
        }
        System.out.println(employee.toString());
        session.commit();
        session.close();
    }
    @Test
    public void deleteEmployeeTest(){
        SqlSession session=MyBatisUtils.getSession();
        int result=session.delete("cq.emm.mapper.EmployeeMapper.deleteEmployee",3);
        if(result>0){
            System.out.println("成功删除"+result+"条数据");
        }else{
            System.out.println("删除数据失败");
        }
        session.commit();
        session.close();
    }
}
