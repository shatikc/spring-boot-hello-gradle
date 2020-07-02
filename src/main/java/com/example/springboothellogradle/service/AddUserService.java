package com.example.springboothellogradle.service;

import com.example.springboothellogradle.model.User;
import com.example.springboothellogradle.repo.UserCrudRepo;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AddUserService {

    private final UserCrudRepo userCrudRepo;

    public User addNewUser(User user) {
        User result = null;
        try {
            result = userCrudRepo.save(user);
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        return result;
    }

}
