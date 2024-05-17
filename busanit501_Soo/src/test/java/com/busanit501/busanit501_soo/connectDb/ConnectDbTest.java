package com.busanit501.busanit501_soo.connectDb;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import com.busanit501.busanit501_soo.todo.domain.TodoVo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDate;

public class ConnectDbTest {

    @Test
    public void testHikariCP() throws Exception {
        //디비에 연결하는 설정 표현 방법이 조금 다름
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("org.mariadb.jdbc.Driver");
        config.setJdbcUrl("jdbc:mariadb://localhost:3306/webdb");
        config.setUsername("webuser");
        config.setPassword("webuser");
        //
        //옵션
        //기본값으로 사용하고 나중에 배포시 지비 서버만 단독으로 사용할때
        //그때 메모리양을 정함. 참고로, 전체 메모리의 70~80%, 디비서버에 모두 할당.

        //sql전달시 PreparedStatement 기법 쓰겠다.
        //동적으로 sql문을 전달하겠다. -> 와일드카드
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        //연결확인 및 사용법
        HikariDataSource dataSource = new HikariDataSource(config);
        //디비에 연결하기 위한 준비물을 포함하고 있다.
        Connection conn = dataSource.getConnection();

        System.out.println(conn);

        conn.close();

    }

    @Test
    public void test2() {
        //원래 우리가 인스ㅌ너스 생성 방법
        //TodoVo todo = new TodoVo();
        TodoVo todo = TodoVo.builder()
                .tno(100L)
                .title("제목100")
                .dueDate(LocalDate.now())
                .build();
        System.out.println(todo);

    }

    @Test
    public void test() {
        int v1 = 100;
        int v2 = 100;
        //단순 비교 확인
        Assertions.assertEquals(v1, v2);
    }
    @Test
    public void connectDbTest() throws Exception {
        // 예외를 처리하는 방법2가지,
        // 1) try catch finally 구문 이용.
        // 2) throws 를 키워드를 이용해서, 해당 예외를 떠넘기기.
        // 3) 언제 예외 처리를 하는냐? a) 파일 입출력 b) 네트워크 이용해서 데이터 전달시.

        //jdbc 드라이버 로드
        Class.forName("org.mariadb.jdbc.Driver");

        //커넥션 연결 인스턴스 필요.
        Connection conn = DriverManager.getConnection(
                "jdbc:mariadb://localhost:3306/webdb",
                "webuser",
                "webuser"
        );
        //단순 conn 인스턴스 존재 유무로, 드라이버 설치 유무 확인.
        Assertions.assertNotNull(conn);

        //sql문
    }

}


