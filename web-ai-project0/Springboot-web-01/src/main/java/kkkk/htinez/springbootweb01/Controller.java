package kkkk.htinez.springbootweb01;

import cn.hutool.core.io.IoUtil;
import kkkk.htinez.springbootweb01.Solidpj.User;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sound.sampled.Line;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

@RestController
public class Controller {
    @RequestMapping("/list")
    public List<User> list() throws  Exception { // 修改返回类型为List<String>
        // 加载并读取文件
        // 1. 得到输入流
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("user.txt");

        // 2. 分行读取文件
        ArrayList<String> lines = IoUtil.readLines(in, StandardCharsets.UTF_8, new ArrayList<>());

        //3.解析数据封装数据，再将数据打包为集合
        List<User> userList= lines.stream().map(line -> {
            String[] parts = line.split(",");
            Integer id = Integer.parseInt(parts[0]);
            String username = parts[1];
            String password = parts[2];
            String name = parts[3];
            Integer age = Integer.parseInt(parts[4]);
            LocalDateTime updateTime = LocalDateTime.parse(parts[5], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

            return new User(id,username, password, name, age, updateTime);
        }).toList();

        return userList;

    }
}
