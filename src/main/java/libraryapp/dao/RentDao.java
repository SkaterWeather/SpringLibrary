package libraryapp.dao;

import java.util.List;
import libraryapp.entity.Rent;

public interface RentDao {
    void add(Rent rent);

    List<Rent> getAll();
}
