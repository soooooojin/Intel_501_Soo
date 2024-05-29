package com.busanit501.busanit501_soo.todo.service;


import com.busanit501.busanit501_soo.Menu.util.MapperUtil;
import com.busanit501.busanit501_soo.todo.DAO.MemberDAO;
import com.busanit501.busanit501_soo.todo.domain.MemberVO;
import com.busanit501.busanit501_soo.todo.dto.MemberDTO;
import org.modelmapper.ModelMapper;

public enum MemberService {
    INSTANCE;

    private MemberDAO memberDAO;
    private ModelMapper modelMapper;


    //MemberService, 생성자 만들기.
   MemberService() {
        memberDAO = new MemberDAO();
        // 기본 생성자 호출해서, 할당하기. 0x100
        modelMapper = MapperUtil.INSTANCE.get();
    }

    // 하나 조회
    public MemberDTO getOneMember(String mid, String mpw) throws Exception {
        MemberVO sample = memberDAO.getWithPasswordMember(mid, mpw);
//      log.info("todoService , 확인, sample : " + sample);
        MemberDTO memberDTO = modelMapper.map(sample,MemberDTO.class);
        return memberDTO;
    }

    public void insertMember(MemberDTO memberDTO) throws Exception {
       MemberVO memberVO = modelMapper.map(memberDTO,MemberVO.class);
       memberDAO.insertMember(memberVO);
    }


    public void updateUUID(String mid, String uuid) throws Exception {
        memberDAO.updateUUID(mid, uuid);
    }

    public MemberDTO selectUUID(String uuid) throws Exception {
        MemberVO memberVO = memberDAO.selectUUID(uuid);
        MemberDTO memberDTO = modelMapper.map(memberVO, MemberDTO.class);
        return memberDTO;

    }

}
