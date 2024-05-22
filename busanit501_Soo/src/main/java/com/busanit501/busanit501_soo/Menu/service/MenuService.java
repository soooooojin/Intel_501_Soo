package com.busanit501.busanit501_soo.Menu.service;

import com.busanit501.busanit501_soo.Menu.dao.MenuDAO;
import com.busanit501.busanit501_soo.Menu.domain.MenuVo;
import com.busanit501.busanit501_soo.Menu.dto.MenuDTO;
import com.busanit501.busanit501_soo.todo.dto.TodoDTO;
import com.busanit501.busanit501_soo.todo.util.MapperUtil;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

import java.awt.*;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Log4j2
public enum MenuService {
  INSTANCE;

  private MenuDAO menuDAO;
  private ModelMapper modelMapper;

  MenuService() {
    menuDAO = new MenuDAO();
    modelMapper = MapperUtil.INSTANCE.get();
  }
//test
  public void register2(MenuDTO menuDTO) throws  Exception{

    MenuVo menuVo = modelMapper.map(menuDTO, MenuVo.class);

    log.info("MenuVo : " + menuVo);
    menuDAO.insert(menuVo);
  }
  //전체 조회
  public List<MenuDTO> listAll() throws Exception{
    List<MenuVo> menuList = menuDAO.selectAll();
    log.info("MenuList : " + menuList);
    List<MenuDTO> sampleDtoList = menuList.stream()
            .map(vo -> modelMapper.map(vo, MenuDTO.class))
            .collect(Collectors.toList());
    return sampleDtoList;
  }

  //하나 조회 / 데이터를 가지고 올 때 필요함.
  public MenuDTO getSelectOne(Long menuNo) throws Exception{
    MenuVo sample = menuDAO.selectOne(menuNo);
//Mapper 해야해서 menuVo로 받고
    //밑에서 DTO를 Mapper한다.
    MenuDTO menuDTO = modelMapper.map(sample, MenuDTO.class);
    return  menuDTO;
  }

  //수정
  public void MenuUpdate(MenuDTO menuDTO) throws Exception{
    MenuVo menuVo = modelMapper.map(menuDTO, MenuVo.class);
    menuDAO.update(menuVo);
  }

  //삭제
  public void MenuDelete(Long menuNo) throws Exception{
    menuDAO.delete(menuNo);
  }

  public void register(MenuDTO menuDTO){
    System.out.println("debug register dto 확인중 : " + menuDTO);
  }

  // 임시 리스트 출력하는 기능.
  public List<MenuDTO> getList() throws Exception {

    List<MenuDTO> listSample = IntStream.range(0,10).mapToObj(i -> {
      MenuDTO dto = new MenuDTO();
      dto.setMenuNo((long)i);
      dto.setMenuTitle("Sample Menu Title " + i);
      dto.setRegDate(LocalDate.now());
      return dto;
    }).collect(Collectors.toList());
    return listSample;
  }



}
