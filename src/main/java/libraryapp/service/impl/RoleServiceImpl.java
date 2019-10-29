package libraryapp.service.impl;

import libraryapp.dao.RoleDao;
import libraryapp.entity.Role;
import libraryapp.service.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    @Transactional(readOnly = true)
    public Role getRoleByName(String roleName) {
        return roleDao.getRoleByName(roleName).get();
    }
}
