package com.busanit501.busanit501_soo.todo.service;

import com.busanit501.busanit501_soo.todo.DAO.TodoDAO;
import com.busanit501.busanit501_soo.todo.domain.TodoVO;
import com.busanit501.busanit501_soo.todo.dto.TodoDTO;
import com.busanit501.busanit501_soo.todo.util.MapperUtil;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public enum TodoService {
  INSTANCE;
    //준비물), 1) TodoDAO ,인스턴슨 필요
    // 2) DTO <-> VO 간에 변환기 필요, MapperUtil
    private TodoDAO todoDAO;
    private ModelMapper modelMapper;

    //TodoService, 생성자 만들기.
    TodoService() {
        todoDAO = new TodoDAO();
        // 기본 생성자 호출해서, 할당하기. 0x100
        modelMapper = MapperUtil.INSTANCE.get();
    }

    //test
    // 쓰기, 오전에 작업한 모델은 TodoVO,
    // 지금 모델 타입 TodoDTO 을 받아서, 작업 하기 위해서, VO로 변환.
    // modelMapper 이용할 예정.
    // 작성한 데이터의 내용을 담을 임시 모델.TodoDTO
    public void register2(TodoDTO todoDTO) throws Exception {
        // DTO -> VO 변환 이 필요함. , 도구 이용법.
        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
        // 수동으로 한다면,
//    TodoVO todoVO1 = TodoVO.builder()
//        .tno(todoDTO.getTno())
//        .title(todoDTO.getTitle())
//        .dueDate(todoDTO.getDueDate())
//        .finished(todoDTO.isFinished())
//        .build();
        System.out.println("todoVO : "+ todoVO);
        // 실제 디비에도 넣기.
        todoDAO.insert(todoVO);
    }
    // 전체 조회


    // 하나 조회

    // 수정

    // 삭제




    public void register(TodoDTO dto) {
        System.out.println("debug register dto 확인중 : " + dto);
    }


    public List<TodoDTO> getList() {
        List<TodoDTO> listSample = IntStream.range(0,10).mapToObj(i -> {
            TodoDTO dto = new TodoDTO();
            dto.setTno((long)i);
            dto.setTitle("Sample Todo Title " + i);
            dto.setDueDate(LocalDate.now());
            return dto;
        }).collect(Collectors.toList());
        return listSample;
    }

    public List<TodoDTO> getList2() {
        List<TodoDTO> sampleList = new ArrayList<>();
        for (int i = 0; i <10; i++) {
            TodoDTO dto = new TodoDTO();
            dto.setTno((long)i);
            dto.setTitle("Sample Todo" + i);
            dto.setDueDate(LocalDate.now());
            sampleList.add(dto);
        }
        return sampleList;
    }

}
