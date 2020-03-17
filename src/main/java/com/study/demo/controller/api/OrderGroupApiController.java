package com.study.demo.controller.api;

import com.study.demo.controller.CrudController;
import com.study.demo.ifs.CrudInterface;
import com.study.demo.model.network.Header;
import com.study.demo.model.network.request.OrderGroupApiRequest;
import com.study.demo.model.network.response.OrderGroupApiResponse;
import com.study.demo.service.OrderGroupApiLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("api/orderGroup")
public class OrderGroupApiController extends CrudController<OrderGroupApiRequest, OrderGroupApiResponse> {

    @Autowired
    private OrderGroupApiLogicService orderGroupApiLogicService;

    @PostConstruct
    public void init(){
        this.baseService = orderGroupApiLogicService;
    }
}
