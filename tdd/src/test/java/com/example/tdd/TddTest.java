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

}
