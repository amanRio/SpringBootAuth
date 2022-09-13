package com.example.demo.service;

import com.example.demo.domain.AppUser;
import com.example.demo.domain.Role;
import com.example.demo.repo.AppUserRepo;
import com.example.demo.repo.RoleRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AppUserServiceImplementation implements AppUserService {
    private final AppUserRepo appUserRepo;
    private final RoleRepo roleRepo;

    @Override
    public AppUser saveUser(AppUser user) {
        return appUserRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String email, String roleName) {
     AppUser user = appUserRepo.findByEmail(email);
     Role role= roleRepo.findByName(roleName);
     user.getRoles().add(role);
    }

    @Override
    public AppUser getUser(String email) {
        return appUserRepo.findByEmail(email);
    }

    @Override
    public List<AppUser> getUser() {
        return appUserRepo.findAll();
    }
}
