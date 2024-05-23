package com.busanit501.busanit501_soo.connectDb;

import com.busanit501.busanit501_soo.Menu.dao.MenuDAO;
import com.busanit501.busanit501_soo.todo.DAO.MemberDAO;
import com.busanit501.busanit501_soo.todo.DAO.TodoDAO;
import com.busanit501.busanit501_soo.todo.domain.MemberVO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@Log4j2
public class MemberDAOTest {

    private MemberDAO memberDAO;

    @BeforeEach
    public void ready() {
       memberDAO = new MemberDAO();
    }

    @Test
    public void getSelectOne() throws Exception {
        MemberVO memberVO = memberDAO.getWithPasswordMember("lsj","1234");
        // 기본 출력이고, 전체 출력
//    System.out.println("memberVO : " + memberVO);
        log.info("memberVO : " + memberVO);

    }

    @Test
    public void insertMember() throws Exception {
        MemberVO memberVO = MemberVO.builder()
                .mid("lsj0523")
                .mpw("1234")
                .mname("이수진0523")
                .build();
        memberDAO.insertMember(memberVO);
        // 디비 콘솔에서 확인하기.

    }

    @Test
    public void updateUUId() throws Exception {
        memberDAO.updateUUID("lsj","test2");
        // 기본 출력이고, 전체 출력
        // System.out.println("memberVO : " + memberVO);
        // 디비 콘솔에서 확인해보기.
    }

    @Test
    public void selectUUID() throws Exception {
        MemberVO memberVO = memberDAO.selectUUID("testuuid3");
        log.info("memberVO : " + memberVO);
    }


}
