package com.github.arix3767.user.controller;

import com.github.arix3767.result.ApiResult;
import com.github.arix3767.result.ResultCode;
import com.github.arix3767.user.UserService;
import com.github.arix3767.user.dto.AddUserRequestDto;
import com.github.arix3767.user.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * manage all user related Http trafic
 * based on service response
 * returns appropriate Http status
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
class UserController {

    private final UserService userService;

    @PostMapping
    ResponseEntity<AddUserRequestDto> addUser(@RequestBody AddUserRequestDto addUserRequestDto) {
        ApiResult<UserDto> result = userService.addUser(addUserRequestDto);
        if (result.getResultCode() == ResultCode.USER_ALREADY_EXISTS) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        if (result.getResultCode() == ResultCode.MISSING_DATA) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    ResponseEntity<String> editUser(@RequestBody AddUserRequestDto addUserRequestDto) {
        ApiResult<UserDto> result = userService.editUser(addUserRequestDto);
        ResultCode resultCode = result.getResultCode();
        if (resultCode == ResultCode.MISSING_DATA ||
                resultCode == ResultCode.USER_NOT_FOUND) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
