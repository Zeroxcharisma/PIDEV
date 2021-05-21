/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui.front.produit;


import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

/**
 *
 * @author 
 */
public class SendSms {
    
     
    public static final String SID="AC90b331c56632553c2da783edd5eb986b";
    public static final String AUTH_TOKEN="46a67e21e2b778f17bcd67515fcadd88";
    public static String to="+216 50 089 056"; 
           
    public static String from= "+12028497924";

    public static void sendSMS(String content){
        Twilio.init(SID, AUTH_TOKEN);
        Message sms = Message.creator(new PhoneNumber(to), new PhoneNumber(from), content).create();
    }
    
}