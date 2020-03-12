package com.study.demo.model.entity;

import jdk.jfr.Enabled;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Builder
@Accessors(chain = true)
@ToString(exclude = {"orderDetailList", "partner"})
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    private String name;

    private String title;

    private String content;

    private Integer price;

    private String brandName;

    private LocalDateTime registeredAt;

    private LocalDateTime unregisteredAt;

    @CreatedDate
    private LocalDateTime createdAt;

    @CreatedBy
    private String createdBy;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @LastModifiedBy
    private String updatedBy;

    // Item N : 1 Partner
    @ManyToOne
    private Partner partner;

    // LAZY = 지연로딩 , EAGER = 즉시 로딩

    // LAZY -> SELECT * FROM item where id = ?

    // EAGER -> JOIN ( 연관관계가 설정된 모든 테이블에 대해서 다 join) -> 데이터가 크면 성능저하가 생길 수 있음 (1 : 1에 보통 쓰임)
    // item_id = order_detail.item_id
    // user_id = order_detail.user_id
    // whrer item.id = ?

    // Item 1 : N OrderDetail
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item") // 이 item은 OrderDeatil의 item
    private List<OrderDetail> orderDetailList;
}
