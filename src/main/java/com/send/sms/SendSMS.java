package com.send.sms;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.X509TrustManager;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.net.URLEncoder;
public class SendSMS {
	
	public static String number,sms;
	public void sendMessage() {

		try {

			final TrustManager[] trustAllCerts = new TrustManager[] { 
					new X509TrustManager() 
					{
						@Override
						public void checkClientTrusted( final X509Certificate[] chain, final String authType ) {
						}
						@Override
						public void checkServerTrusted( final X509Certificate[] chain, final String authType ) {
						}
						@Override
						public X509Certificate[] getAcceptedIssuers() {
							return null;
						}
					} };
			


			final SSLContext sslContext = SSLContext.getInstance( "SSL" );
			sslContext.init( null, trustAllCerts, new java.security.SecureRandom() );

			final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
			HttpsURLConnection.setDefaultSSLSocketFactory( sslContext.getSocketFactory() );
			URL url = new URL(getURLPath());
			final HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			conn.setRequestMethod("GET");
			int responseCode = conn.getResponseCode();
			//System.out.println("Response Code : " + responseCode);
			BufferedReader in = new BufferedReader(
			        new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
	 
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			System.out.println(response.toString());

		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (KeyManagementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private String getURLPath() {
		String msg="Test sms from "+sms+". Thanks for choosing our service - #Ranjit# - SMSC Platform";
		msg=msg.replaceAll("&","%26");
		msg=msg.replaceAll("%","%25");
		msg=msg.replaceAll(" ","%20");
		msg=msg.replaceAll("#","%23");
		msg=msg.replaceAll("=","%3D");	
		msg=msg.replaceAll("~","%7E");
		System.out.println(msg);
		String twar = getURL()+"httpapi/send?username=rvcinfo9600@gmail.com&password=Ranjit9600&sender_id=SMSIND&route=T&phonenumber="+number+"&message="+msg;
		com.send.sms.SendSmsServlet.status=twar;

		return twar;
	}

	private String getURL() {

		return "http://smsc.biz/";
	}
}
