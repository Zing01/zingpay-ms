package com.zingpay.controller;

import com.zingpay.dto.*;
import com.zingpay.entity.AppUser;
import com.zingpay.service.AppUserService;
import com.zingpay.service.BookMeService;
import com.zingpay.service.CalculateCommissionService;
import com.zingpay.service.WalletService;
import com.zingpay.util.*;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Bilal Hassan on 03-Mar-21
 * @project zingpay-ms
 */

@RestController
@RequestMapping("/bookme/service")
@Api(value = "bookme", description = "Controller for bookme")
public class BookMeServiceController extends BaseController {

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private WalletService walletService;

    @Autowired
    private CalculateCommissionService calculateCommissionService;

    @Autowired
    private BookMeService bookMeService;

    @PostMapping("/book-event")
    public Status validateUserAndBookEvent(@RequestBody BookMeEventRequestDto bookMeEventRequestDto) {
        AppUser appUser = appUserService.getById(Integer.parseInt(bookMeEventRequestDto.getAccountId()+""));
        double balance = walletService.getCurrentBalance(Integer.parseInt(bookMeEventRequestDto.getAccountId()+""));
        Status status = null;

        TransactionDto transactionDto = populateTransactionDtoFields(bookMeEventRequestDto);
        BookMeEventDto bookMeEventDto = BookMeEventDto.convertToDto(bookMeEventRequestDto);

        if(appUser.getAccountStatusId() == AccountStatus.ACTIVE.getId()) {
            if(balance < bookMeEventRequestDto.getAmount()) {
                return new Status(StatusMessage.INSUFFICIENT_BALANCE);
            }
            status = bookMeService.bookEvent(transactionDto, bookMeEventDto);
        } else {
            return new Status(StatusMessage.ACCOUNT_NOT_ACTIVE);
        }

        if(status.getCode()==1) {
            TransactionDto transactionDtoForCommission = (TransactionDto) status.getAdditionalDetail();
            //calculateCommissionService.calculateCommission(TransactionDto.convertToEntity(transactionDtoForCommission));
            CommissionDto commissionDto = new CommissionDto();
            commissionDto.setAccountId(Integer.parseInt(transactionDto.getAccountId()+""));
            commissionDto.setServiceId(transactionDto.getServiceId());
            commissionDto.setTransactionId(transactionDto.getId());
            calculateCommissionService.calculateCommission(commissionDto);
        }
        return status;
    }

    @PostMapping("/book-seats")
    public Status validateUserAndBookSeats(@RequestBody BookMeBusRequestDto bookMeBusRequestDto) {
        AppUser appUser = appUserService.getById(Integer.parseInt(bookMeBusRequestDto.getAccountId()+""));
        double balance = walletService.getCurrentBalance(Integer.parseInt(bookMeBusRequestDto.getAccountId()+""));
        Status status = null;

        TransactionDto transactionDto = populateTransactionDtoFields(bookMeBusRequestDto);
        BookMeBusDto bookMeBusDto = BookMeBusDto.convertToDto(bookMeBusRequestDto);

        if(appUser.getAccountStatusId() == AccountStatus.ACTIVE.getId()) {
            if(balance < bookMeBusRequestDto.getAmount()) {
                return new Status(StatusMessage.INSUFFICIENT_BALANCE);
            }
            status = bookMeService.bookSeats(transactionDto, bookMeBusDto);
        } else {
            return new Status(StatusMessage.ACCOUNT_NOT_ACTIVE);
        }

        if(status.getCode()==1) {
            TransactionDto transactionDtoForCommission = (TransactionDto) status.getAdditionalDetail();
            //calculateCommissionService.calculateCommission(TransactionDto.convertToEntity(transactionDtoForCommission));
            CommissionDto commissionDto = new CommissionDto();
            commissionDto.setAccountId(Integer.parseInt(transactionDto.getAccountId()+""));
            commissionDto.setServiceId(transactionDto.getServiceId());
            commissionDto.setTransactionId(transactionDto.getId());
            calculateCommissionService.calculateCommission(commissionDto);
        }
        return status;
    }

    private TransactionDto populateTransactionDtoFields(BookMeBusRequestDto bookMeBusRequestDto) {
        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setAccountId(bookMeBusRequestDto.getAccountId());
        transactionDto.setServiceId(bookMeBusRequestDto.getServiceId());
        transactionDto.setAmount(bookMeBusRequestDto.getAmount());
        transactionDto.setServiceProvider(bookMeBusRequestDto.getServiceProvider());

        if(bookMeBusRequestDto.getRetailerRefNumber().contains("MOBILE")) {
            transactionDto.setChannelType(ChannelType.MOBILE);
        } else if(bookMeBusRequestDto.getRetailerRefNumber().contains("WEB")) {
            transactionDto.setChannelType(ChannelType.WEB);
        }

        transactionDto.setRefTo(bookMeBusRequestDto.getRefTo());
        transactionDto.setBundleId(bookMeBusRequestDto.getBundleId());
        transactionDto.setDateTime(bookMeBusRequestDto.getDateTime());
        transactionDto.setEmail(bookMeBusRequestDto.getEmail());
        transactionDto.setRefFrom("zingpay");
        transactionDto.setTransactionType(TransactionType.DEBIT);
        transactionDto.setZingpayTransactionType(ZingpayTransactionType.TX_LOAD);
        transactionDto.setRetailerRefNumber(bookMeBusRequestDto.getRetailerRefNumber()+"-"+ Utils.generateTenDigitsNumber());

        return transactionDto;
    }

    private TransactionDto populateTransactionDtoFields(BookMeEventRequestDto bookMeEventRequestDto) {
        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setAccountId(bookMeEventRequestDto.getAccountId());
        transactionDto.setServiceId(bookMeEventRequestDto.getServiceId());
        transactionDto.setAmount(bookMeEventRequestDto.getAmount());
        transactionDto.setServiceProvider(bookMeEventRequestDto.getServiceProvider());

        if(bookMeEventRequestDto.getRetailerRefNumber().contains("MOBILE")) {
            transactionDto.setChannelType(ChannelType.MOBILE);
        } else if(bookMeEventRequestDto.getRetailerRefNumber().contains("WEB")) {
            transactionDto.setChannelType(ChannelType.WEB);
        }

        transactionDto.setRefTo(bookMeEventRequestDto.getRefTo());
        transactionDto.setBundleId(bookMeEventRequestDto.getBundleId());
        transactionDto.setDateTime(bookMeEventRequestDto.getDateTime());
        transactionDto.setEmail(bookMeEventRequestDto.getEmail());
        transactionDto.setRefFrom("zingpay");
        transactionDto.setTransactionType(TransactionType.DEBIT);
        transactionDto.setZingpayTransactionType(ZingpayTransactionType.TX_LOAD);
        transactionDto.setRetailerRefNumber(bookMeEventRequestDto.getRetailerRefNumber()+"-"+ Utils.generateTenDigitsNumber());

        return transactionDto;
    }
}
