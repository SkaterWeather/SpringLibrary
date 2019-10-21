package libraryapp.service.impl;

import libraryapp.dao.RentDao;
import libraryapp.entity.Rent;
import libraryapp.service.RentService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RentServiceImpl implements RentService {

    @Autowired
    private RentDao rentDao;

    @Transactional
    @Override
    public void add(Rent rent) {
        rentDao.add(rent);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Rent> getAll() {
        return rentDao.getAll();
    }
}
