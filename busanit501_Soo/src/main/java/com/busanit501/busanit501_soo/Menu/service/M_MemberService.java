package com.busanit501.busanit501_soo.Menu.service;

import com.busanit501.busanit501_soo.Menu.dao.M_MemberDAO;
import com.busanit501.busanit501_soo.Menu.domain.M_MemberVO;
import com.busanit501.busanit501_soo.Menu.dto.M_MemberDTO;
import com.busanit501.busanit501_soo.todo.DAO.MemberDAO;
import com.busanit501.busanit501_soo.todo.domain.MemberVO;
import com.busanit501.busanit501_soo.todo.dto.MemberDTO;
import com.busanit501.busanit501_soo.todo.util.MapperUtil;
import org.modelmapper.ModelMapper;

public enum M_MemberService {
    INSTANCE;

    private M_MemberDAO M_memberDAO;
    private ModelMapper modelMapper;


    //MemberService, 생성자 만들기.
   M_MemberService() {
        M_memberDAO = new M_MemberDAO();
        // 기본 생성자 호출해서, 할당하기. 0x100
        modelMapper = MapperUtil.INSTANCE.get();
    }

    // 하나 조회
    public M_MemberDTO getOneMember(String id, String pw) throws Exception {
        M_MemberVO sample = M_memberDAO.getWithPassword(id, pw);
//      log.info("todoService , 확인, sample : " + sample);
        M_MemberDTO M_memberDTO = modelMapper.map(sample, M_MemberDTO.class);
        return M_memberDTO;
    }
    // 회원가입
    public void insertMember(M_MemberDTO M_memberDTO) throws Exception {
        M_MemberVO M_memberVO = modelMapper.map(M_memberDTO,M_MemberVO.class);
        M_memberDAO.insertMember(M_memberVO);
    }


    public void updateUUID(String id, String uuid) throws Exception {
        M_memberDAO.updateUUID(id, uuid);
    }

    public M_MemberDTO selectUUID(String uuid) throws Exception {
        M_MemberVO M_memberVO = M_memberDAO.selectUUID(uuid);

        M_MemberDTO M_memberDTO = modelMapper.map(M_memberVO, M_MemberDTO.class);

        return M_memberDTO;

    }

}
