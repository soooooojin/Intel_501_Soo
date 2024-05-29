package com.busanit501.busanit501_soo.todo.dto;


import lombok.*;

@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class MemberDTO {
    private String mid;
    private String mpw;
    private String mname;
    private String uuid;
    private boolean autoLogined;
}