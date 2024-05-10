package momo.mail;

import javax.mail.internet.*; 
import java.util.Properties;
import java.util.Random;

import javax.mail.*; 

class Mail {
	  public static void send(String from,String pwd,String to,String sub,String msg){
	    //Propriétés
	    Properties p = new Properties();
	    p.put("mail.smtp.host", "smtp.gmail.com");
	    p.put("mail.smtp.starttls.enable", "true");
	    //p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	    p.put("mail.smtp.auth", "true");
	    p.put("mail.smtp.port", "587");
	    //Session
	    Session s = Session.getDefaultInstance(p,
	      new javax.mail.Authenticator() {
	      protected PasswordAuthentication getPasswordAuthentication() {
	         return new PasswordAuthentication(from, pwd);
	      }
	    });
	    //composer le message
	    try {
	      Message m = new MimeMessage(s);
	      m.setFrom(new InternetAddress(from));
	      m.setRecipient(Message.RecipientType.TO,new InternetAddress(to));
	      m.setSubject(sub);
	      m.setText(msg);
	      //envoyer le message
	      Transport.send(m);
	      System.out.println("Message envoyé avec succès");
	    } catch (MessagingException e) {
	      e.printStackTrace();
	    }
	  }
	  public static String generation_password()
	    {
	    	String combinaison="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
	    	Random rand=new Random();
	    	StringBuilder password=new StringBuilder();
	    	for(int i=0;i<8;i++)
	    	{
	    		int valeur=rand.nextInt(0,combinaison.length());
	    		password=password.append(combinaison.charAt(valeur));
	    	}
	    	
	    return password.toString();
	  }
	
	 public static void main(String[] args) {
	   //from, password, to, subject, message
	   Mail.send(
	    "senemamadou1999@gmail.com",
	    "oqzjtvzbrtutfahg",
	    "senemamadou1999@gmail.com",
	    "Activation de compte",
	    "Bonjour, pour vous connecter a votre compte, votre mot de passe est "+Mail.generation_password()
	  );
		 System.out.print(Mail.generation_password());
	 }
}