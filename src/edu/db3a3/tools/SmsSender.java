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
 * @author sofie
 */
public class SmsSender {
  
    // Find your Account Sid and Auth Token at twilio.com/console
  public static final String ACCOUNT_SID =
            "AC83e8c38aae2902d96d769a9e997fe0c8";
    public static final String AUTH_TOKEN =
            "437a3334cb37ed691e67b83546a2e3b0";


    public void send(String s,String x){
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
      String y="+216"+x;
        Message message = Message 
                .creator(new PhoneNumber(y), // to
                        new PhoneNumber("+12014742109"), // from
                       ""+s)
                .create();
  System.out.println("aaslema");
        System.out.println(message.getSid());
    }
}
    

