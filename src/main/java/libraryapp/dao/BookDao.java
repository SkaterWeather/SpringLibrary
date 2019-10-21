package libraryapp.dao;

import libraryapp.entity.Book;

import java.util.List;

public interface BookDao {
    void add(Book book);

    Book get(Long id);

    List<Book> getAll();

    List<Book> getByTitle(String title);
}
