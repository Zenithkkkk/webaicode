package kkkk.htinez.spbmybatisqstart;

import kkkk.htinez.spbmybatisqstart.Mapper.UserMapper;
import kkkk.htinez.spbmybatisqstart.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest//这是SPB中单元测试的注解 --当前测试方法运行时会启动当前SPRINGBOOT项目 --IOC容器
class SpbMyBatisQstartApplicationTests {
    //有了ioc容器，就可以直接从ioc容器注入bean了->可用UserMapper了

    @Autowired
    private UserMapper userMapper;


    @Test
    public void testFindAll(){

        List<User> userList=userMapper.findAll();
        userList.forEach(user -> System.out.println(user));
    }


    @Test
    public void testDeleteById(){

        //res为影响的记录数
        int res=userMapper.deleteByid(4);
        System.out.println("影响的记录数为："+res);

    }

    @Test
    public void  testInsert(){
        User user=new User(null,"zhangfei","123456","张飞",32);
        int res=userMapper.insert(user);
        System.out.println("影响的记录数为："+res);

    }

    @Test
    public void testUpdate(){
        User user=new User(1,"zhouyu","667788","周瑜",27);
        int res=userMapper.update(user);
        System.out.println("影响的记录数为："+res);


    }

    @Test
    public void testFindByUsernameandPassword(){
        User user=userMapper.findByUsernameAndPassword("zhouyu","667788");
        System.out.println(user);
    }


}
