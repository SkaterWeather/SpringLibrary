package libraryapp.dao;

import libraryapp.entity.Book;

import java.util.List;
import javax.persistence.TypedQuery;
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
    public List<Book> getAll() {
        @SuppressWarnings("unchecked")
        TypedQuery<Book> query = sessionFactory.getCurrentSession().createQuery("FROM Book");
        return query.getResultList();
    }
}
