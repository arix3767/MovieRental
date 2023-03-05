package com.github.arix3767.user.controller;

import com.github.arix3767.user.UserService;
import com.github.arix3767.user.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
class UserController {

    private final UserService userService;

    @PostMapping
    ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto) {
        UserDto user = userService.addUser(userDto);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{id}")
    ResponseEntity<String> editUser(@PathVariable long id, @RequestBody UserDto userDto) {
        String message = userService.editUser(id, userDto);
        return ResponseEntity.ok(message);
    }
}
