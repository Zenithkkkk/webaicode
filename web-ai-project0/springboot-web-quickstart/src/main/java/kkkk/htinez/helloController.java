package kkkk.htinez;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//标识为请求处理类
public class helloController
{
    //请求路径
    @RequestMapping("/hello")
    public String hello(String name){
        System.out.println("name:"+name);
        return "hello "+name+" !!!!";

    }
}
