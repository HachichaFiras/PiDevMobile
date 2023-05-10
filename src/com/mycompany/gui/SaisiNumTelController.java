package com.mycompany.gui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;



/**
q
 *
 * @author 21624
 */
public class SaisiNumTelController  {

   
     
   

  

    private void envoyerSms() {
      Twilio.init("AC9e5756eee95f7fb3d68d8432aa0d2d9d", "645815f51111c91607f823ddf3f94d08");

// Set the recipient phone number and message content
PhoneNumber to = new PhoneNumber("+24949242");
PhoneNumber from = new PhoneNumber("+12762888654");
String messageText = "Hello from Twilio!";

// Use the Twilio API to send the SMS message
Message message = Message.creator(to, from, messageText).create();
    }
    
}
