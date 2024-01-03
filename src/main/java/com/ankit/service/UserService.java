package com.ankit.service;

import com.ankit.dao.UserRepository;
import com.ankit.dto.ResponseDto;
import com.ankit.dto.RegisterUserRequestDTO;
import com.ankit.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public UserEntity saveUser(RegisterUserRequestDTO userRequest) throws Exception{
        UserEntity entity = new UserEntity();
        entity.setFirstName(userRequest.getFirstName());
        entity.setLastName(userRequest.getFirstName());
        entity.setEmail(userRequest.getEmail());
        entity.setDob(LocalDate.parse(userRequest.getDob()));
        entity.setGender(userRequest.getGender().charAt(0));
        entity.setCreatedDate(LocalDateTime.now());
        entity.setIsActive(false);
        entity = userRepository.save(entity);
        return entity;
    }
}
