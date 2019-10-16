package libraryapp.dao;

import java.util.List;

import libraryapp.entity.User;

public interface UserDao {
    void add(User user);

    List<User> listUsers();
}
