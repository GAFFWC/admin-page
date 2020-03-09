package com.study.demo.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity // = Table과 동일
//@Table(name = "user") -> DB Table의 이름이 클래스이름과 동일하다면 써주지 않아도 Mapping 됨.
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String account;

    private String email;

    private String phoneNumber; // 자바에서는 camelcase, DB에서는 snakecase

    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;

    //1 : N
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<OrderDetail> orderDetailList;

}
