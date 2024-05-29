package com.busanit501.busanit501_soo.todo.domain;

import lombok.*;

@Builder
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class MemberVO {
//VO는 임시 저장하는 박스
    private String mid;
    private String mpw;
    private String mname;
    private String uuid;
    private boolean autoLogined;

}
