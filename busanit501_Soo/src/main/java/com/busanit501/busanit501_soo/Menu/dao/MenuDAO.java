package com.busanit501.busanit501_soo.Menu.dao;

import com.busanit501.busanit501_soo.Menu.domain.MenuVo;
import lombok.Cleanup;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MenuDAO {

    public List<MenuVo> selectAll() throws  Exception{

        String sql = "select * from lunchmenu";

        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement ps = conn.prepareStatement(sql);
        @Cleanup ResultSet rs = ps.executeQuery();

        List<MenuVo> list = new ArrayList<>();

        while (rs.next()) {
            MenuVo menuVoBuilder = MenuVo.builder()
                    .menuNo(rs.getLong("menuNo"))
                    //Vo에 적어놨던 애               테이블에 있는 애
                    .menuTitle(rs.getString("MenuTitle"))
                    .regDate(rs.getDate("MenuRegDate").toLocalDate())
                    .build();
            list.add(menuVoBuilder);
        }

        return list;
    }

    //조회하기
    public MenuVo selectOne(Long menuNo) throws  Exception{
        String sql = "select * from lunchmenu where menuNo = ?";
        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, menuNo);
        @Cleanup ResultSet rs = ps.executeQuery();
        rs.next();

        MenuVo menuVo = MenuVo.builder()
                .menuNo(rs.getLong("menuNo"))
                .menuTitle(rs.getString("MenuTitle"))
                .regDate(rs.getDate("MenuRegDate").toLocalDate())
                .build();

        return new MenuVo();
    }

    //쓰기
    public void insert(MenuVo menuVo) throws  Exception{
        String sql = "insert into lunchmenu(MenuNo,MenuTitle,MenuRegDate) values(?,?,?)";
        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, menuVo.getMenuNo());
        ps.setString(2, menuVo.getMenuTitle());
        ps.setDate(3, Date.valueOf(menuVo.getRegDate()));

        ps.executeUpdate();
    }
    //수정
    public void update(MenuVo menuVo) throws  Exception{
        String sql = "update lunchmenu set  MenuTitle = ? , MenuRegDate = ? where menuNo = ?";
        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, menuVo.getMenuTitle());
        ps.setDate(2, Date.valueOf(menuVo.getRegDate()));
        ps.setLong(3, menuVo.getMenuNo());
        ps.executeUpdate();
    }
    //삭제
    public void delete(Long menuNo) throws  Exception{
        String sql = "delete from lunchmenu where menuNo = ?";
        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, menuNo);
        ps.executeUpdate();
    }
}
