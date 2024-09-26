package com.spring.basic.servlet.repository;

import com.spring.basic.servlet.domain.Member;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*
CREATE DATABASE spring;
USE spring;

CREATE TABLE tbl_members (
	id VARCHAR(30) PRIMARY KEY,
    pw VARCHAR(30) NOT NULL,
    name VARCHAR(15) NOT NULL,
    age INT DEFAULT 0
);
 */


// 역할: 실제 데이터베이스에 Member들을 CRUD
// MVC -> Model
public class MemberRepositoryImpl implements MemberRepository {

    // 싱글톤 구현
    private MemberRepositoryImpl() {}

    private static MemberRepositoryImpl repo = new MemberRepositoryImpl();

    public static MemberRepositoryImpl getInstance() {
        return repo;
    }

    private String username = "root"; // db 계정명
    private String password = "mysql"; // db 패스워드
    // db url(데이터베이스 주소)
    private String url = "jdbc:mysql://localhost:3306/spring?serverTimezone=Asia/Seoul";
    private String driverClassName = "com.mysql.cj.jdbc.Driver"; // db 벤더별 전용 커넥터 클래스


    @Override
    public void save(Member member) {
        try(Connection conn = DriverManager.getConnection(url, username, password)) {
            // 커넥터 드라이버 강제 구동 -> 자바 프로그램과 DB 연동
            Class.forName(driverClassName);

            // 실행할 SQL을 작성 (문자열)
            String sql = "INSERT INTO tbl_members VALUES(?, ?, ?, ?)";

            // SQL을 실행할 객체를 생성.
            PreparedStatement pstmt = conn.prepareStatement(sql);

            // 미완성 SQL의 ? 값 채우기
            pstmt.setString(1, member.getId());
            pstmt.setString(2, member.getPw());
            pstmt.setString(3, member.getUserName());
            pstmt.setInt(4, member.getAge());

            // 실행 명령
            // INSERT, UPDATE, DELETE는 실행 명령 메서드가 똑같습니다.
            pstmt.executeUpdate(); // 성공 시 실행 쿼리문의 개수, 실패 시 0

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Member> getList() {
        // DB 접속을 위한 객체 Connection
        try(Connection conn = DriverManager.getConnection(url, username, password)) {
            // 커넥터 드라이버 강제 구동 -> 자바 프로그램과 DB 연동
            Class.forName(driverClassName);

            // 실행할 SQL을 작성 (문자열)
            String sql = "SELECT * FROM tbl_members ORDER BY age DESC";

            // SQL을 실행할 객체를 생성.
            PreparedStatement pstmt = conn.prepareStatement(sql);

            // 미완성 SQL의 ? 값 채우기

            // 실행 명령 - SELECT는 다른 메서드를 사용. (후속 작업 필요)
            // ResultSet -> SELECT 쿼리의 결과 집합을 가지고 있는 객체.
            ResultSet rs = pstmt.executeQuery();
            List<Member> memberList = new ArrayList<>();

            while (rs.next()) {
                // next()가 true를 리턴하고, 한 행씩 타겟을 잡아줌.
                // 타겟으로 잡힌 행의 각 컬럼을 달라고 얘기하면 됨.
                Member m = new Member(
                        rs.getString("id"),
                        rs.getString("pw"),
                        rs.getString("name"),
                        rs.getInt("age")
                );

                memberList.add(m);
            }

            return memberList;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}











