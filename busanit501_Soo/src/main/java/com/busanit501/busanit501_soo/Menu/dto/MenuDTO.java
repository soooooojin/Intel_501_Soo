package com.busanit501.busanit501_soo.Menu.dto;

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
public class MenuDTO {
  // 인스턴스 멤버.
  private Long menuNo;
  private String menuTitle;
  private LocalDate regDate;

}







