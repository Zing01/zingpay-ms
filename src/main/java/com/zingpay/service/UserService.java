package com.zingpay.service;

import com.zingpay.entity.User;
import com.zingpay.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author Bilal Hassan on 11-Sep-2020
 * @project ZingPay
 */

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }

    public User update(User user) {
        return userRepository.save(user);
    }

    public User getById(long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isPresent()) {
            return userOptional.get();
        } else {
            return null;
        }
    }
}
