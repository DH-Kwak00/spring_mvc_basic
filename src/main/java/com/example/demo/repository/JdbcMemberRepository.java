//package com.example.demo.repository;
//
//import com.example.demo.domain.Member;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import javax.sql.DataSource;
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//@Repository
//public class JdbcMemberRepository {
////    데이터 소스가 필요하다 : JDBC와 DB를 연동하는 드라이버 ******
//    private final DataSource dataSource;
//
//    @Autowired
//    public JdbcMemberRepository(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }
//
//    public void save(Member member) throws SQLException {
//        String sql="insert into member(name) values(?)";
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//        ResultSet resultSet = null;
//
//        connection = dataSource.getConnection();
//        preparedStatement = connection.prepareStatement(sql);
//        preparedStatement.setString(1, member.getName());
////        executeQuery는 조회시, insert or update는 executeUpdate
//        preparedStatement.executeUpdate();
//    }
//
//    public List<Member> findAll() throws SQLException {
//        String sql="select * from member";
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//        ResultSet resultSet = null;
//
////        드라이버를 통해 DB정보를 가져와 connection을 맺는다.
//        connection = dataSource.getConnection();
////        key를 꺼내서 preparedStatement에 담고 있게 하는 것
//        preparedStatement = connection.prepareStatement(sql);
////        jdbc를 통해서 쿼리를 수행하면 그 결과 객체는 ResultSet 객체
//        resultSet = preparedStatement.executeQuery();
//        List<Member> lst = new ArrayList<>();
//        while (resultSet.next()){
//            Member member = new Member();
//            member.setId(resultSet.getLong("id"));
//            member.setName(resultSet.getString("name"));
//            lst.add(member);
//        }
//        return lst;
//    }
//
//    public Member findById(long id)throws SQLException{
//
//        String sql="select * from member where id = ?";
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//        ResultSet resultSet = null;
//
//        connection = dataSource.getConnection();
//        preparedStatement = connection.prepareStatement(sql);
//        preparedStatement.setLong(1, id);
//        resultSet = preparedStatement.executeQuery();
//
//        if (resultSet.next()){
//            Member member = new Member();
//            member.setId(resultSet.getLong("id"));
//            member.setName(resultSet.getString("name"));
//            return member;
//        }
//        return null;
//    }
//
//    public List<Member> findByName(String name){
//        return null;
//    }
//}
