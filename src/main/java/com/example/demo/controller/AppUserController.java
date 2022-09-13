package com.example.demo.controller;

import com.example.demo.domain.AppUser;
import com.example.demo.domain.Role;
import com.example.demo.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AppUserController {
    private final AppUserService appUserService;
    @GetMapping("/users")
    public ResponseEntity<List<AppUser>>getUser(){
        return ResponseEntity.ok().body(appUserService.getUser());
    }
    @PostMapping("/user/save")
    public ResponseEntity<AppUser> saveUser(@RequestBody AppUser user){
        return ResponseEntity.created(null).body(appUserService.saveUser(user));
    }
    @PostMapping("/role/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role){
        return ResponseEntity.ok().body(appUserService.saveRole(role));
    }

}
