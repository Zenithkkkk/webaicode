package kkkk.Zenith;

import com.mysql.jdbc.Driver;
import kkkk.Zenith.pojo.User;
import org.junit.jupiter.api.Test;

import java.sql.*;

public class jdbcTest {

    // jdbc入门程序
    @Test
    public void testUpdate() throws Exception {
        //1.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");


        //2.获取数据库的连接
        String url,username,password;
        //jdbc:mysql://固定
        // localhost:3306 数据库地址，默认端口
        //web01 访问的是哪个数据库
        url="jdbc:mysql://localhost:3306/web01";
        username="root";
        password="Lwx2766725828!";
        Connection connection = DriverManager.getConnection(url, username, password);


        //3.获取sql语句的执行对象
        Statement statement=connection.createStatement();//创建Statement对象来执行sql语句

        //4.执行sql语句
        int i=statement.executeUpdate("update user set age = 25 where id = 1 ");//Dml语句都可以用这个
        System.out.println("sql语句执行完毕影响的记录数为："+ i);

        //5.释放资源
        statement.close();
        connection.close();

    }



    @Test
    public void  testInsert() throws  Exception{
        //1.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        //2.获取数据库的连接
        String url,username,password;
        url="jdbc:mysql://localhost:3306/web01";
        username="root";
        password="Lwx2766725828!";
        Connection connection=DriverManager.getConnection(url,username,password);

        //3.获取sql执行对象
        Statement statement=connection.createStatement();

        //4.执行sql语句
        int i=statement.executeUpdate("insert into user values(6,'liubei','123456','刘备',44)");
        System.out.println("sql语句执行完毕影响的记录数为："+ i);

        //5.释放资源
        statement.close();
        connection.close();

    }




    @Test
    public void testSelect() throws Exception {
        // 数据库连接配置 - 请根据实际情况修改
        String URL = "jdbc:mysql://localhost:3306/web01";
        String USERNAME = "root";
        String PASSWORD = "Lwx2766725828!";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        //rs:用于封装查询返回的结果
        ResultSet resultSet = null;

        try {

            // 1.注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2. 获取数据库连接
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            // 3. 定义SQL语句，这里？是占位符(预编译sql)
            String sql = "SELECT id, username, password, name, age FROM user WHERE username = ? AND password = ?";

            // 4.. 获取PreparedStatement对象
            preparedStatement = connection.prepareStatement(sql);

            // 5. 为占位符赋值
            preparedStatement.setString(1, "daqiao");
            preparedStatement.setString(2, "123456");

            // 6. 执行查询
            resultSet = preparedStatement.executeQuery();

            // 7. 处理结果集
            while (resultSet.next()) {
                User user = new User(
                    resultSet.getInt("id"),
                    resultSet.getString("username"),
                    resultSet.getString("password"),
                    resultSet.getString("name"),
                    resultSet.getInt("age")
                );

                // 输出到控制台
                System.out.println(user);
            }

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                // 8. 关闭资源
                try {
                    if (resultSet != null) resultSet.close();
                    if (preparedStatement != null) preparedStatement.close();
                    if (connection != null) connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }


    }
}
