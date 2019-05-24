import com.github.pagehelper.PageInfo;
import com.jingmo.pojo.Employee;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

/**
 * @author 白金刚
 * @create 2019/5/23-2019
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:springconfig/applicationContext.xml", "classpath:springconfig/springMvc.xml"})
public class MVCtest {
    @Autowired
    WebApplicationContext context;
    MockMvc mockMvc;


    @Before
    public void initMocMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }
@Test
    public void pageTest() throws Exception {
    MvcResult result=mockMvc.perform(MockMvcRequestBuilders.get("/emps").param("pn", "5"))
                .andReturn();
        //取出数据
        MockHttpServletRequest request = result.getRequest();
        PageInfo pageInfo= (PageInfo) request.getAttribute("pageInfo");
    System.out.println("执行成功");
        System.out.println("当前页码"+pageInfo.getPageNum());
        System.out.println("总页码"+pageInfo.getPages());
        System.out.println("总记录数"+pageInfo.getTotal());
        System.out.println("需要连续显示的页码");
        int[] navigatepageNums = pageInfo.getNavigatepageNums();
        for(int i:navigatepageNums){
            System.out.print(" "+i);
        }
        //获取员工数据
        List<Employee> list = pageInfo.getList();
        for (Employee employee:list){
            System.out.println("员工姓名"+employee.getEmpName()+" 员工的email"+employee.getEmail());
        }
    }


}
