package libraryapp.util;

import libraryapp.dto.UserDto;
import libraryapp.entity.User;

public class UserDtoConverterUtil {
    public static User createUser(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        return user;
    }
}
