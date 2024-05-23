package com.busanit501.busanit501_soo.connectDb.service;

import com.busanit501.busanit501_soo.todo.dto.MemberDTO;
import com.busanit501.busanit501_soo.todo.dto.TodoDTO;
import com.busanit501.busanit501_soo.todo.service.MemberService;
import com.busanit501.busanit501_soo.todo.service.TodoService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

@Log4j2
public class MemberServiceTests {

    private MemberService memberService;

    // 아래에 다른 메서드들이 실행되기전에, 먼저 실행이 됨.(역할, todoService 초기화 해주는 역할)
    @BeforeEach
    public void ready(){
        memberService = MemberService.INSTANCE;
    }

    @Test
    public  void getOneMemberTest() throws Exception {
        // TodoService 기능 구현 확인.
        MemberDTO memberDTO = memberService.getOneMember("lsj","1234");
        log.info("memberDTO: "+ memberDTO);
    }

    @Test
    public  void updateUUID() throws Exception {
        memberService.updateUUID("lsj","testuuid3");
        // 디비 콘솔에서 확인하기.
    }

    @Test
    public  void selectUUID() throws Exception {
        MemberDTO memberDTO = memberService.selectUUID("testuuid3");
        log.info("memberDTO : " + memberDTO);
        // 디비 콘솔에서 확인하기.
    }

    @Test
    public void insertMember() throws Exception {
        MemberDTO memberDTO = MemberDTO.builder()
                .mid("lsj05232")
                .mpw("1234")
                .mname("이수진05232")
                .build();

        memberService.insertMember(memberDTO);
    }


}


