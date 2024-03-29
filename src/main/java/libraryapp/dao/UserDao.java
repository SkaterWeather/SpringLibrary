package libraryapp.dao;

import java.util.List;
import java.util.Optional;
import libraryapp.entity.User;

public interface UserDao {
    void add(User user);

    Optional<User> get(Long id);

    List<User> getAll();
}
