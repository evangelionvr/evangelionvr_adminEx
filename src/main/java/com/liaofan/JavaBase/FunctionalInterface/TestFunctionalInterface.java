package com.liaofan.JavaBase.FunctionalInterface;


/**
 * 测试函数式接口
 * FunctionalInterface 是一个标识接口，它只有一个抽象方法,表示函数式接口,就算你不填写抽象方法，也是一个函数式接口
 * 注解只是为了让IDE能够提示出来，并不是必须的
 * @author Liaofan
 * @date 2022/05/08
 *
 */
@FunctionalInterface   // 声明一个函数式接口
public interface TestFunctionalInterface {
    void test();
}
