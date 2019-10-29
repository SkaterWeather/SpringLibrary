package libraryapp.service.impl;

import java.util.Optional;
import libraryapp.entity.Role;
import libraryapp.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserDetailsServiceImp implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<libraryapp.entity.User> user = userService.getByUsername(username);
        if (user.isPresent()) {
            User.UserBuilder builder = User.withUsername(username);
            builder.password(new BCryptPasswordEncoder().encode(user.get().getPassword()));
            builder.roles(user.get().getRoles()
                    .stream().map(Role::getRoleName).toArray(String[]::new));
            return builder.build();
        } else {
            throw new UsernameNotFoundException("User not found.");
        }
    }
}
