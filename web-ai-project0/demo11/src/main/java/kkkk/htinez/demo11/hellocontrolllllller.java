package kkkk.htinez.demo11;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hellocontrolllllller {
    @RequestMapping("/hiii")
    public String hello(String name){
        System.out.println("name:"+name);
        return "Hello "+name+" !!!!!~";
    }

}
