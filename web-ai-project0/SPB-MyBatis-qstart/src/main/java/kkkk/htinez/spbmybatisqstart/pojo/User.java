package kkkk.htinez.spbmybatisqstart.pojo;
//定义实体类来封装查询结果

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//加data注解，会自动生成getter和setter方法
@Data
@AllArgsConstructor//添加全参构造方法
@NoArgsConstructor//添加无参构造方法
public class User {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private Integer age;


}
