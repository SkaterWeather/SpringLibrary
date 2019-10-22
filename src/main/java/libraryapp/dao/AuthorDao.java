package libraryapp.dao;

import java.util.List;
import libraryapp.entity.Author;

public interface AuthorDao {
    void add(Author author);

    List<Author> getAll();

    List<Author> getByName(String name);

    List<Author> getByNameAndSurname(String name, String surname);
}
