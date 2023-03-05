package com.github.arix3767.user;

import com.github.arix3767.enums.Messages;
import com.github.arix3767.exception.CustomerAlreadyExistsException;
import com.github.arix3767.exception.InvalidEmailException;
import com.github.arix3767.exception.MissingDataException;
import com.github.arix3767.exception.UserNotFoundException;
import com.github.arix3767.user.dto.UserDto;
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

    public String editUser(long id, UserDto newUserData) {
        if (newUserData.getEmail() == null) {
            throw new InvalidEmailException();
        }
        User user = userRepository.findById(id)
                .orElseThrow(UserNotFoundException::new)
                .toBuilder()
                .email(newUserData.getEmail())
                .password(newUserData.getPassword())
                .build();
        userRepository.save(user);
        return Messages.USER_EDIT_SUCCESS.getText();
    }

}
