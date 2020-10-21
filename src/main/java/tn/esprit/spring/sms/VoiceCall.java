package tn.esprit.spring.sms;

import java.net.URI;


import org.springframework.web.bind.annotation.RestController;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;


@RestController
public class VoiceCall {
	private final static String ACCOUNT_SID = "AC3516ef0735408cf3f34b1e53225667fa";
	private final static String AUTH_ID = "d7c9d7889b89693f030e4c9d1ababe48";
/*
	 public static void main(String[] args) {
	        Twilio.init(ACCOUNT_SID, AUTH_ID);
	        Call call = Call.creator(
	                new com.twilio.type.PhoneNumber("+21620752433"),
	                new com.twilio.type.PhoneNumber("+18509203338"),
	                URI.create("https://handler.twilio.com/twiml/EHd79f66f2b66ff4bf178f1742c929d0ce"))
	            .create();

	        System.out.println(call.getSid());
	    }
*/
	
}