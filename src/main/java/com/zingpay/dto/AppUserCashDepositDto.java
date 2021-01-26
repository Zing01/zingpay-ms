package com.zingpay.dto;

import com.zingpay.entity.AppUser;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bilal Hassan on 26-Jan-21
 * @project zingpay-ms
 */

@Getter
@Setter
public class AppUserCashDepositDto {
    private String accountTitle;
    private String username;

    public static AppUserCashDepositDto convertToDto(AppUser appUser) {
        AppUserCashDepositDto appUserCashDepositDto = new AppUserCashDepositDto();
        appUserCashDepositDto.setUsername(appUser.getUsername());
        appUserCashDepositDto.setAccountTitle(appUser.getFullName());

        return appUserCashDepositDto;
    }

    public static List<AppUserCashDepositDto> convertToDto(List<AppUser> appUsers) {
        List<AppUserCashDepositDto> appUserCashDepositDtos = new ArrayList<AppUserCashDepositDto>();
        appUsers.forEach(appUser -> {
            appUserCashDepositDtos.add(convertToDto(appUser));
        });
        return appUserCashDepositDtos;
    }
}
