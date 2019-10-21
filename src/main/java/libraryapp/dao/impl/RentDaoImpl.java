package libraryapp.dao.impl;

import libraryapp.dao.RentDao;
import libraryapp.entity.Rent;

import java.util.List;
import javax.persistence.TypedQuery;
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
    public List<Rent> getAll() {
        @SuppressWarnings("unchecked")
        TypedQuery<Rent> query = sessionFactory.getCurrentSession().createQuery("FROM Rent");
        return query.getResultList();
    }
}
