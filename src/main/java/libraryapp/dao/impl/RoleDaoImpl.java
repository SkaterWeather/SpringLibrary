package libraryapp.dao.impl;

import java.util.Optional;
import javax.persistence.TypedQuery;
import libraryapp.dao.RoleDao;
import libraryapp.entity.Role;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl implements RoleDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Optional<Role> getRoleByName(String roleName) {
        TypedQuery<Role> query = sessionFactory.getCurrentSession()
                .createQuery("FROM Role WHERE role_name=:roleName", Role.class);
        query.setParameter("roleName", roleName);
        try {
            return Optional.ofNullable(query.getSingleResult());
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
