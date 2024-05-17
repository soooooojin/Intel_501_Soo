package com.busanit501.busanit501_soo.Menu.dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;

public enum ConnectionUtil {
    INSTANCE;
    //HikariCP 에서 사용했던, 설정을 그대로  재사용
    //현재 독립 클래스처럼 이용할 예정

    //다른 인스턴스를 가져와서 이용하는 방법
    //주입, 포함

    private HikariDataSource dataSource;
    //생성자
    ConnectionUtil(){
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

        //선언만 한 인스턴스를 여기서 초가화 하기
        dataSource = new HikariDataSource(config);

    }
    //Connection 리턴해주는 메서드,디비 연결해주는 도구.
    public Connection getConnection() throws Exception {
        return dataSource.getConnection();
    }
    //사용법
    //Connection con = ConnectionUtil.INSTANCE.getConnection(), 이런식으로 사용함.
}
