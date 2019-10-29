package libraryapp.service;

import java.util.List;
import java.util.Optional;

import libraryapp.entity.User;

public interface UserService {
    void add(User user);

    User get(Long id);

    List<User> getAll();

    Optional<User> getByEmail(String email);

    Optional<User> getByUsername(String username);
}
