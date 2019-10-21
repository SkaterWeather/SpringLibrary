package libraryapp.dao;

import libraryapp.entity.Author;

import java.util.List;

public interface AuthorDao {
    void add(Author author);

    List<Author> getAll();

    List<Author> getByName(String name);

    List<Author> getByNameAndSurname(String name, String surname);
}
