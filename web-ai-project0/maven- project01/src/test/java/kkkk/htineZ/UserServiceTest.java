package kkkk.htineZ;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;

@DisplayName("用户信息类")
public class UserServiceTest {
    @BeforeAll
    public static void beforeAll(){
        System.out.println("before allll"+"\n");
    }
    @AfterAll //在所有方法运行前/后运行，一定要用static修饰
    public static void afterAll(){
        System.out.println("after allll");
    }
    @BeforeEach
    public void beforeEach(){
        System.out.println("before each");
    }
    @AfterEach
    public void afterEach(){
        System.out.println("after each"+"\n");
    }
    @Test
    public void testGetAge(){
        UserService uss=new UserService();
        int age=uss.getAge("100000200009081011");
        System.out.println(age);
    }
    //断言操作
    @Test
    public void testGetGender(){
        UserService uss=new UserService();
        String gender=uss.getGender("100000200009081011");
        Assertions.assertEquals("男",gender,"性别判断有误");
        Assertions.assertThrows(IllegalArgumentException.class,()-> {
                    uss.getGender(null);
                });
        System.out.println(gender);
    }



    //参数化测试
    @DisplayName("用户性别")
    @ParameterizedTest
    @ValueSource(strings ={"100000200009081011","100000200009081031","100000200009081078"})
    public void testGetGender2(String idCard){
        UserService uss=new UserService();
        String gender=uss.getGender(idCard);
        Assertions.assertEquals("男",gender,"性别判断有误");
        Assertions.assertThrows(IllegalArgumentException.class,()-> {
            uss.getGender(null);
        });
        System.out.println(gender);
    }
}
