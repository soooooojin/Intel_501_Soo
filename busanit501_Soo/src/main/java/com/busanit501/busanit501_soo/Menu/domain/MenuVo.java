package com.busanit501.busanit501_soo.Menu.domain;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@Data
@ToString
@NoArgsConstructor
//@RequiredArgsConstructor
@AllArgsConstructor
public class MenuVo {
    private Long menuNo;
    private String menuTitle;
    private LocalDate regDate;
}
//소문자 대문자 잘 구분하기!!!!!!!!!!!!!!!!!!!!!!!!!!!!
