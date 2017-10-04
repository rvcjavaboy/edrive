package com.email;
import java.net.InetAddress;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
public class EmailSend {
	public static boolean emailSendAPI(String to,int id,String random){
		
		
		Properties pro=new Properties();
		pro.put("mail.smtp.host", "smtp.gmail.com");
		pro.put("mail.smtp.socketFactory.port","465");
		pro.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		pro.put("mail.smtp.auth","true");
		pro.put("mail.smtp.port", "465");
		
		Session session=Session.getInstance(pro, new javax.mail.Authenticator(){
			protected  PasswordAuthentication getPasswordAuthentication(){
				
				
				return new PasswordAuthentication("rvcinfo9600@gmail.com","192168137150");
				
				
		}
			
		});
		
		try{
			MimeMessage msg=new MimeMessage(session);
			msg.setFrom(new InternetAddress("rvcinfo9600@gmail.com"));
			msg.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
			msg.setSubject("E Drive Register");
			
			msg.setText("Your Account Verfication Link is This Please Click on Link for Account Activation http://edrive-rvc9600.rhcloud.com/verfication?id="+id+"&rel='"+random+"'");
			com.account.Activation.setkey(id,random);
			
			Transport.send(msg);
				return true;
		}catch(Exception e){e.printStackTrace();
		
		return false;
	
		}

		
	}public static boolean sendMailFileKey(String key,String email,String fileName){
		
		Properties pro=new Properties();
		pro.put("mail.smtp.host", "smtp.gmail.com");
		pro.put("mail.smtp.socketFactory.port","465");
		pro.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		pro.put("mail.smtp.auth","true");
		pro.put("mail.smtp.port", "465");
		
		Session session=Session.getInstance(pro, new javax.mail.Authenticator(){
			protected  PasswordAuthentication getPasswordAuthentication(){
				
				
				return new PasswordAuthentication("rvcinfo9600@gmail.com","192168137150");
				
				
		}
			
		});
		
		try{
			String message="Your File : "+fileName+"    Secret Key :  "+key;
			MimeMessage msg=new MimeMessage(session);
			msg.setContent(message,"text/html");
			msg.setFrom(new InternetAddress("rvcinfo9600@gmail.com"));
			msg.addRecipient(Message.RecipientType.TO,new InternetAddress(email));
			
			msg.setSubject("E Drive File Lock Key");
			
			msg.setText(message);
			
			Transport.send(msg);
				return true;
		}catch(Exception e){e.printStackTrace();
		
		return false;
	
		}

		
	}
	public static boolean sendReplyFeedback(String email_id,String msg1,String name){
		Properties pro=new Properties();
		pro.put("mail.smtp.host", "smtp.gmail.com");
		pro.put("mail.smtp.socketFactory.port","465");
		pro.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		pro.put("mail.smtp.auth","true");
		pro.put("mail.smtp.port", "465");
		
		Session session=Session.getInstance(pro, new javax.mail.Authenticator(){
			protected  PasswordAuthentication getPasswordAuthentication(){
				
				
				return new PasswordAuthentication("rvcinfo9600@gmail.com","192168137150");
				
				
		}
			
		});
		
		try{
			String message="From : Admin,    "+msg1;
			MimeMessage msg=new MimeMessage(session);
			msg.setContent(message,"text/html");
			msg.setFrom(new InternetAddress("rvcinfo9600@gmail.com"));
			msg.addRecipient(Message.RecipientType.TO,new InternetAddress(email_id));
			
			msg.setSubject("E Drive Replay");
			
			msg.setText(message);
			
			Transport.send(msg);
				return true;
		}catch(Exception e){e.printStackTrace();
		
		return false;
	
		}


		
	}public static boolean sendForgotPasswordLink(String email,String id){
		
		Properties pro=new Properties();
		pro.put("mail.smtp.host", "smtp.gmail.com");
		pro.put("mail.smtp.socketFactory.port","465");
		pro.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		pro.put("mail.smtp.auth","true");
		pro.put("mail.smtp.port", "465");
		
		Session session=Session.getInstance(pro, new javax.mail.Authenticator(){
			protected  PasswordAuthentication getPasswordAuthentication(){
				
				
				return new PasswordAuthentication("rvcinfo9600@gmail.com","192168137150");
				
				
		}
			
		});
		
		try{
			String message="Please Click On Link http://edrive-rvc9600.rhcloud.com/forgotValidate?session_pass="+id+"&email_id="+email;
			MimeMessage msg=new MimeMessage(session);
			msg.setContent(message,"text/html");
			msg.setFrom(new InternetAddress("rvcinfo9600@gmail.com"));
			msg.addRecipient(Message.RecipientType.TO,new InternetAddress(email));
			
			msg.setSubject("E Drive Forgot Password");
			
			msg.setText(message);
			
			Transport.send(msg);
				return true;
		}catch(Exception e){e.printStackTrace();
		
		return false;
	
	
	}
		}
}
