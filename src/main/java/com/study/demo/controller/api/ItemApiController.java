package com.study.demo.controller.api;

import com.study.demo.controller.CrudController;
import com.study.demo.ifs.CrudInterface;
import com.study.demo.model.network.Header;
import com.study.demo.model.network.request.ItemApiRequest;
import com.study.demo.model.network.response.ItemApiResponse;
import com.study.demo.service.ItemApiLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("api/item")
public class ItemApiController extends CrudController<ItemApiRequest, ItemApiResponse> {

    @Autowired
    private ItemApiLogicService itemApiLogicService;

    @PostConstruct
    public void init(){
        this.baseService = itemApiLogicService;
    }

}
