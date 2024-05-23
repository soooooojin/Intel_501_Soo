package com.busanit501.busanit501_soo.Menu.domain;

import lombok.*;

@Builder
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class M_MemberVO {

    private String id;
    private String pw;
    private String name;
    private String uuid;


}
