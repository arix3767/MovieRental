package com.github.arix3767.user.controller;

import com.github.arix3767.user.UserService;
import com.github.arix3767.user.dto.AddUserRequest;
import com.github.arix3767.user.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
class UserController {

    private final UserService userService;

    @PostMapping
    ResponseEntity<UserDto> addUser(@RequestBody AddUserRequest addUserRequest) {
        UserDto user = userService.addUser(addUserRequest);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{id}")
    ResponseEntity<String> editUser(@RequestBody AddUserRequest addUserRequest) {
        String message = userService.editUser(addUserRequest);
        return ResponseEntity.ok(message);
    }
}
