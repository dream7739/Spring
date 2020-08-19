package com.example.first.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    //viewResolver 동작
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        return "hello" + name;
    }

    //객체가 오면 json으로 만들어서 http 응답
    //responseBody = http의 Body부분으로 바로 뿌림
    //HttpmessageConverter 동작 => 문자 : StringConverter / 객체: JsonConverter 동작
    @GetMapping("hello-api")
    @ResponseBody
    Hello helloAPi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    //static 클래스로 선언 시 클래스 안에서 사용 가능
    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
