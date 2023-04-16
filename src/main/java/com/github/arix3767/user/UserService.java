package com.github.arix3767.user;

import com.github.arix3767.result.*;
import com.github.arix3767.user.dto.AddUserRequestDto;
import com.github.arix3767.user.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * Service containing business logic for
 * user related functions
 */
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    /**
     * checks requirements for adding user
     * than adds user to database after that
     * returns the result of method
     * @param addUserRequestDto - dto model of user
     * @return ApiResult<UserDto> - result of the method
     */
    public ApiResult<UserDto> addUser(AddUserRequestDto addUserRequestDto) {
        if (addUserRequestDto.getEmail() == null || addUserRequestDto.getPassword() == null) {
            return new MissingDataResult<>();
        }
        if (addUserRequestDto.getEmail().isBlank() || addUserRequestDto.getPassword().isBlank()) {
            return new MissingDataResult<>();
        }
        if (userRepository.existsByEmail(addUserRequestDto.getEmail())) {
            UUID id = userRepository.findIdByEmail(addUserRequestDto.getEmail());
            Map<ResultProperty, String> properties = Map.of(ResultProperty.CONFLICTED_ID, id.toString());
            return new UserAlreadyExistsResult<>(properties);
        }
        UserEntity user = UserRequestDtoToUserConverter.INSTANCE.convert(addUserRequestDto);
        UserEntity savedUser = userRepository.save(user);
        UserDto userDto = UserToUserDtoConverter.INSTANCE.convert(savedUser);
        return new ApiResult<>(userDto);
    }

    /**
     * checks requirements for editing user than
     * edit all information about User
     * after that returns the result of method
     * @param addUserRequestDto - dto model of user
     * @return ApiResult<UserDto> - result of the method
     */
    public ApiResult<UserDto> editUser(AddUserRequestDto addUserRequestDto) {
        if (addUserRequestDto.getEmail() == null || addUserRequestDto.getPassword() == null) {
            return new MissingDataResult<>();
        }
        if (addUserRequestDto.getEmail().isBlank() || addUserRequestDto.getPassword().isBlank()) {
            return new MissingDataResult<>();
        }
        Optional<UserEntity> user = userRepository.findByEmail(addUserRequestDto.getEmail());
        if (user.isEmpty()) {
            return new NotFoundResult<>();
        }
        UserEntity userToSave = user.get().toBuilder()
                .email(addUserRequestDto.getEmail())
                .password(addUserRequestDto.getPassword())
                .build();
        UserEntity savedUser = userRepository.save(userToSave);
        UserDto userDto = UserToUserDtoConverter.INSTANCE.convert(savedUser);
        return new ApiResult<>(userDto);
    }

}
