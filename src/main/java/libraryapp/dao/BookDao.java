package libraryapp.dao;

import libraryapp.entity.Book;

import java.util.List;

public interface BookDao {
    void add(Book book);

    List<Book> getAll();
}
