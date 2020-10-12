package com.zingpay.repository;

import com.zingpay.entity.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Bilal Hassan on 9/29/2020
 * @project zingpay-ms
 */

@Repository
public interface TransactionRepository extends BaseRepository<Transaction, Long>, PagingAndSortingRepository<Transaction, Long> {
    @Query(value = "SELECT sum(t.amount) as amount, " +
            "t.transaction_type_id as transactionTypeId, " +
            "t.transaction_status_id as transactionStatusId FROM transaction t " +
            "WHERE t.account_id=:accountId AND t.transaction_status_id != 2 " +
            "GROUP BY t.transaction_type_id, t.transaction_status_id;", nativeQuery = true)
    List<Object> findAllTransactions(long accountId);

    @Query(value = "SELECT " +
            "T.transaction_id, T.account_id, transaction_status_id, " +
            "transaction_type_id, zingpay_transaction_type_id, " +
            "retailer_ref_num, provider_ref_num, " +
            "amount, service_provider, description, " +
            "IFNULL(u2.full_name, ref_from) REF_FROM, " +
            "IFNULL(u2.username, ref_from) REF_FROM_USERNAME, " +
            "IFNULL(u1.full_name, ref_to) REF_TO, " +
            "IFNULL(u1.username, ref_to) REF_TO_USERNAME, datetime ,T.service_id " +
            "FROM " +
            "transaction T " +
            "LEFT OUTER JOIN app_user u1 ON T.ref_to = u1.username " +
            "LEFT OUTER JOIN app_user u2 ON T.ref_from = u2.username " +
            "WHERE " +
            "(T.account_id = :accountId) " +
            "AND (datetime >= :fromDate) " +
            "AND (datetime <= :toDate) " +
            "AND (transaction_status_id in (1)) " +
            "AND (transaction_type_id in (1)) " +
            "AND (zingpay_transaction_type_id in (1)) " +
            //"AND (retailer_ref_num = :retailerRefNum) " +
            "ORDER BY datetime DESC",
            countQuery = "SELECT " +
            "count(*) FROM transaction T " +
            "LEFT OUTER JOIN app_user u1 ON T.ref_to = u1.username " +
            "LEFT OUTER JOIN app_user u2 ON T.ref_from = u2.username " +
            "WHERE " +
            "(T.account_id = :accountId) " +
            "AND (datetime >= :fromDate) " +
            "AND (datetime <= :toDate) " +
            "AND (transaction_status_id in (1)) " +
            "AND (transaction_type_id in (1)) " +
            "AND (zingpay_transaction_type_id in (1)) " +
            //"AND (retailer_ref_num = :retailerRefNum) " +
            "ORDER BY datetime DESC", nativeQuery = true)
    Page<Object> findTransactionHistory(@Param("accountId") long accountId, @Param("fromDate") String fromDate, @Param("toDate") String toDate, Pageable pageable);


    @Query(value = "SELECT " +
            "transaction_status_id, " +
            "transaction_type_id, " +
            "zingpay_transaction_type_id, " +
            "SUM(amount) transactions_total, " +
            "COUNT(*) transaction_count " +
            "FROM " +
            "transaction T " +
            "WHERE (T.account_id = :accountId) " +
            "AND (T.DATETIME >= :fromDate) " +
            "AND (T.DATETIME <= :toDate) " +
            "AND (T.zingpay_transaction_type_id in (1,2,3,4,5,6,7,8)) " +
            "AND (TRANSACTION_STATUS_ID in (1)) " +
            "group by T.transaction_status_id, T.transaction_type_id, T.zingpay_transaction_type_id " +
            "order by T.transaction_status_id, T.transaction_type_id, T.zingpay_transaction_type_id",
            nativeQuery = true)
    List<Object> findTransactionSummary(long accountId, String fromDate, String toDate);
}
