package libraryapp.service;

import libraryapp.entity.Rent;

import java.util.List;

public interface RentService {
    void add(Rent rent);

    List<Rent> getAll();
}
