package com.github.arix3767.user.service;

import com.github.arix3767.exception.CustomerAlreadyExistsException;
import com.github.arix3767.exception.MissingDataException;
import com.github.arix3767.user.converters.UserDtoToUserConverter;
import com.github.arix3767.user.converters.UserToUserDtoConverter;
import com.github.arix3767.user.dto.UserDto;
import com.github.arix3767.user.entity.User;
import com.github.arix3767.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public UserDto addUser(UserDto userDto) {
        if (userDto.getEmail() == null || userDto.getPassword() == null) {
            throw new MissingDataException();
        }
        if (userRepository.existByEmail(userDto.getEmail())) {
            throw new CustomerAlreadyExistsException();
        }
        User user = UserDtoToUserConverter.INSTANCE.convert(userDto);
        userRepository.save(user);
        return UserToUserDtoConverter.INSTANCE.convert(user);
    }

}
