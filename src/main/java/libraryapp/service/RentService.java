package libraryapp.service;

import java.util.List;
import libraryapp.entity.Rent;

public interface RentService {
    void add(Rent rent);

    List<Rent> getAll();
}
