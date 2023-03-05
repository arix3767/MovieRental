package com.github.arix3767.user.controller;

import com.github.arix3767.user.converters.UserDtoToUserConverter;
import com.github.arix3767.user.dto.CustomerDto;
import com.github.arix3767.user.dto.UserDto;
import com.github.arix3767.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto) {
        UserDto user = userService.addUser(userDto);
    return ResponseEntity.ok(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> editUser(@PathVariable long id, @RequestBody UserDto userDto) {
        String message = userService.editUser(id, userDto);
        return ResponseEntity.ok(message);
    }
}
