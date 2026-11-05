package com.example.texts;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.Twilio;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import org.junit.jupiter.api.Test;

class TextServiceTest {

    @Test
    void sendsATextThroughTwilio() {
        TextService texts = new TextService("account", "token", "+15550001111");
        TwilioRestClient client = mock(TwilioRestClient.class);
        when(client.getAccountSid()).thenReturn("account");
        when(client.getObjectMapper()).thenReturn(new ObjectMapper());
        when(client.request(any(Request.class))).thenReturn(new Response("{\"sid\":\"SM123\"}", 201));
        Twilio.setRestClient(client);

        assertThat(texts.send("+15550002222", "hello")).isEqualTo("SM123");
    }
}
