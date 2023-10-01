package com.example.loggingtest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    Logger logger = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/")
    public String hello(){
        logger.trace("Trace Log");
        logger.debug("Debug Log");
        logger.info("Info Log");
        logger.warn("Warn Log");
        logger.error("Error Log");
        return "hello";
    }
}
