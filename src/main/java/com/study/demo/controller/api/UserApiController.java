package com.study.demo.controller.api;

import com.study.demo.ifs.CrudInterface;
import com.study.demo.model.network.Header;
import com.study.demo.model.network.request.UserApiRequest;
import com.study.demo.model.network.response.UserApiResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserApiController implements CrudInterface<UserApiRequest, UserApiResponse> {


    @Override
    @PostMapping("") // api/user
    public Header<UserApiResponse> create(@RequestBody UserApiRequest userApiRequest) {
        return null;
    }

    @Override
    @GetMapping("{id}") // api/user/{id}
    public Header<UserApiResponse> read(@PathVariable(name = "id") Long id) {
        return null;
    }

    @Override
    @PutMapping("")
    public Header<UserApiResponse> update(@RequestBody UserApiRequest userApiRequest) {
        return null;
    }

    @Override
    @DeleteMapping("{id}") // api/user/{id}
    public Header delete(@PathVariable Long id) {
        return null;
    }
}
