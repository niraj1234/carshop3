package org.niraj.util;

public class SendGmail {

	private String senderUser;
	private String senderPass;

	public String getSenderUser() {
		return senderUser;
	}

	public void setSenderUser(String senderUser) {
		this.senderUser = senderUser;
	}

	public String getSenderPass() {
		return senderPass;
	}

	public void setSenderPass(String senderPass) {
		this.senderPass = senderPass;
	}

	public void sendMail(String subject) {
		System.out.println("Sending mail " + this.toString() + "Subject " + subject);
	}

	@Override
	public String toString() {
		return "SendGmail [senderUser=" + senderUser + ", senderPass=" + senderPass + "]";
	}

}
