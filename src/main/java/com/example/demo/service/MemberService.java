package com.example.demo.service;

import com.example.demo.domain.Member;
//import com.example.demo.repository.JdbcMemberRepository;
//import com.example.demo.repository.MemberRepository;
//import com.example.demo.repository.JdbcTemplateMemberRepository;
import com.example.demo.repository.JpaMemberRepository;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;

//   스프링빈에 등록
@Service
// 만약에 DB연동이 있다면
@Transactional
public class MemberService {
//    private final MemberRepository memberRepository;
//    public MemberService(MemberRepository memberRepository){
//        this.memberRepository=memberRepository;
//    }

    private final JpaMemberRepository memberRepository;
    public MemberService(JpaMemberRepository memberRepository){
        this.memberRepository=memberRepository;
    }

    public void create(Member member) throws SQLException {
        memberRepository.save(member);
    }

    public List<Member> findAll() throws SQLException {
//        List<Member> lst = memberRepository.findAll();
        return memberRepository.findAll();
    }

    public Member findOne(Long id) throws SQLException {
        return memberRepository.findById(id);

    }

//    public List<Member> findByName(String name){
//        return memberRepository.findByName(name);
//    }

//    public Member findByIdAndName(Long id, String name){
//        return memberRepository.findByIdAndName(id, name);
//    }
}
