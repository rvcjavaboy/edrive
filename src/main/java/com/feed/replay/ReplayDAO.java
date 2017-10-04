package com.feed.replay;

public class ReplayDAO {
	public static boolean replay(String msg,String email){
				com.feed.Bean.FeedBean f=new com.feed.Bean.FeedBean();
				f.setName("Admin");
				f.setMsg(msg);
				f.setEmail(email);
				return com.email.EmailSend.sendReplyFeedback(f.getEmail(),f.getMsg(),f.getName());
		
		
		}
}
