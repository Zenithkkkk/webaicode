package kkkk.htinez.springbootweb001.Dao.impl;

import cn.hutool.core.io.IoUtil;
import kkkk.htinez.springbootweb001.Dao.userDao;
import kkkk.htinez.springbootweb001.pojo.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

@Repository
public class daoImpl  implements userDao {
    @Override
    public ArrayList<String> test() {
        //1.获得输入流
        InputStream in=this.getClass().getClassLoader().getResourceAsStream("user.txt");
        //2.读取文件
        ArrayList<String> lines= IoUtil.readLines(in, UTF_8, new ArrayList<>());

        return  lines;
    }
}
