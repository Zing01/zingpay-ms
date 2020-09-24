package com.zingpay.service;

import com.zingpay.entity.AppUser;
import com.zingpay.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Bilal Hassan on 11-Sep-2020
 * @project ZingPay
 */

@Service
@Transactional
public class AppUserService {

    @Autowired
    private AppUserRepository appUserRepository;

    public AppUser save(AppUser appUser) {
        if(appUser.getPassword() != null) {
            String encodedPassword = PasswordEncoderFactories.createDelegatingPasswordEncoder().encode(appUser.getPassword());
            appUser.setPassword(encodedPassword);
        }

        /*Optional<Role> roleOptional = roleRepository.findById(1L);
        Role role = null;
        if(roleOptional.isPresent()) {
            role = roleOptional.get();
        }

        Iterable<Authority> authorityIterable = authorityRepository.findAll();

        if(role != null) {
            role.setAuthorities(new HashSet<Authority>((Collection<? extends Authority>)authorityIterable)); //this is temporary
            //appUser.setRoles(new HashSet<Role>(Arrays.asList(role)));
        }*/
        return appUserRepository.save(appUser);
    }

    public AppUser update(AppUser appUser) {
        if(appUser.getPassword() != null) {
            String encodedPassword = PasswordEncoderFactories.createDelegatingPasswordEncoder().encode(appUser.getPassword());
            appUser.setPassword(encodedPassword);
        }
        return appUserRepository.save(appUser);
    }

    public AppUser getById(int accountId) {
        return appUserRepository.findByAccountId(accountId);
    }

    public AppUser getByEmail(String email) {
        return appUserRepository.findByEmail(email);
    }
}
