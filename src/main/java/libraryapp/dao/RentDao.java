package libraryapp.dao;

import libraryapp.entity.Rent;

import java.util.List;

public interface RentDao {
    void add(Rent rent);

    List<Rent> getAll();
}
