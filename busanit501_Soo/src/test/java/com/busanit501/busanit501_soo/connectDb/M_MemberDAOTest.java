package com.busanit501.busanit501_soo.connectDb;

import com.busanit501.busanit501_soo.Menu.dao.M_MemberDAO;
import com.busanit501.busanit501_soo.Menu.domain.M_MemberVO;
import com.busanit501.busanit501_soo.todo.DAO.MemberDAO;
import com.busanit501.busanit501_soo.todo.domain.MemberVO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@Log4j2
public class M_MemberDAOTest {

    private M_MemberDAO memberDAO;

    @BeforeEach
    public void ready() {
       memberDAO = new M_MemberDAO();
    }

    @Test
    public void getSelectOne() throws Exception {
        M_MemberVO memberVO = memberDAO.getWithPassword("lsj99","0918");
        // 기본 출력이고, 전체 출력
//    System.out.println("memberVO : " + memberVO);
        log.info("memberVO : " + memberVO);
    }

//    @Test
//    public void insertMember() throws Exception {
//        M_MemberVO memberVO = M_MemberVO.builder()
//                .id("lsj0523")
//                .pw("1234")
//                .name("이수진0523")
//                .build();
//        memberDAO.insertMember(memberVO);
//        // 디비 콘솔에서 확인하기.
//
//    }

//    @Test
//    public void updateUUId() throws Exception {
//        memberDAO.updateUUID("lsj","test2");
//        // 기본 출력이고, 전체 출력
//        // System.out.println("memberVO : " + memberVO);
//        // 디비 콘솔에서 확인해보기.
//    }

//    @Test
//    public void selectUUID() throws Exception {
//        M_MemberVO memberVO = memberDAO.selectUUID("testuuid3");
//        log.info("memberVO : " + memberVO);
//    }


}
