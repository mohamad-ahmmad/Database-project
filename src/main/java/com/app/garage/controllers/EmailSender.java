/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.garage.controllers;


import java.awt.Desktop;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;





 
public class EmailSender {
 
    
    public static void openBrowser(String website) throws IOException, URISyntaxException{
        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
         Desktop.getDesktop().browse(new URI("http://gmail.com"));
         
         }
    }
    public static void clipBoardText(String text){
         StringSelection stringSelection = new StringSelection(text);
         Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
         clipboard.setContents(stringSelection, null);
    }
    
  /*  private static  EmailSender singleton ;
    
    private static final String fromEmail = "company.daraghmeh@gmail.com";
    private static final String password= "cwqfmlilhcrcqzsu";//vhdpbjirllizxbac
    private static final String urlToGUI= "/UI/email-sender.fxml";
    private String toEmail;
    private Stage stage = new Stage();
    private String header;
    private String message;
    private static boolean flag = true;
    private Session session;
    
    public static EmailSender getInstance() throws IOException{
        if(flag){
         flag=false;
         singleton = new EmailSender();
         return singleton;
        }
        else
            return singleton;
    }
    
    
   
    private EmailSender() throws IOException{
      toEmail=header=message="";
      //  FXMLLoader loader = new FXMLLoader(getClass().getResource(urlToGUI));
      //  loader.setController(this);
      //  Parent root = loader.load();
      //  Scene sc = new Scene(root);
      //  stage.setScene(sc);
      //  stage.setResizable(false);
        
       Properties prop = new Properties();
	prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        prop.put("mail.debug", "true");
       prop.put("mail.smtp.ssl.protocols", "TLSv1.2");
        
         session = Session.getInstance(prop, new Authenticator() {
           
             @Override
           protected PasswordAuthentication getPasswordAuthentication(){
               return new PasswordAuthentication(fromEmail, password);
           }
        
        });
                session.getProperties().put("mail.smtp.ssl.trust", "smtp.gmail.com");
        
    }
    
    public void sendMessage( ) throws AddressException, MessagingException{
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("company.daraghmeh@gmail.com"));
        msg.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
        
        msg.setSubject(header);
        msg.setText(message);
        System.out.println(toEmail+"\n"+header+"\n"+message);
        Transport.send(msg);
        
        System.out.print("Message sent succsesfully");
    }
   
    PUBLIC FOR OTHER USES ?
   
    public void setToEmail(String to){
        toEmail = to;
    }
    public String getToEmail(){
        return toEmail;
    }
    
    
    public void setHeader(String head){
        header=head;
    }
    public String getHeader(){
        return header;
    }
    
    
    public void setMessage(String message){
        this.message=message;
    }
    public String getMessage(){
        return message;
    }
    
    
    public String getCompanyEmail(){
        return fromEmail;
    }
    
    public void showStage(){
        stage.show();
    }
    public void hideStage(){
        stage.hide();
    }
    
    @FXML
    private void labelClicked(){
        System.out.println("the label just clicked");
    }*/
  
}
