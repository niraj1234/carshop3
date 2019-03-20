package org.niraj.junit1;

public class MessageUtil {

	private String message;

	public MessageUtil(String message){
	      this.message = message;
	   }
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String printMessage(){
	      System.out.println(message);
	      return message;
	   }   
	
}
