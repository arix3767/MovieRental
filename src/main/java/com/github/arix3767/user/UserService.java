package com.github.arix3767.user;

import com.github.arix3767.exception.CustomerAlreadyExistsException;
import com.github.arix3767.exception.InvalidEmailException;
import com.github.arix3767.exception.MissingDataException;
import com.github.arix3767.exception.UserNotFoundException;
import com.github.arix3767.user.dto.AddUserRequest;
import com.github.arix3767.user.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserDto addUser(AddUserRequest addUserRequest) {
        if (addUserRequest.getEmail() == null || addUserRequest.getPassword() == null) {
            throw new MissingDataException();
        }
        if (addUserRequest.getEmail().isBlank() || addUserRequest.getPassword().isBlank()) {
            throw new MissingDataException();
        }
        if (userRepository.existByEmail(addUserRequest.getEmail())) {
            throw new CustomerAlreadyExistsException();
        }
        User user = UserDtoToUserConverter.INSTANCE.convert(addUserRequest);
        User savedUser = userRepository.save(user);
        return UserToUserDtoConverter.INSTANCE.convert(savedUser);
    }

    public UserDto editUser(AddUserRequest addUserRequest) {
        if (addUserRequest.getEmail() == null || addUserRequest.getEmail().isBlank()) {
            throw new InvalidEmailException();
        }
        User user = userRepository.findByEmail(addUserRequest.getEmail())
                .orElseThrow(UserNotFoundException::new)
                .toBuilder()
                .email(addUserRequest.getEmail())
                .password(addUserRequest.getPassword())
                .build();
        User savedUser = userRepository.save(user);
        return UserToUserDtoConverter.INSTANCE.convert(savedUser);
    }

}
