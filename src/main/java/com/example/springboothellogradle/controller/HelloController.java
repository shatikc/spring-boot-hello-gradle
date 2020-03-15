package com.example.springboothellogradle.controller;

import com.example.springboothellogradle.dto.UserDtoModel;
import com.example.springboothellogradle.dto.UserResponseDTO;
import com.example.springboothellogradle.dto.mapstruct.EntityMapper;
import com.example.springboothellogradle.model.User;
import com.example.springboothellogradle.service.AddUserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api")
@RequiredArgsConstructor
@Slf4j
public class HelloController {

    @NonNull
    private AddUserService addUserService;

    private EntityMapper MAPPER = Mappers.getMapper(EntityMapper.class);

    @PostMapping("addUser")
    public ResponseEntity<UserResponseDTO> addDataToDataBase(@RequestBody UserDtoModel userDtoModel) {
        UserResponseDTO response = new UserResponseDTO();
        if (userDtoModel == null) {
            response.setMessage("Data was is empty!");
            return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
        }
        User result = addUserService.addNewUser(MAPPER.toUser(userDtoModel));
        response = MAPPER.toUserResponseDTO(result);
        String message = "Your data was successfully added!";
        response.setMessage(message);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
