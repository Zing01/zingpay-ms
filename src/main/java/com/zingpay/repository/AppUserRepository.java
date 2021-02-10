package com.zingpay.repository;

import com.zingpay.entity.AppUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Bilal Hassan on 10-Sep-2020
 * @project zingpay-ms
 */

@Repository
public interface AppUserRepository extends BaseRepository<AppUser, Integer> {
    AppUser findByEmail(String email);

    AppUser findByAccountId(int accountId);

    AppUser findByCellPhone(String cellPhone);

    AppUser findByUsernameAndAccountStatusId(String username, int status);

    /*@Query(value = "SELECT account_id, username, parent_id, account_type_id, name as group_name FROM " +
            "(SELECT account_id, username, parent_id, account_type_id, name, " +
            "   CASE WHEN account_id = :accountId THEN @id \\:= parent_id " +
            "     WHEN account_id = @id THEN @id \\:= parent_id " +
            "   END as checkId " +
            "FROM app_user INNER JOIN user_group ON(app_user.group_id = user_group.USER_GROUP_ID) " +
            "ORDER BY account_id DESC)T " +
            "WHERE checkId IS NOT NULL", nativeQuery = true)*/

    @Query(value = "WITH RECURSIVE cte AS " +
            "(SELECT account_id, username, parent_id, account_type_id, group_id FROM app_user WHERE account_id = :accountId " +
            "UNION ALL " +
            "SELECT p.account_id, p.username, p.parent_id, p.account_type_id, p.group_id FROM app_user p " +
            "INNER JOIN cte ON p.account_id = cte.parent_id) " +
            "SELECT account_id, username, parent_id, account_type_id, name as group_name FROM cte " +
            "INNER JOIN user_group ON user_group.USER_GROUP_ID = cte.group_id", nativeQuery = true)
    List<Object> findAllAccountIdUsernameAccountTypeIdParentIdByAccountId(long accountId);

    AppUser findByUsername(String username);
}