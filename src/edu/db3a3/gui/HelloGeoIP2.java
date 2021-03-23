/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a3.gui;

/**
 *
 * @author sofie
 */
import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.record.City;
import com.maxmind.geoip2.record.Country;
import com.maxmind.geoip2.record.Location;
import com.maxmind.geoip2.record.Postal;
import com.maxmind.geoip2.record.Subdivision;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;


import java.net.InetAddress;
import java.net.URL;





public class HelloGeoIP2 {
  public static void main(String[] args) throws IOException, GeoIp2Exception {
        
       // A File object pointing to your GeoLite2 database
       File dbFile = new File(MyConstants.DATABASE_CITY_PATH);
 
       // This creates the DatabaseReader object,
       // which should be reused across lookups.
 
       DatabaseReader reader = new DatabaseReader.Builder(dbFile).build();
 
       // A IP Address
       InetAddress localhost = InetAddress.getLocalHost(); 
    System.out.println("System IP Address : " + 
                  (localhost.getHostAddress()).trim()); 
    
     String systemipaddress = ""; 
    try
    { 
        URL url_name = new URL("http://bot.whatismyipaddress.com"); 

        BufferedReader sc = 
        new BufferedReader(new InputStreamReader(url_name.openStream())); 

        // reads system IPAddress 
        systemipaddress = sc.readLine().trim(); 
    } 
    catch (Exception e) 
    { 
        systemipaddress = "Cannot Execute Properly"; 
    } 
//    S.setIp(systemipaddress);
 
        
       // Get City info
       CityResponse response = reader.city(localhost);
 
       // Country Info
       Country country = response.getCountry();
       System.out.println("Country IsoCode: "+ country.getIsoCode()); // 'US'
       System.out.println("Country Name: "+ country.getName()); // 'United States'
       System.out.println(country.getNames().get("zh-CN")); // '美国'
 
       Subdivision subdivision = response.getMostSpecificSubdivision();
       System.out.println("Subdivision Name: " +subdivision.getName()); // 'Minnesota'
       System.out.println("Subdivision IsoCode: "+subdivision.getIsoCode()); // 'MN'
 
       // City Info.
       City city = response.getCity();
       System.out.println("City Name: "+ city.getName()); // 'Minneapolis'
 
       // Postal info
       Postal postal = response.getPostal();
       System.out.println(postal.getCode()); // '55455'
 
       // Geo Location info.
       Location location = response.getLocation();
        
       // Latitude
       System.out.println("Latitude: "+ location.getLatitude()); // 44.9733
        
       // Longitude
       System.out.println("Longitude: "+ location.getLongitude()); // -93.2323
 
   }
 
}