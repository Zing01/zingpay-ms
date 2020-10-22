package com.zingpay.service;

import com.zingpay.dto.AppUserDto;
import com.zingpay.entity.AppUser;
import com.zingpay.repository.AppUserRepository;
import com.zingpay.util.Status;
import com.zingpay.util.StatusMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Bilal Hassan on 11-Sep-2020
 * @project ZingPay
 */

@Service
@Transactional
public class AppUserService {

    @Autowired
    private AppUserRepository appUserRepository;

    private PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

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

    public AppUser getByCellPhone(String cellPhone) {
        return appUserRepository.findByCellPhone(cellPhone);
    }

    public List<AppUser> getAll() {
        return (List<AppUser>) appUserRepository.findAll();
    }

    public Status changePassword(AppUserDto appUserDto) {
        AppUser appUser = appUserRepository.findByAccountId(appUserDto.getAccountId());

        if(passwordEncoder.matches(appUserDto.getOldPassword(), appUser.getPassword())) {
            if(appUserDto.getPassword().equals(appUserDto.getConfirmPassword())) {
                appUser.setPassword(passwordEncoder.encode(appUserDto.getPassword()));
                AppUser savedAppUser = appUserRepository.save(appUser);
                return new Status(StatusMessage.PASSWORD_RESET_SUCCESS, savedAppUser.getAccountId());
            } else {
                return new Status(StatusMessage.PASSWORD_AND_CONFIRM_PASSWORD_NOT_MATCHED);
            }
        } else {
            return new Status(StatusMessage.INVALID_PASSWORD);
        }
    }
}
