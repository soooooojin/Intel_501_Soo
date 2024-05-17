package com.busanit501.busanit501_soo.todo.domain;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
//@RequiredArgsConstructor
@AllArgsConstructor
public class TodoVo {
    private Long tno;
    private String title;
    private LocalDate dueDate;
    private boolean finished;
}
