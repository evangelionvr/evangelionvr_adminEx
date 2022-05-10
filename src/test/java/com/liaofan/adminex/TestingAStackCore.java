package com.liaofan.adminex;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.EmptyStackException;
import java.util.Stack;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author liaofan
 */

@DisplayName("A stack")
class TestingAStackCore {


    /**
     * 参数化测试
     *一个参数化测试可以包含多个参数，每个参数都由一个值和一个描述符组成。
     * 每一个数组元素都是一个值，每个值都是一个参数的值。
     * @param i
     */
    @DisplayName("参数化测试_simple_123_Value")
    @ValueSource(ints = {1, 2, 3,4,5})
    @ParameterizedTest
    void testParamter(int i) {
        System.out.println(i);
    }

    @ParameterizedTest
    @DisplayName("从方法中读取参数_参数化测试")
    @MethodSource("stringProvider")
    void testParamter_2c(String s) {
        System.out.println(s);
    }

    /**
     * 嵌套测试-
     * @return
     */
    static Stream<String> stringProvider() {
        return Stream.of("foo", "bar","evangelionvr");
    }

    Stack<Object> stack;

    @Test
    @DisplayName("is instantiated with new Stack()")
    void isInstantiatedWithNew() {
        new Stack<>();
    }

    @Nested
    @DisplayName("when new")
    class WhenNew {

        @BeforeEach
        void createNewStack() {
            stack = new Stack<>();
        }

        @Test
        @DisplayName("is empty")
        void isEmpty() {
            assertTrue(stack.isEmpty());
        }

        @Test
        @DisplayName("throws EmptyStackException when popped")
        void throwsExceptionWhenPopped() {
            assertThrows(EmptyStackException.class, stack::pop);
        }

        @Test
        @DisplayName("throws EmptyStackException when peeked")
        void throwsExceptionWhenPeeked() {
            assertThrows(EmptyStackException.class, stack::peek);
        }

        @Nested
        @DisplayName("after pushing an element")
        class AfterPushing {

            String anElement = "an element";

            @BeforeEach
            void pushAnElement() {
                stack.push(anElement);
            }

            @Test
            @DisplayName("it is no longer empty")
            void isNotEmpty() {
                assertFalse(stack.isEmpty());
            }

            @Test
            @DisplayName("returns the element when popped and is empty")
            void returnElementWhenPopped() {
                assertEquals(anElement, stack.pop());
                assertTrue(stack.isEmpty());
            }

            @Test
            @DisplayName("returns the element when peeked but remains not empty")
            void returnElementWhenPeeked() {
                assertEquals(anElement, stack.peek());
                assertFalse(stack.isEmpty());
            }
        }
    }
}
