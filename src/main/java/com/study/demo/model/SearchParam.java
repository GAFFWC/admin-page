package com.study.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class SearchParam {
    // post에서 body를 json으로 하면 account, email, page에 각각 mapping되서 json class로 들어옴

    private String account;
    private String email;
    private int page;
}
