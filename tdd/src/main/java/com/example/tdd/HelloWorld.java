package com.example.tdd;

public class HelloWorld {
    public String getMessage(){
        return "HelloWorld";
    }

    public String getMessage(String name) {
        if (name == null){
            name = "World";
        }
        return "Hello " + name;
    }
}
