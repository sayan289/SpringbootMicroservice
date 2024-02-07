package com.lcwd.user.service.UserService.service;

import com.lcwd.user.service.UserService.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface userservice {
    public List<User> getuser();
    public User getUseById(String userId);
    public User adduser(User use);
}
