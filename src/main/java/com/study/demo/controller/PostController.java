package com.study.demo.controller;

import com.study.demo.model.SearchParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api") // class에 대한 mapping 이름이 겹치는건 괜찮음 -> method에 대해 겹치는건 x
public class PostController {

    // HTML <Form>
    // ajax 검색 등에서 Post 발생
    // http post body -> data
    // json, xml, multipart-form / text-plain

    @PostMapping(value = "/postMethod")
    public SearchParam postMethod(@RequestBody SearchParam searchParam){

        return searchParam;
    }

    @PutMapping
    public void put()
    {

    }

    @PatchMapping
    public void patch(){

    }

}
