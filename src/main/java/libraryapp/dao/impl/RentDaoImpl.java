package libraryapp.dao.impl;

import java.util.List;
import java.util.Optional;
import javax.persistence.TypedQuery;
import libraryapp.dao.RentDao;
import libraryapp.entity.Rent;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RentDaoImpl implements RentDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Rent rent) {
        sessionFactory.getCurrentSession().save(rent);
    }

    @Override
    public Optional<Rent> get(Long id) {
        TypedQuery<Rent> query = sessionFactory.getCurrentSession()
                .createQuery("FROM Rent WHERE id=:id", Rent.class);
        query.setParameter("id", id);
        return Optional.ofNullable(query.getSingleResult());
    }

    @Override
    public void update(Rent rent) {
        sessionFactory.getCurrentSession().update(rent);
    }

    @Override
    public List<Rent> getAll() {
        TypedQuery<Rent> query = sessionFactory.getCurrentSession()
                .createQuery("FROM Rent", Rent.class);
        return query.getResultList();
    }

    @Override
    public List<Rent> getAllByUserId(Long userId) {
        TypedQuery<Rent> query = sessionFactory.getCurrentSession()
                .createQuery("FROM Rent WHERE user.id=:userId", Rent.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }
}
