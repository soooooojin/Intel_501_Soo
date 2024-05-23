package com.busanit501.busanit501_soo.todo.DAO;


import com.busanit501.busanit501_soo.todo.domain.MemberVO;
import com.busanit501.busanit501_soo.todo.domain.TodoVO;
import lombok.Cleanup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDAO {

    public MemberVO getWithPasswordMember(String mid, String mpw) throws Exception {
        String sql = "select * from tbl_member where mid = ? and mpw = ?";

        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, mid);
        pstmt.setString(2, mpw);
        @Cleanup ResultSet resultSet = pstmt.executeQuery();
        resultSet.next();

        MemberVO memberVO = MemberVO.builder()
                .mid(resultSet.getString("mid"))
                .mpw(resultSet.getString("mpw"))
                .mname(resultSet.getString("mname"))
                .build();

        return memberVO;
    }

    //회원가입하는 메서드.
    public void insertMember(MemberVO memberVO) throws Exception {
        String sql = "insert into tbl_member ( mid, mpw, mname) values (?,?,?)";

        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, memberVO.getMid());
        pstmt.setString(2, memberVO.getMpw());
        pstmt.setString(3, memberVO.getMname());
        pstmt.executeUpdate();

    }



//uuid 업데이트 하는 메서드
    public void updateUUID(String mid, String uuid) throws Exception {
        String sql = "update tbl_member set uuid = ? where mid = ? ";

        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, uuid);
        pstmt.setString(2, mid);
        pstmt.executeUpdate();

    }

    //하나의 uuid 가져오는 하는 메서드
    public MemberVO selectUUID(String uuid) throws Exception {
        String sql = "select * from tbl_member where uuid = ? ";

        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, uuid);
        @Cleanup ResultSet resultSet = pstmt.executeQuery();
        resultSet.next();

        MemberVO memberVO = MemberVO.builder()
                .mid(resultSet.getString("mid"))
                .mpw(resultSet.getString("mpw"))
                .mname(resultSet.getString("mname"))
                .uuid(resultSet.getString("uuid"))
                .build();

        return memberVO;

    }


}