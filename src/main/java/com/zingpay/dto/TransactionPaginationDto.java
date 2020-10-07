package com.zingpay.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author Bilal Hassan on 10/7/2020
 * @project zingpay-ms
 */

@Getter
@Setter
public class TransactionPaginationDto {
    private int totalPages;
    private List<TransactionDto> transactions;

    public TransactionPaginationDto(int totalPages, List<TransactionDto> transactions) {
        this.totalPages = totalPages;
        this.transactions = transactions;
    }
}
