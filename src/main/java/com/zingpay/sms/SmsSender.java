package com.zingpay.sms;

import com.zingpay.dto.SmsDto;
import com.zingpay.util.Utils;
import org.springframework.stereotype.Component;

import java.net.URLEncoder;

/**
 * @author Bilal Hassan on 22-Oct-20
 * @project zingpay-ms
 */

@Component
public class SmsSender {

    public void sendSms(SmsDto smsDto) {
        StringBuilder url = new StringBuilder("https://connect.jazzcmt.com/sendsms_url.html?Username=03012448757&Password=Jazz@123&From=Business&To=");
        url.append(smsDto.getTo());
        url.append("&Message=");
        //url.append(smsDto.getText());
        url.append(URLEncoder.encode(smsDto.getText()));
        Utils.executeURL(url.toString(), "", "GET", "", "");
    }
}
