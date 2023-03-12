package com.github.arix3767.user.controller;

import com.github.arix3767.result.ApiResult;
import com.github.arix3767.user.UserService;
import com.github.arix3767.user.dto.AddUserRequestDto;
import com.github.arix3767.user.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
class UserController {

    private final UserService userService;

    /*
    dla metod w serwisie zwrocic odpowiedni komunikat HTTP
    OK - 201
    MISSING_DATA - 400
    ALREADY_EXISTS - 409
     */
    @PostMapping
    ResponseEntity<AddUserRequestDto> addUser(@RequestBody AddUserRequestDto addUserRequestDto) {
        ApiResult<UserDto> result = userService.addUser(addUserRequestDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    ResponseEntity<String> editUser(@RequestBody AddUserRequestDto addUserRequestDto) {
        ApiResult<UserDto> result = userService.editUser(addUserRequestDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
