package com.busanit501.busanit501_soo.connectDb.service;

import com.busanit501.busanit501_soo.Menu.dto.M_MemberDTO;
import com.busanit501.busanit501_soo.Menu.service.M_MemberService;
import com.busanit501.busanit501_soo.todo.dto.MemberDTO;
import com.busanit501.busanit501_soo.todo.service.MemberService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@Log4j2
public class M_MemberServiceTests {

    private M_MemberService M_memberService;

    // 아래에 다른 메서드들이 실행되기전에, 먼저 실행이 됨.(역할, todoService 초기화 해주는 역할)
    @BeforeEach
    public void ready(){
        M_memberService = M_MemberService.INSTANCE;
    }

    @Test
    public  void getOneMemberTest() throws Exception {
        // TodoService 기능 구현 확인.
        M_MemberDTO M_memberDTO = M_memberService.getOneMember("lsj99","0918");
        log.info("M_memberDTO: "+ M_memberDTO);
    }

//    @Test
//    public  void updateUUID() throws Exception {
//        M_memberService.updateUUID("lsj04","testuuid99");
//        // 디비 콘솔에서 확인하기.
//    }
//
//    @Test
//    public  void selectUUID() throws Exception {
//        M_MemberDTO M_memberDTO = M_memberService.selectUUID("testuuid99");
//        log.info("M_memberDTO : " + M_memberDTO);
//        // 디비 콘솔에서 확인하기.
//    }
//
//    @Test
//    public void insertMember() throws Exception {
//        M_MemberDTO M_memberDTO = M_MemberDTO.builder()
//                .id("lsj0918")
//                .pw("990918")
//                .name("이수진0918")
//                .build();
//
//        M_memberService.insertMember(M_memberDTO);
//    }


}


