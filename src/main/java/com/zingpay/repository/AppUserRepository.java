package com.zingpay.repository;

import com.zingpay.entity.AppUser;
import org.springframework.stereotype.Repository;

/**
 * @author Bilal Hassan on 10-Sep-2020
 * @project ZingPay
 */

@Repository
public interface AppUserRepository extends BaseRepository<AppUser, Integer> {
    AppUser findByEmail(String email);
    AppUser findByAccountId(int accountId);
    AppUser findByCellPhone(String cellPhone);
}
