package libraryapp.dao.impl;

import java.util.List;
import java.util.Optional;
import javax.persistence.TypedQuery;
import libraryapp.dao.BookDao;
import libraryapp.entity.Book;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Book book) {
        sessionFactory.getCurrentSession().save(book);
    }

    @Override
    public Optional<Book> get(Long id) {
        TypedQuery<Book> query = sessionFactory.getCurrentSession()
                .createQuery("FROM Book WHERE id=:id", Book.class);
        query.setParameter("id", id);
        return Optional.ofNullable(query.getSingleResult());
    }

    @Override
    public List<Book> getAll() {
        TypedQuery<Book> query = sessionFactory.getCurrentSession()
                .createQuery("FROM Book", Book.class);
        return query.getResultList();
    }

    @Override
    public List<Book> getByTitle(String title) {
        TypedQuery<Book> query = sessionFactory.getCurrentSession()
                .createQuery("FROM Book WHERE title LIKE CONCAT('%', :title, '%')", Book.class);
        query.setParameter("title", title);
        return query.getResultList();
    }
}
