package com.busanit501.busanit501_soo.connectDb;

import com.busanit501.busanit501_soo.todo.DAO.TodoDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    public void getTimeTest() {
        todoDAO = new TodoDAO();
        String time = todoDAO.getTime();
        System.out.println("time : " + time);
    }
}
