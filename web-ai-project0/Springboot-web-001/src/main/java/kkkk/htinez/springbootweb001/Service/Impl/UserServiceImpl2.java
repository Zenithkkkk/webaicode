package kkkk.htinez.springbootweb001.Service.Impl;

import kkkk.htinez.springbootweb001.Dao.userDao;
import kkkk.htinez.springbootweb001.Service.userService;
import kkkk.htinez.springbootweb001.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl2 implements userService {


    @Autowired
    private userDao userDao;
    @Override
    public List<User> list() {
        ArrayList<String> lines=userDao.test();
        //解析数据封装为集合
        List<User> UserList=lines.stream().map(line->{
            String []parts=line.split(",");

            Integer id=Integer.parseInt(parts[0])+200;
            String username=parts[1];
            String password=parts[2];
            String name=parts[3];
            Integer age=Integer.parseInt(parts[4]);
            LocalDateTime updateTime=LocalDateTime.parse(parts[5], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));


            return new User(id,username, password, name, age, updateTime);
        }).toList();

        return UserList;
    }
}
