package user.project.userbackend.mapper;

import user.project.userbackend.dto.UserDto;
import user.project.userbackend.entity.User;


public class UserMapper {

    // Mapper for User-JPA-entity to User-DTO
    public static UserDto mapToUserDto(User user){
        return new UserDto(
                user.getFirstName(),
                user.getLastName(),
                user.getAddress(),
                user.getPhoneNumber(),
                user.getBirthDate(),
                user.getId()
        );
    }

    // Mapper for User-DTO to User-JPA-entity
    public static User mapToUser(UserDto userDto){
        return new User(
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getAddress(),
                userDto.getPhoneNumber(),
                userDto.getBirthDate(),
                userDto.getId()
        );
    }
}
