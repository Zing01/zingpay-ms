package com.zingpay.repository;

import com.zingpay.entity.Transaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Bilal Hassan on 9/29/2020
 * @project zingpay-ms
 */

@Repository
public interface TransactionRepository extends BaseRepository<Transaction, Long> {
    @Query(value = "SELECT sum(t.amount) as amount, t.transaction_type_id as transactionTypeId, t.transaction_status_id as transactionStatusId FROM transaction t WHERE t.account_id=:accountId AND t.transaction_status_id != 2 GROUP BY t.transaction_type_id, t.transaction_status_id;", nativeQuery = true)
    List<Object> findAllByCustomQuery(long accountId);
}
