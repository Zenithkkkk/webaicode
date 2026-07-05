package kkkk.htinez.demo11;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {
    @RequestMapping("/request")
    public String request(HttpServletRequest request){
        // 获取请求头
        String header=request.getHeader("Sec-Fetch-Dest");
        System.out.println("Sec-Fetch-Dest:"+header);

        //获取请求参数
        String name=request.getParameter("name");
        System.out.println("name:"+name);

        String age=request.getParameter("age");
        System.out.println("age:"+age);

        //获取请求url
        String url=request.getRequestURL().toString();
        String uri=request.getRequestURI().toString();
        System.out.println("url:"+url);
        System.out.println("uri:"+uri);

        //获取请求方法
        String method=request.getMethod();
        System.out.println("method:"+method);

        // 获取请求协议
        String protocol=request.getProtocol();
        System.out.println("protocol:"+protocol);



        return "ok";
    }

}
