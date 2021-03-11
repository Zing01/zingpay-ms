package com.zingpay.controller;

import com.zingpay.dto.*;
import com.zingpay.entity.AppUser;
import com.zingpay.service.AppUserService;
import com.zingpay.service.BookMeService;
import com.zingpay.service.CalculateCommissionService;
import com.zingpay.service.WalletService;
import com.zingpay.util.AccountStatus;
import com.zingpay.util.Status;
import com.zingpay.util.StatusMessage;
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

        TransactionDto transactionDto = BookMeEventRequestDto.populateTransactionDtoFields(bookMeEventRequestDto);
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
            CommissionDto commissionDto = new CommissionDto();
            commissionDto.setAccountId(Integer.parseInt(transactionDto.getAccountId()+""));
            commissionDto.setServiceId(transactionDto.getServiceId());
            commissionDto.setTransactionId(transactionDto.getId());
            calculateCommissionService.calculateCommission(commissionDto);
        }
        return status;
    }

    @PostMapping("/book-bus-seats")
    public Status validateUserAndBookBusSeats(@RequestBody BookMeBusRequestDto bookMeBusRequestDto) {
        AppUser appUser = appUserService.getById(Integer.parseInt(bookMeBusRequestDto.getAccountId()+""));
        double balance = walletService.getCurrentBalance(Integer.parseInt(bookMeBusRequestDto.getAccountId()+""));
        Status status = null;

        TransactionDto transactionDto = BookMeBusRequestDto.populateTransactionDtoFields(bookMeBusRequestDto);
        BookMeBusDto bookMeBusDto = BookMeBusDto.convertToDto(bookMeBusRequestDto);

        if(appUser.getAccountStatusId() == AccountStatus.ACTIVE.getId()) {
            if(balance < bookMeBusRequestDto.getAmount()) {
                return new Status(StatusMessage.INSUFFICIENT_BALANCE);
            }
            status = bookMeService.bookBusSeats(transactionDto, bookMeBusDto);
        } else {
            return new Status(StatusMessage.ACCOUNT_NOT_ACTIVE);
        }

        if(status.getCode()==1) {
            CommissionDto commissionDto = new CommissionDto();
            commissionDto.setAccountId(Integer.parseInt(transactionDto.getAccountId()+""));
            commissionDto.setServiceId(transactionDto.getServiceId());
            commissionDto.setTransactionId(transactionDto.getId());
            calculateCommissionService.calculateCommission(commissionDto);
        }
        return status;
    }

    @PostMapping("/reserve-airline-seats")
    public Status validateUserAndReserveAirlineSeats(@RequestBody BookMeAirlineRequestDto bookMeAirlineRequestDto) {
        AppUser appUser = appUserService.getById(Integer.parseInt(bookMeAirlineRequestDto.getAccountId()+""));
        double balance = walletService.getCurrentBalance(Integer.parseInt(bookMeAirlineRequestDto.getAccountId()+""));
        Status status = null;

        TransactionDto transactionDto = BookMeAirlineRequestDto.populateTransactionDtoFields(bookMeAirlineRequestDto);
        BookMeAirlineDto bookMeAirlineDto = BookMeAirlineDto.convertToDto(bookMeAirlineRequestDto);

        if(appUser.getAccountStatusId() == AccountStatus.ACTIVE.getId()) {
            if(balance < bookMeAirlineRequestDto.getAmount()) {
                return new Status(StatusMessage.INSUFFICIENT_BALANCE);
            }
            status = bookMeService.reserveAirlineSeats(transactionDto, bookMeAirlineDto);
        } else {
            return new Status(StatusMessage.ACCOUNT_NOT_ACTIVE);
        }

        if(status.getCode()==1) {
            CommissionDto commissionDto = new CommissionDto();
            commissionDto.setAccountId(Integer.parseInt(transactionDto.getAccountId()+""));
            commissionDto.setServiceId(transactionDto.getServiceId());
            commissionDto.setTransactionId(transactionDto.getId());
            calculateCommissionService.calculateCommission(commissionDto);
        }
        return status;
    }


}
