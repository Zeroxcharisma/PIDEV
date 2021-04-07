/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a3.tools;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
/**
 *
 * @author Asus
 */
public class Sms {
      // Find your Account Sid and Auth Token at twilio.com/console

    public static final String ACCOUNT_SID =
            "AC17b545efea0ed27b2e2d3653e5a2aa9e";
    public static final String AUTH_TOKEN =
            "f72e80921fb8bd562393d4afc5658111";


    public void send(String s,String x){
         Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
      String y="+216"+x;
        Message message = Message 
                .creator(new PhoneNumber(y), // to
                        new PhoneNumber("+16504584051"), // from
                       ""+s)
                .create();
  System.out.println("aaslema");
        System.out.println(message.getSid());
    }
}