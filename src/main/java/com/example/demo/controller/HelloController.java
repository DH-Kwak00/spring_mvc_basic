package com.example.demo.controller;

import com.example.demo.domain.Hello;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

    @GetMapping("/hello-spring")
    @ResponseBody
    public String helloSpring(){
        return "hello-world-spring";
    }

//    responseBody 어노테이션이 없고, return 타입이 string 이면,
//    templaters/xxx.html을 찾으러 간다.
//    Model을 주입받지 않고 html만을 리턴하면 정적인 html을 return하게 된다.

//    1) responseBody
//      : return 바로 데이터
//    2) responseBody 없이, return String
//      : 깡통 html을 return
//    3) Model+타임리프를 통해서 html 안에 ${html_name}에 사용자로부터 요청 받은 데이터를 동적으로 세팅


//    html만 return
//    메서드+html (화면만)
    @GetMapping("/hello-todo")
    public String helloToDo(){
        return "hello_bin";
    }

//    html+data (화면에 데이터)
//    RequestParam이란 url의 ?를 통해 테이터를 서버로 넘어온 데이터를 꺼내온 것
    @GetMapping("/hello-spring-html")
    public String helloSpringHtml(@RequestParam(value="input_name", required = false/*옵션*/)String name, Model model){
        model.addAttribute("html_name", name);
        return "hello";
    }

//    frontend/ backend 구분 컨트롤
    @GetMapping("/hello-spring-frontend")
    public String helloSpringFrontend(){
        return "hello_frontend";
    }

//    이름(data)만을 return 해주는 API(
    @GetMapping("/hello-string")
    @ResponseBody
    public String helloString(){
        return "Kwakdonghoon"/*return 값이 text타입*/;
    }

//    return 하는 테이터 타입은 현재 JSON이 웹서버에서 표준이 되어가고 있다.
//    JSON은 key:value로 이루어진 테이터 타입으로서 자바의 객체와 유사하다.
//    객체를 만들어서 객체를 return하면 json타입으로 자동 return이 된다.
    @GetMapping("/hello-json")
    @ResponseBody
//    json타입
    public Hello hellojson(){
        Hello h1=new Hello();
        h1.setName("kwk");
        h1.setAge(20);
        return h1;
    }

//
    @PostMapping("/hello-post") /*데이터를 주면서 화면 요청*/
    @ResponseBody
    public String helloPost(@RequestBody Hello hello){
        System.out.println(hello.getName());
        System.out.println(hello.getAge());
        return "ok";
    }
//    요청 방식은 크게 2가지
//    1) get요청
//      : url을 통해 요청하는것 (보안에 취약)
//      : url에 필요한 데이터도 넣어서 요청하는 것
//    @RequestParam

//    2) post요청(url로 표시 X)
//      2-1) form data에 넣어서 요청하는 방식 (회원가입의 정형적인 방식)
//          @RequestParam

//      2-2) body에 넣어서 보내는 방식(raw-json)
//          @RequestBody
}

