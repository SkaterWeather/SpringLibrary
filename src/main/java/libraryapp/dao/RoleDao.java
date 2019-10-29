package libraryapp.dao;

import java.util.Optional;
import libraryapp.entity.Role;

public interface RoleDao {
    Optional<Role> getRoleByName(String roleName);
}
