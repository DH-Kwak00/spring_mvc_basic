package com.example.demo.controller;

import com.example.demo.domain.Hello;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HelloServletJson", urlPatterns = "/hello-servlet-json")
public class HelloServletJson extends HttpServlet {
//    servlet 에서 json 형태를 만들어주려면 objectMapper라는 클래스를 import해야한다.
    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        Hello hello = new Hello();
        hello.setAge(19);
        hello.setName("kwakdonghoon");
        String result = objectMapper.writeValueAsString(hello);
        resp.getWriter().write(result);
    }
}
