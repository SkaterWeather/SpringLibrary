package libraryapp.dao;

import java.util.List;
import java.util.Optional;
import libraryapp.entity.Rent;

public interface RentDao {
    void add(Rent rent);

    Optional<Rent> get(Long id);

    void update(Rent rent);

    List<Rent> getAll();

    List<Rent> getAllByUserId(Long userId);
}
