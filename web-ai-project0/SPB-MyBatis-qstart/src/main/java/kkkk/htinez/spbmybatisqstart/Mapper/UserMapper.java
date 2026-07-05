package kkkk.htinez.spbmybatisqstart.Mapper;


import kkkk.htinez.spbmybatisqstart.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

//用了mapper后代表，应用程序在运行时会自动为该接口创建一个实现类对象（代理对象）
//并且会自动将该对象放入ioc容器中成为bean对象
@Mapper
public interface UserMapper {

    //查询所有用户
//    @Select("select id, username, password, name, age   from user")

    public List<User> findAll();



    @Delete("delete from user where id =#{id}")
    public int deleteByid(Integer id);


    //values里写的是对象的属性名
    @Insert("insert into user(username, password, name, age) values (#{username},#{password},#{name},#{age})")
    public int insert(User user);


    @Update("update user set username =#{username},password =#{password}, name=#{name}, age=#{age} where id=#{id}")
    public int update(User user);



    //根据用户名和密码查询用户信息
    //这里是基于官方骨架创建的Springboot的项目,其实param是可以省略的，程式会保留形参名
//    @Select("select * from user where username=#{username} and password=#{password}")
//    public User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    @Select("select * from user where username=#{username} and password=#{password}")
    public User findByUsernameAndPassword(String username, String password);
}
