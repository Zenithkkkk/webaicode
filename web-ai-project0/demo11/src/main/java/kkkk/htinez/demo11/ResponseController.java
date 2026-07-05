package kkkk.htinez.demo11;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ResponseController {
    @RequestMapping("/response")
    public void response(HttpServletResponse response) throws IOException {

        //设置响应头（通常不设置，由浏览器自动设置）
        response.setHeader("name","Zenith");

        // 设置Content-Type为HTML格式
        response.setContentType("text/html;charset=utf-8");

        //设置响应状态码
        response.setStatus(400);

        //设置响应体
        response.getWriter().write("<h1>Hello！！！ response</h1>");

    }



    //法2:ResponseEntity

    @RequestMapping("/response2")
    public ResponseEntity<String> response2 (){
        return ResponseEntity.status(404).header("age","1999").body("<h1>Hello！！！ response2</h1>") ;
        //使用链式编程
    }
}
