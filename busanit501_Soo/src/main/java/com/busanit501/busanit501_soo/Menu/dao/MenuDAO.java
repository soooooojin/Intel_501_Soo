package com.busanit501.busanit501_soo.Menu.dao;

import com.busanit501.busanit501_soo.Menu.domain.MenuVo;
import com.busanit501.busanit501_soo.todo.domain.TodoVo;
import lombok.Cleanup;

import java.sql.Connection;
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
}
