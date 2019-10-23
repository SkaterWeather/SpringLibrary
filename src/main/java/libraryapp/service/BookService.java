package libraryapp.service;

import java.util.List;
import libraryapp.entity.Book;

public interface BookService {
    void add(Book book);

    Book get(Long id);

    List<Book> getAll();

    List<Book> getByTitle(String title);
}
