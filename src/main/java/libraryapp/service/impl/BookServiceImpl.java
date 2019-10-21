package libraryapp.service.impl;

import java.util.List;
import libraryapp.dao.BookDao;
import libraryapp.entity.Book;
import libraryapp.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Transactional
    @Override
    public void add(Book book) {
        bookDao.add(book);
    }

    @Transactional(readOnly = true)
    @Override
    public Book get(Long id) {
        return bookDao.get(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Book> getAll() {
        return bookDao.getAll();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Book> getByTitle(String title) {
        return bookDao.getByTitle(title);
    }
}
