package libraryapp.service;

import libraryapp.entity.Book;

import java.util.List;

public interface BookService {
    void add(Book book);

    List<Book> getAll();

    List<Book> getByTitle(String title);
}
