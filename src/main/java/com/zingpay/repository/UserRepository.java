package com.zingpay.repository;

import com.zingpay.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @author Bilal Hassan on 10-Sep-2020
 * @project ZingPay
 */

@Repository
public interface UserRepository extends BaseRepository<User, Long> {
}
