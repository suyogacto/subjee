package com.suyoga.subjee.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class RandomSmsSystem {
	
public static void smsSystem(String mobile,String message){
		
		
		try {	
			
			///String totalTestApi="http://api.textlocal.in/send/?username=ssandha@suyoga.co.in&hash=d37a988d17171861885c6052121cdbfe031217db&sender=txtlcl&numbers="+mobile+"&message="+message;
		 ///String totalTestApi="http://newsms.designhost.in/index.php/smsapi/httpapi/?uname=suprit01&password=suyogacto001&sender=SMSOTP&receiver="+mobile+"&route=TA&msgtype=1&sms="+message;
			String totalTestApi="http://newsms.designhost.in/index.php/smsapi/httpapi/?uname=subrat01&password=suyogacto001&sender=SUYOGA&receiver="+mobile+"&route=TA&msgtype=1&sms="+message;
			URL url = new URL(totalTestApi);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}

			conn.disconnect();
			
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

}
