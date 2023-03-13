package com.example.demo.controller;

import com.example.demo.domain.Member;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//    회원가입
//    회원 목록 리스트 상세보기
//    스프링빈에 등록 >> 스프링빈이란? 스프링 프레임워크가 미리 객체를 만들어 놓은 것.
@Controller/*스프링이 기동될때 컨트롤러는 즉시 사용가능하도록 스프링이 스프링빈을 생성한다. 생성자란 해당 클래스가 객체화 될 때 자동으로 실행되는 메서드. 해당 생성자 안에 멤버서비스를 넣음으로서 멤버서비스도 new 할필요없이 사용 가능*/
// @Bean, @Component 어노테이션을 통해 선언되 있는 것들은 bean으로 등록
public class MemberController {
    private final MemberService memberService;
//    생성자(?) 주입 ** : Autowired 어노테이션을 사용하여 멤버 서비스를 주입 받는다

//    Autowired는 생략 가능
    @Autowired
    public MemberController(MemberService memberService){
        this.memberService=memberService;
    }

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/members/new")
    public String returnFormHtml(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String createData(@RequestParam(value="myName")String name) throws SQLException {
//        System.out.println("입력한 name은 "+name);
        Member member=new Member();
        member.setName(name);
//        멤버서비스를 호출
        memberService.create(member);

        return "redirect:/";
    }

    @GetMapping("/members/list")
    public String memberList(Model model) throws SQLException {
//        List<Member>lst=new ArrayList<>();
//        Member m1=new Member();
//        m1.setId(1L);
//        m1.setName("tmp name1");
//        lst.add(m1);
//        Member m2=new Member();
//        m2.setId(2L);
//        m2.setName("tmp name2");
//        lst.add(m2);
        model.addAttribute("members", memberService.findAll());
        return "members/memberList";
    }

    @GetMapping("/members/detail")
    public String memberDetail(@RequestParam(value="id")Long id, Model model) throws SQLException {
        model.addAttribute("member", memberService.findOne(id));
        return "members/memberDetail";
    }

//    @GetMapping("/members/findbyname")
//    @ResponseBody
//    public List<Member> memberFindByName(@RequestParam(value="name") String name){
//        return memberService.findByName(name);
//    }

//    @GetMapping("/members/findbyidandname")
//    @ResponseBody
//    public Member memberFindByIdAndName(@RequestParam(value="id")Long id, @RequestParam(value="name")String name){
//        return memberService.findByIdAndName(id, name);
//    }

}
