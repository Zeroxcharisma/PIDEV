/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cours.gui;
   import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author maalaoui
 */
public class SmsController implements Initializable {
     public static final String ACCOUNT_SID =
            "AC1f0ddef19be08d4bc4831a9d837e906b";
    public static final String AUTH_TOKEN =
            "f50867c30471936e296689d1a8b100f2";

    @Override
     public void initialize(URL location, ResourceBundle resources) {

    
    

    }
     
      public void send(String s,String x){
         Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
      
        Message message = Message 
                .creator(new PhoneNumber("+21692351796"), // to
                        new PhoneNumber("+18638692753"), // from
                       ""+s)
                .create();
  System.out.println("****  ");
        System.out.println(message.getSid());
    
    }    

}

