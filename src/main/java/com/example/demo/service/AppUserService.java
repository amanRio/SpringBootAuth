package com.example.demo.service;

import com.example.demo.domain.AppUser;
import com.example.demo.domain.Role;

import java.util.List;

public interface AppUserService {
    AppUser saveUser (AppUser user);
    Role saveRole (Role role);
    void  addRoleToUser (String email , String roleName);
    AppUser getUser(String email);
    List<AppUser>getUser();


}
