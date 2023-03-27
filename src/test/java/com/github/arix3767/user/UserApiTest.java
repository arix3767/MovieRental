package com.github.arix3767.user;

import com.github.arix3767.user.dto.AddUserRequestDto;
import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserApiTest {

    public static final String USER_PATH = "/user";

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private Gson gson;

    @BeforeEach
    void setUp() {
        userRepository.deleteAll();
    }

    @Test
    void shouldAddUser() throws Exception {
        AddUserRequestDto addUserRequestDto = buildAddUserRequestDto();
        mockMvc.perform(post(USER_PATH)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(gson.toJson(addUserRequestDto)))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    void shouldNotAddUserWhenCredentialsAreMissing() throws Exception {
        AddUserRequestDto addUserRequestDto = buildAddUserRequestDto().toBuilder()
                .email(null)
                .password(null)
                .build();
        mockMvc.perform(post(USER_PATH)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(gson.toJson(addUserRequestDto)))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    /**
     * given: user already exists in database
     * when: this user is added
     * then: user should not be added
     * and: 409 status should be received
     */
    @Test
    @DisplayName("WHEN user already exists THEN should not be added")
    void shouldNotAddUserWhenUserAlreadyExists() throws Exception {
        AddUserRequestDto addUserRequestDto = buildAddUserRequestDto();
        UserEntity user = UserRequestDtoToUserConverter.INSTANCE.convert(addUserRequestDto);
        userRepository.save(user);
        mockMvc.perform(post(USER_PATH)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(gson.toJson(addUserRequestDto)))
                .andDo(print())
                .andExpect(status().isConflict());
    }

    private AddUserRequestDto buildAddUserRequestDto() {
        return AddUserRequestDto.builder()
                .email("maciek")
                .password("2345")
                .build();
    }


}
