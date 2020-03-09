package com.study.demo.repository;

import com.study.demo.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // 이름을 보고 select문임을 인지해줌
    // select * from user where account = ? << test03, test04
    Optional<User> findByAccount(String account);

    Optional<User> findByEmail(String email);

    //select * from user where account = ? and email = ?
    Optional<User> findByAccountAndEmail(String account, String email); // 파라미터가 순서대로 column에 매칭됨
}
