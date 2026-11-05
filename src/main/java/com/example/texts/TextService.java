package com.example.texts;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TextService {

    private final PhoneNumber from;

    public TextService(
            @Value("${twilio.account-sid}") String accountSid,
            @Value("${twilio.auth-token}") String authToken,
            @Value("${twilio.from-number}") String fromNumber) {
        Twilio.init(accountSid, authToken);
        this.from = new PhoneNumber(fromNumber);
    }

    public String send(String to, String body) {
        return Message.creator(new PhoneNumber(to), from, body).create().getSid();
    }
}
