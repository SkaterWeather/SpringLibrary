package libraryapp.dao;

import java.util.List;
import java.util.Optional;
import libraryapp.entity.Book;

public interface BookDao {
    void add(Book book);

    Optional<Book> get(Long id);

    List<Book> getAll();

    List<Book> getByTitle(String title);
}
