package com.github.arix3767.user;

import com.github.arix3767.result.*;
import com.github.arix3767.user.dto.AddUserRequestDto;
import com.github.arix3767.user.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

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
