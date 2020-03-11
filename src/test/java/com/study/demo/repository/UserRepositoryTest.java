package com.study.demo.repository;

import com.study.demo.DemoApplication;
import com.study.demo.DemoApplicationTests;
import com.study.demo.model.entity.Item;
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
        /*
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
        */

        String account = "Test01";
        String password = "Test01";
        String status = "REGISTERED";
        String email = "Test01@gmail.com";
        String phoneNumber = "010-1111-2222";
        LocalDateTime registeredAt = LocalDateTime.now();
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer";

        User user = new User();
        user.setAccount(account);
        user.setPassword(password);
        user.setStatus(status);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setRegisteredAt(registeredAt);
        user.setCreatedAt(createdAt);
        user.setCreatedBy(createdBy);

        User newUser = userRepository.save(user);

        Assertions.assertNotNull(newUser);
    }

    @Test
    @Transactional
    public void read(){

        // select * from user where id = 1L
        /*Optional<User> user = userRepository.findByAccount("TestUser02");

        user.ifPresent(selectedUser ->{

            selectedUser.getOrderDetailList().stream().forEach(detail ->{
                Item item = detail.getItem();
                System.out.println(detail.getItem());
            });
        });*/

        Optional<User> user =  userRepository.findFirstByPhoneNumberOrderByIdDesc("010-1111-2222");
        Assertions.assertNotNull(user);
        user.ifPresent(u ->{
            u.getOrderGroup().stream().forEach(orderGroup -> {
                System.out.println("--------------------장바구니--------------------");

                System.out.println("수량 : " + orderGroup.getTotalQuantity());
                System.out.println("총액 : " + orderGroup.getTotalPrice());
                System.out.println("수령지 : " + orderGroup.getRevAddress());
                System.out.println("수령인 : " + orderGroup.getRevName());

                System.out.println("--------------------주문상세--------------------");

                orderGroup.getOrderDetailList().forEach(orderDetail -> {
                    System.out.println("제공사 :"+orderDetail.getItem().getPartner().getName());
                    System.out.println("카테고리 :"+orderDetail.getItem().getPartner().getCategory().getTitle());
                    System.out.println("주문 상품 : "+orderDetail.getItem().getName());
                    System.out.println("고객센터 : "+orderDetail.getItem().getPartner().getCallCenter());
                    System.out.println("주문 상태 : "+orderDetail.getStatus());
                    System.out.println("도착 예정일 : "+orderDetail.getArrivalDate());


                });

            });
        });

    }

    @Test
    public void update(){
        /*
        Optional<User> user = userRepository.findById(2L);

        user.ifPresent(selectedUser ->{
            //selectedUser.setId(3L); // 이렇게하면 id가 3인 user의 정보가 바뀜
            selectedUser.setAccount("PPPP");
            selectedUser.setUpdatedAt(LocalDateTime.now());
            selectedUser.setUpdatedBy("update method()");

            userRepository.save(selectedUser);
        });
        */
    }

    @Test
    @Transactional // method들은 모두 실행되지만 데이터 베이스에서 실제로 삭제가 이루어지진 않음(다시 rollback)
    public void delete(){
        /*
        Optional<User> user = userRepository.findById(2L);

        Assertions.assertTrue(user.isPresent()); // true


        user.ifPresent((selectedUser ->{
            userRepository.delete(selectedUser);
        }));

        Optional<User> deletedUser = userRepository.findById(2L);

        Assertions.assertFalse(deletedUser.isPresent());*/
    }
}
