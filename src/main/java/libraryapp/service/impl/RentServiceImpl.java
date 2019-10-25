package libraryapp.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import libraryapp.dao.RentDao;
import libraryapp.entity.Rent;
import libraryapp.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RentServiceImpl implements RentService {

    @Autowired
    private RentDao rentDao;

    @Override
    @Transactional
    public void add(Rent rent) {
        rentDao.add(rent);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Rent> getAll() {
        return rentDao.getAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Rent> getAllByUserId(Long userId) {
        return rentDao.getAllByUserId(userId);
    }

    @Override
    @Transactional
    public void discreditRent(Long rentId) {
        Rent rent = rentDao.get(rentId).orElseThrow(NoSuchElementException::new);
        rent.setActive(false);
        rentDao.update(rent);
    }
}
