package com.ankit.controller;

import com.ankit.dto.ResponseDto;
import com.ankit.dto.RegisterUserRequestDTO;
import com.ankit.entity.UserEntity;
import com.ankit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @Autowired
    private UserService userService;

    @PostMapping("/api/register")
    public ResponseDto registerUser(@RequestBody RegisterUserRequestDTO requestDTO) {
        UserEntity user = null;
        ResponseDto responseDto = new ResponseDto();
        try {
            user = userService.saveUser(requestDTO);
            responseDto.setStatusCode(200);
            responseDto.setMessage("Success: User is Saved with id:"+user.getId());
        }
        catch (Exception ex) {
            System.err.println(ex.getMessage());
            responseDto.setStatusCode(500);
            responseDto.setMessage(ex.getMessage());
        }
        return responseDto;
    }
}
