package kkkk.htinez.springbootweb001.Controller;

import jakarta.annotation.Resource;
import kkkk.htinez.springbootweb001.Service.Impl.UserServiceImpl;
import kkkk.htinez.springbootweb001.Service.userService;
import kkkk.htinez.springbootweb001.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class Usercontroller {
    // 方式一
//    @Autowired
//    private userService userService;

//    //方式二：构造函数注入
//    private final userService userService;//要加final
//    @Autowired//UserServiceImpl
//    public Usercontroller(userService userService) {
//        this.userService = userService;
//    }

    //方式三：Setter注入
    private userService userService;
    @Resource(name = "kkk")
    public  void setUserService(userService userService){
        this.userService= userService;
    }

    @RequestMapping("/list")
    @ResponseBody  // 添加此注解，直接返回数据而不是视图名称
    public List<User> list2() throws Exception {
        // 目的是通过controller从文件获得到一段json返回前端
        return userService.list();
    }
}
