package libraryapp.dao.impl;

import libraryapp.dao.AuthorDao;
import libraryapp.entity.Author;

import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AuthorDaoImpl implements AuthorDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Author author) {
        sessionFactory.getCurrentSession().save(author);
    }

    @Override
    public List<Author> getAll() {
        @SuppressWarnings("unchecked")
        TypedQuery<Author> query = sessionFactory.getCurrentSession().createQuery("FROM Author");
        return query.getResultList();
    }

    @Override
    public List<Author> getByName(String name) {
        @SuppressWarnings("unchecked")
        TypedQuery<Author> query = sessionFactory.getCurrentSession()
                .createQuery("FROM Author WHERE name LIKE CONCAT('%', :name, '%')");
        query.setParameter("name", name);
        return query.getResultList();
    }

    @Override
    public List<Author> getByNameAndSurname(String name, String surname) {
        @SuppressWarnings("unchecked")
        TypedQuery<Author> query = sessionFactory.getCurrentSession()
                .createQuery("FROM Author WHERE name LIKE CONCAT('%', :name, '%') "
                        + "AND surname LIKE CONCAT('%', :surname, '%')");
        query.setParameter("name", name);
        query.setParameter("surname", surname);
        return query.getResultList();
    }
}
