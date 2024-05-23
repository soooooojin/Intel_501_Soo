package com.busanit501.busanit501_soo.Menu.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class M_MemberDTO {

    private String id;
    private String pw;
    private String name;
    private String uuid;
}
