package com.example.swaggertest.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Tag(name="test API", description="test용 API입니다.")
public class HomeController {

    @Operation(summary="홈페이지화면", description = "홈페이지 첫 화면을 띄워줍니다.")
    @GetMapping("/")
    public String index(){
        return "home";
    }

    @Operation(summary="인사말", description="입력한 이름과 함께 인사말을 출력합니다.")
    @Parameter(name="name", description="인사말과 함께 출력될 이름")
    @PostMapping("/document")
    public String doc(String name, Model model){
        System.out.println(name);
        model.addAttribute("name", name);
        return "doc";
    }
}
