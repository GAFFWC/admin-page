package com.study.demo.model.entity;

import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer price;

    private String content;

    // 1 : N

    // LAZY = 지연로딩 , EAGER = 즉시 로딩

    // LAZY -> SELECT * FROM item where id = ?

    // EAGER -> JOIN ( 연관관계가 설정된 모든 테이블에 대해서 다 join) -> 데이터가 크면 성능저하가 생길 수 있음 (1 : 1에 보통 쓰임)
    // item_id = order_detail.item_id
    // user_id = order_detail.user_id
    // whrer item.id = ?

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
    private List<OrderDetail> orderDetailList;
}
