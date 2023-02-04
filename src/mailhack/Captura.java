/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mailhack;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Jhoan
 */
public class Captura {

    public String TomarCaptura() {
        Rectangle rectangleTam = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
         String nombreFichero = "non";
        try {
            Robot robot = new Robot();
            // tomamos una captura de pantalla( screenshot )
            BufferedImage bufferedImage = robot.createScreenCapture(rectangleTam);

            nombreFichero = System.getProperty("user.home") + "\\desktop" + File.separatorChar + "caputura.jpg";
            System.out.println("Generando el fichero: " + nombreFichero);
            FileOutputStream out = new FileOutputStream(nombreFichero);

            // esbribe la imagen a fichero
            ImageIO.write(bufferedImage, "jpg", out);

        } catch (AWTException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return nombreFichero;
    }
}
