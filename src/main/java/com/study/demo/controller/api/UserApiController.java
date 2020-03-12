package com.study.demo.controller.api;

import com.study.demo.ifs.CrudInterface;
import com.study.demo.model.network.Header;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserApiController implements CrudInterface {


    @Override
    @PostMapping("") // api/user
    public Header create() {
        return null;
    }

    @Override
    @GetMapping("{id}") // api/user/{id}
    public Header read(@PathVariable(name = "id") Long id) {
        return null;
    }

    @Override
    @PutMapping("")
    public Header update() {
        return null;
    }

    @Override
    @DeleteMapping("{id}") // api/user/{id}
    public Header delete(Long id) {
        return null;
    }
}
