package com.busanit501.busanit501_soo.connectDb;

import com.busanit501.busanit501_soo.Menu.dao.MenuDAO;
import com.busanit501.busanit501_soo.Menu.domain.MenuVo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

public class MenuDAOTest {

    //디비 연결하고 , 기능 테스트
    //다른 클래스의 인스턴스가 필요해요.
    //사용 방법? > 주입 = 포함하기
    //선언만 했음 할당X 여기 null(집주소가 없네. 0x100)
    private MenuDAO menuDAO;
    //각 단위 데스트가 실행되기 전에 먼저 실행되는 어노테이션,
    //todoDAO 할당 함.
    @BeforeEach
    public void ready() {
        menuDAO = new MenuDAO();
    }

//    @Test
//    public void getTimeTest() throws Exception {
//
//        // todoDAO.getTime() 이기능 확인. 단위테스트.
//        // String time = todoDAO.getTime();
//        String time = MenuDAO.getTime2();
//        System.out.println("time : " + time);
//    }

//    @Test
//    public void getSelectAll() throws Exception {
//        List<TodoVo> samples = todoDAO.selectAll();
//        // 기본 출력이고, 전체 출력
//        System.out.println("samples : " + samples);
//        // 향상된 for, 목록에서 요소를 하나씩 뽑아서 출력함.
//        // samples 목록에서, 하나 요소를 꺼내서 vo 에 담고, 그리고 개별 요소 출력하기.
//        samples.forEach(vo ->System.out.println("각각 출력해보기 : " + vo) );
//    }


    @Test
    public void SelectAllTest() throws Exception {
        List<MenuVo> samples = menuDAO.selectAll();

        System.out.println("samples : " + samples);
        samples.forEach(vo ->System.out.println("각각 출력해보기 : " + vo) );

    }

    @Test
    public void getSelectOne2() throws Exception {
        MenuVo menuVo = menuDAO.selectOne(5L);
        // 기본 출력이고, 전체 출력
        System.out.println("menuVo : " + menuVo);
    }


//    @Test
//    public void getSelectOne() throws Exception {
//        TodoVo todoVo = todoDAO.selectOne(5L);
//        // 기본 출력이고, 전체 출력
//        System.out.println("todoVO : " + todoVo);
//
//    }

    //insert
    @Test
    public void insert() throws Exception {
        MenuVo menuVo = MenuVo.builder()
                .menuNo(7L)
                .menuTitle("감자탕")
                .regDate(LocalDate.now())
                .build();

        //DAO에서 만들었던 insert 기능 사용하기
        menuDAO.insert(menuVo);
    }


    //update
    @Test
    public void update() throws Exception {
        MenuVo menuVo = MenuVo.builder()
                .menuNo(7L)
                .menuTitle("칼국수77777")
                .regDate(LocalDate.of(2024,5,20))
                .build();

        //기능 구현
        menuDAO.update(menuVo);
    }

    //delete
    @Test
    public void delete() throws Exception {
        //기능 확인해보기
        menuDAO.delete(4L);
    }

}
