package com.liaofan.adminex;

import org.junit.Before;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class Junit5Test {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @DisplayName("测试方法DisplayName")   // 测试方法的名字
    @Test   // 测试方法
    void testDisplayName() {
        System.out.println("测试方法DisplayName_test");
        System.out.println(jdbcTemplate);
    }


    @Disabled   // 禁用该测试方法
    @Test
    void test2() {
        System.out.println("test2");
    }


    @BeforeEach  // 每个测试方法执行前都会执行
    void testBeforeEach() {
        System.out.println("测试就要开始了");
    }


    @AfterEach    // 每个测试方法执行完后都会执行
    void testAfterEach() {
        System.out.println("测试就要结束了");
    }

    @BeforeAll  // 所有测试方法执行前都会执行
    static void testBeforeAll() {
        System.out.println("所有测试就要开始了");
    }


    @AfterAll   // 所有测试方法执行完后都会执行
    static void testAfterAll() {
        System.out.println("所有测试就要结束了");
    }



    @RepeatedTest(5)   // 执行5次
    @Test
     void testRepeatedTest() {
        System.out.println("执行5次");
     }


    // 测试方法超时
    @Timeout(value = 600,unit = TimeUnit.MILLISECONDS)  // 设置测试方法执行时间
    @Test
    void testTimeOut() throws InterruptedException {
        Thread.sleep(500);
        System.out.println("testTimeOut");
    }




    //测试断言
    @Test
    @DisplayName("测试简单断言")
    void testAssertionsSimple() {
        int cal = cal(3, 3);
        assertEquals(5, cal,"业务逻辑计算失败");   // 测试失败
        Object o1 = new Object();
        Object o2 = new Object();

        assertSame(o1, o2,"两个对象不一样");  // 测试两个对象是否相同
    }


    @Test
    void testAssertionsArray() {    // 测试数组
        assertArrayEquals(new int[]{1, 2, 3}, new int[]{1, 2, 3,4},"数组内容不一样");
    }

    //测试组合断言
    @Test
    void testAll() {
        /**
         * 所有断言方法都是用来测试一个条件是否成立的
         */
        assertAll("testAll",
                () -> assertTrue(true && true,"结果不成立"),
                () -> assertEquals(1, 2,"结果不成立,不相等")
        );
    }


    @DisplayName("测试异常")
    @Test
    void testExcpetions() {
        /**
         * 测试异常_GetException()_断定业务逻辑一定会抛出异常
         */
        assertThrows(ArithmeticException.class, () -> {
            int i = 10 / 0;
        }, "业务逻辑居然正常运行?");
    }


    /**
     * 快速失败
     */
    @DisplayName("快速失败")
    @Test
    void testFail() {
        if(1 == 2) {
            fail("测试失败");
        }
    }

    int cal(int a, int b) {
        return a + b;
    }


    /**
     * 测试前置条件
     */
    @Test
    @DisplayName("测试前置条件")
    void testAssumption() {
        Assumptions.assumeTrue(false,"测试前置条件_^-结果不成立|确认ing....|testAssumption_^-测试失败_End_GetException_Overtime");
        System.out.println(1111);
    }
}
