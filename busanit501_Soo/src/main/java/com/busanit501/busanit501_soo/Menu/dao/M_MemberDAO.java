package com.busanit501.busanit501_soo.Menu.dao;

import com.busanit501.busanit501_soo.Menu.domain.M_MemberVO;
import com.busanit501.busanit501_soo.todo.DAO.ConnectionUtil;
import lombok.Cleanup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class M_MemberDAO {

    // id,pw 를 이용해서, 한명의 정보를 가져오기.
    public M_MemberVO getWithPassword(String id, String pw) throws Exception {
        String sql = "select * from menu_member where id = ? and pw = ?";

        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, id);
        pstmt.setString(2, pw);
        @Cleanup ResultSet resultSet = pstmt.executeQuery();
        resultSet.next();

        M_MemberVO M_memberVO = M_MemberVO.builder()
                .id(resultSet.getString("id"))
                .pw(resultSet.getString("pw"))
                .name(resultSet.getString("name"))
                .build();

        return M_memberVO;
    }

    //회원가입하는 메서드.
    public void insertMember(M_MemberVO M_memberVO) throws Exception {
        String sql = "insert into menu_member ( id, pw, name) values (?,?,?)";

        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, M_memberVO.getId());
        pstmt.setString(2, M_memberVO.getPw());
        pstmt.setString(3, M_memberVO.getName());
        pstmt.executeUpdate();

    }



    //uuid 업데이트 하는 메서드
    public void updateUUID(String id, String uuid) throws Exception {
        String sql = "update menu_member set uuid = ? where id = ? ";

        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, uuid);
        pstmt.setString(2, id);
        pstmt.executeUpdate();

    }

    //하나의 uuid 가져오는 하는 메서드
    public M_MemberVO selectUUID(String uuid) throws Exception {
        String sql = "select * from menu_member where uuid = ? ";

        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, uuid);
        @Cleanup ResultSet resultSet = pstmt.executeQuery();
        resultSet.next();

        M_MemberVO memberVO = M_MemberVO.builder()
                .id(resultSet.getString("id"))
                .pw(resultSet.getString("pw"))
                .name(resultSet.getString("name"))
                .uuid(resultSet.getString("uuid"))
                .build();

        return memberVO;

    }



}
