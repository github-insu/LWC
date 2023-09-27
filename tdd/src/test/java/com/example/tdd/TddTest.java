package com.example.tdd;

import org.junit.jupiter.api.*;

public class TddTest {
    private HelloWorld hello;
    @BeforeEach
    public void testFirst(){
        hello = new HelloWorld();
    }

    @Test
    public void testGetMessage(){
        // given

        //when
        String message = hello.getMessage();

        // then
        Assertions.assertEquals("HelloWorld", message);
    }

    @Test
    public void testgetMessageName(){
        // given

        // when
        String message1 = hello.getMessage("insu");
        String message2 = hello.getMessage("shin");

        // then
        Assertions.assertEquals("Hello insu", message1);
        Assertions.assertEquals("Hello shin", message2);
    }

    @Test
    public void testgetMessageNull(){
        // given

        // when
        String message = hello.getMessage(null);

        // then
        Assertions.assertEquals("Hello World", message);
    }
}
