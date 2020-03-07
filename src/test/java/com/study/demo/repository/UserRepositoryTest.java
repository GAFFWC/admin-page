package com.study.demo.repository;

import com.study.demo.DemoApplication;
import com.study.demo.DemoApplicationTests;
import com.study.demo.model.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.AssertionsKt;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

public class UserRepositoryTest extends DemoApplicationTests {
    // Dependency Injection (DI)
    @Autowired
    private UserRepository userRepository;

    @Test
    public void create(){
        // String sql = insert into user (%s, %s, %d) value (account, email, age);
        User user = new User();
        //user.setId(); -> Auto Increment
        user.setAccount("TestUser03");
        user.setEmail("TestUser02@gmail.com");
        user.setPhoneNumber("010-3333-3333");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("admin");

        User newUser = userRepository.save(user);
        System.out.println("newUser : "+newUser);

    }

    @Test
    public void read(){
        Optional<User> user = userRepository.findById(2L);

        user.ifPresent(selectedUser ->{
            System.out.println(("user: "+selectedUser));
            System.out.println("email : "+selectedUser.getEmail());
        });


    }

    @Test
    public void update(){
        Optional<User> user = userRepository.findById(2L);

        user.ifPresent(selectedUser ->{
            //selectedUser.setId(3L); // 이렇게하면 id가 3인 user의 정보가 바뀜
            selectedUser.setAccount("PPPP");
            selectedUser.setUpdatedAt(LocalDateTime.now());
            selectedUser.setUpdatedBy("update method()");

            userRepository.save(selectedUser);
        });
    }

    @Test
    @Transactional // method들은 모두 실행되지만 데이터 베이스에서 실제로 삭제가 이루어지진 않음(다시 rollback)
    public void delete(){
        Optional<User> user = userRepository.findById(2L);

        Assertions.assertTrue(user.isPresent()); // true


        user.ifPresent((selectedUser ->{
            userRepository.delete(selectedUser);
        }));

        Optional<User> deletedUser = userRepository.findById(2L);

        Assertions.assertFalse(deletedUser.isPresent());
    }
}
