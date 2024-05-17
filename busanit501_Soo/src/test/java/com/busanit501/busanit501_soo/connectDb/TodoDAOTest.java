package com.busanit501.busanit501_soo.connectDb;

import com.busanit501.busanit501_soo.todo.DAO.TodoDAO;
import com.busanit501.busanit501_soo.todo.domain.TodoVo;
import com.busanit501.busanit501_soo.todo.todo.domain.TodoVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TodoDAOTest {

    //디비 연결하고 , 기능 테스트
    //다른 클래스의 인스턴스가 필요해요.
    //사용 방법? > 주입 = 포함하기
    //선언만 했음 할당X 여기 null(집주소가 없네. 0x100)
    private TodoDAO todoDAO;
    //각 단위 데스트가 실행되기 전에 먼저 실행되는 어노테이션,
    //todoDAO 할당 함.
    @BeforeEach
    public void ready() {
        todoDAO = new TodoDAO();
    }

    @Test
    public void getTimeTest() throws Exception {

        // todoDAO.getTime() 이기능 확인. 단위테스트.
        // String time = todoDAO.getTime();
        String time = todoDAO.getTime2();
        System.out.println("time : " + time);
    }

    @Test
    public void getSelectAll() throws Exception {
        List<TodoVo> samples = todoDAO.selectAll();
        // 기본 출력이고, 전체 출력
        System.out.println("samples : " + samples);
        // 향상된 for, 목록에서 요소를 하나씩 뽑아서 출력함.
        // samples 목록에서, 하나 요소를 꺼내서 vo 에 담고, 그리고 개별 요소 출력하기.
        samples.forEach(vo ->System.out.println("각각 출력해보기 : " + vo) );
    }
}
