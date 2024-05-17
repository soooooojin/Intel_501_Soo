package com.busanit501.busanit501_soo.todo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TodoDAO {
    //데이터베이스 직접적인 비지니스 로직 처리하는 기능 만들기
    //샘플
    //현재 시간을 가져오는 기능.
    public String getTime() {
        //hikariCP 이용해서 디비연결하는 도구 Connection 타입의 인스턴스 만들기.
        //사용법
        //Conection conn = ConnectionUtil.INSTANCE.getConnection();
        //디비에 접근하려면 반드시 예외 처리해야함
        //3가지 방법
        //1) try catch finally 2)throws 3) try resources with (자동 close)
        //결론, 롬북의 @cleanuo , 자동으로 반납함.

        // 예시 try resources with (자동 close)
        String now = null;

        // 디비 연결해서, 시각 가져오는 코드.
        try(Connection connection = ConnectionUtil.INSTANCE.getConnection();
            // sql 전달하는 도구.
            // String sql = "select now()"
            PreparedStatement pstmt = connection.prepareStatement("select now()");
            // 조회한 결과 테이블을 담기위한 임시 테이블
            // 0 행부터 대기중.
            ResultSet rs = pstmt.executeQuery();
        ){
            // 1행 만 있어서, while 문 없음.
            rs.next();
            // 1행의 결과를 가져오기. 문자열
            now = rs.getString(1);
        } catch (Exception exception) {
            exception.printStackTrace();
        } //원래는 finally 구문으로 close 해야하지만,
        // try resource , 자동 close 가 포함되어 있다.
        return now;
    }
}
