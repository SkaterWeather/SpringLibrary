package libraryapp.service.impl;

import java.util.List;
import libraryapp.dao.AuthorDao;
import libraryapp.entity.Author;
import libraryapp.service.AuthorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorDao authorDao;

    @Transactional
    @Override
    public void add(Author author) {
        authorDao.add(author);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Author> getAll() {
        return authorDao.getAll();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Author> getByName(String name) {
        return authorDao.getByName(name);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Author> getByNameAndSurname(String name, String surname) {
        return authorDao.getByNameAndSurname(name, surname);
    }
}
