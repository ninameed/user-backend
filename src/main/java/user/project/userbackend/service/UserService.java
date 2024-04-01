package user.project.userbackend.service;

import user.project.userbackend.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto getUserById(Long id);
    List<UserDto> getAllUsers();
    UserDto updateUser(Long id, UserDto updatedUser);
    void deleteUser(Long id);
}
