package user.project.userbackend.service.impl;

import org.springframework.stereotype.Service;
import user.project.userbackend.dto.UserDto;
import user.project.userbackend.entity.User;
import user.project.userbackend.mapper.UserMapper;
import user.project.userbackend.repository.UserRepository;
import user.project.userbackend.service.UserService;
import user.project.userbackend.exception.ResourceNotFoundException;
import java.util.ArrayList;
import java.util.List;


// @Service tells the Spring Container to create a Spring Bean for this class
@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = UserMapper.mapToUser(userDto);
        User savedUser = userRepository.save(user);
        return UserMapper.mapToUserDto(savedUser);
    }

    @Override
    public UserDto getUserById(Long id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User does not exist with this id: " + id));
        return UserMapper.mapToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers(){
        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = new ArrayList<>();

        for (User user : users) {
            userDtos.add(UserMapper.mapToUserDto(user));
        }
        return userDtos;
    }

    @Override
    public UserDto updateUser(Long id, UserDto updatedUser){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User does not exist with this id: " + id));

        user.setFirstName(updatedUser.getFirstName());
        user.setLastName(updatedUser.getLastName());
        user.setAddress(updatedUser.getAddress());
        user.setPhoneNumber(updatedUser.getPhoneNumber());
        user.setBirthDate(updatedUser.getBirthDate());

        User updatedUserObj = userRepository.save(user);

        return UserMapper.mapToUserDto(updatedUserObj);
    }

    @Override
    public void deleteUser(Long id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User does not exist with this id: " + id));
        userRepository.deleteById(id);
    }
}
