package com.example.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TddTest {
    @Test
    public void testGetMessage(){
        // given
        HelloWorld hello = new HelloWorld();

        //when
        String message = hello.getMessage();

        // then
        Assertions.assertEquals("HelloWorld", message);
    }

    @Test
    public void testgetMessageName(){
        // given
        HelloWorld hello = new HelloWorld();

        // when
        String message1 = hello.getMessage("insu");
        String message2 = hello.getMessage("shin");

        // then
        Assertions.assertEquals("Hello insu", message1);
        Assertions.assertEquals("Hello shin", message2);
    }

    @Test
    public void testgetMessageNull(){
        HelloWorld hello = new HelloWorld();
        String message = hello.getMessage(null);
        Assertions.assertEquals("Hello World", message);
    }
}
