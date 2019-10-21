package libraryapp.service;

import java.util.List;

import libraryapp.entity.User;

public interface UserService {
    void add(User user);

    List<User> getAll();
}
