package libraryapp.service;

import java.util.List;
import libraryapp.entity.Rent;

public interface RentService {
    void add(Rent rent);

    List<Rent> getAll();

    List<Rent> getAllByUserId(Long userId);

    void discreditRent(Long rentId);
}
