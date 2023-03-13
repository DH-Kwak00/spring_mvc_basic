//package com.example.demo.repository;
//
//import com.example.demo.domain.Member;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
//import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
//import org.springframework.stereotype.Repository;
//
//import javax.sql.DataSource;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.*;
//
//@Repository
//
//public class JdbcTemplateMemberRepository {
//    private final DataSource dataSource;
//
//    @Autowired
//    public JdbcTemplateMemberRepository(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }
//
//    public void save(Member member) throws SQLException {
//        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(dataSource);
//        jdbcInsert.withTableName("member");
//
////        jdbcTemplate에서는 key, value 형태인 map을 통해 데이터를 insert
//        Map<String, Object> mp = new HashMap<>();
//        mp.put("name", member.getName());
//
//        jdbcInsert.execute(new MapSqlParameterSource(mp));
//    }
//
//    public List<Member> findAll() throws SQLException {
//        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
////        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
////        jdbc -> ResultSet -> while next() -> List
////        SpringDataJpa -> List
//        List<Member> lst =  jdbcTemplate.query("select * from member", memberRowMapper());
//        return lst;
//    }
//
//    public Member findById(long id)throws SQLException{
//        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//        List<Member> lst =  jdbcTemplate.query("select * from member where id=?", memberRowMapper(), id);
//        for (Member member : lst){
//            return member; /* 에러는 안나지만 적확하지 못 하다 */
//        }
//        return lst.stream().findAny().orElseGet(null);
//    }
//    private RowMapper<Member> memberRowMapper(){
//        return new RowMapper<Member>() {
//            @Override
//            public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
//                System.out.println(rowNum);
////              2이상 : 내부적으로 while문
////              1이하 : Member객체 1개만 return
//                Member member = new Member();
//                member.setId(rs.getLong("id"));
//                member.setName(rs.getString("name"));
//                return member;
//            }
//        };
//    }
//}
