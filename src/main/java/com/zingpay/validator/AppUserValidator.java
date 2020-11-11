package com.zingpay.validator;

import com.zingpay.dto.AppUserDto;
import com.zingpay.util.Regex;
import com.zingpay.util.Status;
import com.zingpay.util.StatusMessage;
import com.zingpay.util.Utils;

import java.util.Date;

/**
 * @author Bilal Hassan on 10/6/2020
 * @project zingpay-ms
 */

public class AppUserValidator {

    public static Status validateOnRegister(AppUserDto appUserDto) {
        if(appUserDto.getFullName() == null || appUserDto.getFullName().equals("")) {
            return new Status(StatusMessage.FULLNAME_IS_REQUIRED);
        }

        if(appUserDto.getFullName() != null && appUserDto.getFullName().length() > 40) {
            return new Status(StatusMessage.FULL_NAME_MAX_LIMIT_EXCEEDS);
        }

        if(!Regex.validateFullName(appUserDto.getFullName())) {
            return new Status(StatusMessage.FULL_NAME_CAN_BE_ONLY_ALPHABETS);
        }

        if(appUserDto.getCellPhone() == null || appUserDto.getCellPhone().equals("")) {
            return new Status(StatusMessage.CELL_PHONE_IS_REQUIRED);
        }

        if(!Regex.validateMobileNumber(appUserDto.getCellPhone())) {
            return new Status(StatusMessage.CELL_PHONE_NOT_VALID);
        }

        if(appUserDto.getEmail() == null || appUserDto.getEmail().equals("")) {
            return new Status(StatusMessage.EMAIL_IS_REQUIRED);
        }

        if(!Regex.validateEmail(appUserDto.getEmail())) {
            return new Status(StatusMessage.EMAIL_NOT_VALID);
        }

        if(appUserDto.getCnicNumber() == null || appUserDto.getCnicNumber().equals("")) {
            return new Status(StatusMessage.CNIC_IS_REQUIRED);
        }

        if(!Regex.validateCNIC(appUserDto.getCnicNumber())) {
            return new Status(StatusMessage.CNIC_NOT_VALID);
        }

        return new Status(StatusMessage.SUCCESS);
    }

    public static Status validateOnAccountSetup(AppUserDto appUserDto) {
        if(appUserDto.getBusinessName() == null || appUserDto.getBusinessName().equals("")) {
            return new Status(StatusMessage.BUSINESS_NAME_IS_REQUIRED);
        }

        if(appUserDto.getMobileLocation() == null || appUserDto.getMobileLocation().equals("")) {
            return new Status(StatusMessage.MOBILE_LOCATION_IS_REQUIRED);
        }

        if(appUserDto.getAccountType().getId() == 1) {
            if(appUserDto.getTransactionId() == null || appUserDto.getTransactionId().equals("")) {
                return new Status(StatusMessage.TRANSACTION_ID_IS_REQUIRED);
            }

            String transactionDateString = Utils.getFormattedDate(appUserDto.getTransactionDate());
            Date transactionDate = Utils.getFormattedDate(transactionDateString);
            if(transactionDate.after(new Date())) {
                return new Status(StatusMessage.TRANSACTION_DATE_CANNOT_BE_OF_FUTURE);
            }

            if(appUserDto.getTransactionDate() == 0) {
                return new Status(StatusMessage.TRANSACTION_DATE_IS_REQUIRED);
            }

            if(appUserDto.getTransactionAmount() == 0) {
                return new Status(StatusMessage.TRANSACTION_AMOUNT_IS_REQUIRED);
            }
        }

        String cnicIssueDateString = Utils.getFormattedDate(appUserDto.getCnicIssueDate());
        Date cnicIssueDate = Utils.getFormattedDate(cnicIssueDateString);
        if(cnicIssueDate.after(new Date())) {
            return new Status(StatusMessage.CNIC_ISSUE_DATE_CANNOT_BE_OF_FUTURE);
        }

        if(appUserDto.getCnicIssueDate() == 0 ||
                appUserDto.getCnicFront() == null || appUserDto.getCnicFront().equals("") ||
                appUserDto.getCnicBack() == null || appUserDto.getCnicBack().equals("")) {
            return new Status(StatusMessage.CNIC_IS_REQUIRED);
        }

        if(appUserDto.getAddress() == null || appUserDto.getAddress().equals("")) {
            return new Status(StatusMessage.ADDRESS_IS_REQUIRED);
        }

        if(appUserDto.getHouseNumber() == null || appUserDto.getHouseNumber().equals("")) {
            return new Status(StatusMessage.HOUSE_NUMBER_IS_REQUIRED);
        }

        return new Status(StatusMessage.SUCCESS);
    }
}
