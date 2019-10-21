package libraryapp.service;

import libraryapp.entity.Author;

import java.util.List;

public interface AuthorService {
    void add(Author author);

    List<Author> getAll();

    List<Author> getByName(String name);

    List<Author> getByNameAndSurname(String name, String surname);
}
