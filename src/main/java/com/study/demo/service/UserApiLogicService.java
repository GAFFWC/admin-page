package com.study.demo.service;

import com.study.demo.ifs.CrudInterface;
import com.study.demo.model.entity.User;
import com.study.demo.model.enumclass.UserStatus;
import com.study.demo.model.network.Header;
import com.study.demo.model.network.request.UserApiRequest;
import com.study.demo.model.network.response.UserApiResponse;
import com.study.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserApiLogicService implements CrudInterface<UserApiRequest, UserApiResponse> {

    @Autowired
    private UserRepository userRepository;

    // 1. request data
    // 2. user 생성
    // 3. 생성된 데이터 -> user response return

    @Override
    public Header<UserApiResponse> create(Header<UserApiRequest> request) {

        // 1. Requested data
        UserApiRequest userApiRequest = request.getData();


        // 2. User 생성

        User user = User.builder()
                .account(userApiRequest.getAccount())
                .password(userApiRequest.getPassword())
                .status(UserStatus.REGISTERED) // enum이 필요한 부분
                .phoneNumber(userApiRequest.getPhoneNumber())
                .email(userApiRequest.getEmail())
                .registeredAt(LocalDateTime.now())
                .build();

        User newUser = userRepository.save(user);

        // 3. 생성된 데이터 -> userApiResponse return


        return response(newUser);
    }

    @Override
    public Header<UserApiResponse> read(Long id) {

        // id -> repository getOne, getById
        // user -> userApiResponse return
        return userRepository.findById(id).map(user -> response(user)) // user가 있다면 response
                .orElseGet( // 없다면,
                        ()->Header.ERROR("데이터 없음") // throw error
                );
    }

    @Override
    public Header<UserApiResponse> update(Header<UserApiRequest> request) {

        // 1. data
        UserApiRequest userApiRequest = request.getData();

        // 2. id -> user 데이터를 찾고
        Optional<User> optional = userRepository.findById(userApiRequest.getId());

        return optional.map(user ->{
            // 3. data -> update
            // id
            user
                    .setAccount(userApiRequest.getAccount())
                    .setPassword(userApiRequest.getPassword())
                    .setStatus(userApiRequest.getStatus())
                    .setPhoneNumber(userApiRequest.getPhoneNumber())
                    .setEmail(userApiRequest.getEmail())
                    .setRegisteredAt(userApiRequest.getRegisteredAt())
                    .setUnregisteredAt(userApiRequest.getUnregisteredAt());

            return user;

        })
                .map(user -> userRepository.save(user)) // update -> newUser
                .map(updatedUser -> response(updatedUser)) // userApiResponse
                .orElseGet(()->Header.ERROR("데이터없음"));

    }

    @Override
    public Header delete(Long id) {
        // id -> repository -> user
        Optional<User> optional = userRepository.findById(id);


        // repository -> delete
        return optional.map(user ->{
            userRepository.delete(user);

            return Header.OK();
        }).orElseGet(()->Header.ERROR("데이터 없음"));
        // response return
    }

    private Header<UserApiResponse> response(User user){
        // user -> userApiResponse

        UserApiResponse userApiResponse = UserApiResponse.builder()
                .id(user.getId())
                .account(user.getAccount())
                .password(user.getPassword()) // todo 암호화, 길이
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .status(user.getStatus())
                .registeredAt(user.getRegisteredAt())
                .unregisteredAt(user.getUnregisteredAt())
                .build();

        // Header + data return
        return Header.OK(userApiResponse);
    }
}
