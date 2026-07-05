package kkkk.htineZ;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * 用户服务类的单元测试
 */
@DisplayName("UserService 性别获取方法测试")
public class userServiceTestAI {

    private UserService userService;

    @BeforeEach
    public void setUp() {
        // 初始化被测对象
        userService = new UserService();
    }

    /**
     * 测试正常情况下的男性身份证号
     */
    @Test
    @DisplayName("给定有效的男性身份证号，应返回'男'")
    public void testGetGender_Male() {
        String idCard = "100000200009081011"; // 第17位是1 -> 奇数
        String result = userService.getGender(idCard);
        Assertions.assertEquals("男", result, "期望返回'男'");
    }

    /**
     * 测试正常情况下的女性身份证号
     */
    @Test
    @DisplayName("给定有效的女性身份证号，应返回'女'")
    public void testGetGender_Female() {
        String idCard = "100000200009081022"; // 第17位是2 -> 偶数
        String result = userService.getGender(idCard);
        Assertions.assertEquals("女", result, "期望返回'女'");
    }

    /**
     * 参数化测试多个有效身份证号，验证性别正确性
     */
    @ParameterizedTest
    @ValueSource(strings = {
            "100000200009081011", // 男
            "100000200009081031",
            "100000200009081051"
    })
    @DisplayName("多组男性身份证号测试")
    public void testGetGender_ParameterizedMale(String idCard) {
        String result = userService.getGender(idCard);
        Assertions.assertEquals("男", result, "期望返回'男'");
    }

    /**
     * 参数化测试多个无效身份证号，验证是否抛出异常
     */
    @ParameterizedTest
    @ValueSource(strings = {
            "",                     // 空字符串
            "12345678901234567",   // 少于18位
            "1234567890123456789", // 多于18位
    })
    @DisplayName("非法身份证格式时应抛出异常")
    public void testGetGender_InvalidIdCard_ShouldThrowException(String invalidIdCard) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            userService.getGender(invalidIdCard);
        }, "当传入非法身份证号时应该抛出 IllegalArgumentException");
    }
}
