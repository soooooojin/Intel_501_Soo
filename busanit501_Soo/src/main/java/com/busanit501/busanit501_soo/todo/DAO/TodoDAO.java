package com.busanit501.busanit501_soo.todo.DAO;

import com.busanit501.busanit501_soo.todo.domain.TodoVo;
import com.busanit501.busanit501_soo.todo.dto.TodoDTO;
import lombok.Cleanup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TodoDAO {

    //조희 select
    public List<TodoVo> selectAll() throws Exception {
        //예외처리 여부를 throws 진행하기.
        //디비 연결하는 순서
        //1) 연결 하는 도구 Connection 타입의 인스턴스 필요
        //2) SQL 전달하는 도구 : PreparedStatement타입의 인스턴스 필요
        //3) select 힐때는 조회결과를 받기 위한 ResultSet 타입의 인스터스 필요
        // 작업 후 , 반납 -> @Cleanup 사용할 예정
        String sql = "select * from  tbl_todo";
        //1)
        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        @Cleanup ResultSet rs = pstmt.executeQuery();
        //디비에서 조회한 데이터 내용들을 담을 임시 List가 필요함. 여기에 담을 예정
        List<TodoVo> samples = new ArrayList<TodoVo>();

        while (rs.next()) {
            // 기존에는 , set 를 이용해서 담는 방법
//      // 임시 TodoVo에 담기, -> 다시 임시 목록에 담기.
//      // 방법1
//      TodoVo todoVo = new TodoVo();
//      // resultSet.getLong("tno"), 디비에서 조회한 내용.
//      todoVo.setTno(resultSet.getLong("tno"));
//      todoVo.setTitle(resultSet.getString("title"));
//      todoVo.setDueDate(resultSet.getDate("dueDate").toLocalDate());
//      todoVo.setFinished(resultSet.getBoolean("finished"));
//      // 리스트에 담기.
//      samples.add(todoVo);
            // builder 패턴으로 담는 방법.
            // 방법2
            TodoVo todoVoBuilder = TodoVo.builder()
                    .tno(rs.getLong("tno"))
                    .title(rs.getString("title"))
                    .dueDate(rs.getDate("dueDate").toLocalDate())
                    .finished(rs.getBoolean("finished"))
                    .build();
            // 리스트에 담기.
            samples.add(todoVoBuilder);

        }
        //임시 반환값
        return samples;
    }

    // 하나의 todo 조회하기 . 상세보기
    public TodoVo selectOne(Long tno) throws Exception {
        String sql = "select * from  tbl_todo where tno = ?";
        //1)
        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        //화면에서 특정 게시글 선택하면,
        //get : URL : http://localhost:8080/todo/read?tno=3
        pstmt.setLong(1, tno);
        @Cleanup ResultSet rs = pstmt.executeQuery();
        //값이 하나여서 반목문이 필요없음
        rs.next();
        //임시로 담을 인스턴스 .Builder 패턴 이용해보기

        TodoVo todoVo = TodoVo.builder()
                .tno(rs.getLong("tno"))
                .title(rs.getString("title"))
                .dueDate(rs.getDate("DueDate").toLocalDate())
                .finished(rs.getBoolean("finished"))
                .build();
        //임시 인스턴스
        return new TodoVo();

    }



    //쓰기 insert



    //수정 update

    //삭제 delete


    public String getTime2() throws Exception{
        //자원 반납 자동으로 처리해보기, 롬복의 @cleanup 가능 이용하기.
        //사용법 : @Cleanup, 자동으로 반납하고 싶은 메서드에 붙이기.
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = connection.prepareStatement("select now()");
        @Cleanup ResultSet rs = pstmt.executeQuery();
        rs.next();
        String now = rs.getString(1);
            return now;
            
    }


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
