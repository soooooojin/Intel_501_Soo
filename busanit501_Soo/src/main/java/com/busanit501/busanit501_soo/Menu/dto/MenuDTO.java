package com.busanit501.busanit501_soo.Menu.dto;

import java.time.LocalDate;

public class MenuDTO {
  // 인스턴스 멤버.
  private Long menuNo;
  private String menuTitle;
  private LocalDate regDate;

  public Long getMenuNo() {
    return menuNo;
  }

  public void setMenuNo(Long menuNo) {
    this.menuNo = menuNo;
  }

  public String getMenuTitle() {
    return menuTitle;
  }

  public void setMenuTitle(String menuTitle) {
    this.menuTitle = menuTitle;
  }

  public LocalDate getRegDate() {
    return regDate;
  }

  public void setRegDate(LocalDate regDate) {
    this.regDate = regDate;
  }

  @Override
  public String toString() {
    return "MenuDTO{" +
            "menuNo=" + menuNo +
            ", menuTitle='" + menuTitle + '\'' +
            ", regDate=" + regDate +
            '}';
  }
}







