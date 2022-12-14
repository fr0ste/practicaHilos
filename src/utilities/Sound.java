/* Autor:Figueroa Martinez Joel Francisco
 * 
 * Fecha de creacion: 14/12/2022
 * Fecha de modificacion: 14/12/2022
 * 
 * Descripcion: clase de sonidos utilizados segun los eventos.
 * 
 */

package utilities;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author froste
 */
public class Sound {
    
    /**
     /* clase que devuelve un sonido pensado para cuando pase el mouse sobre
     *  un componene, por ejemplo, un boton.
     */
    public static void mousePass(){
    try {
         // Open an audio input stream.
         
         AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File("src/sounds/mosePass.wav"));
         // Get a sound clip resource.
         Clip clip = AudioSystem.getClip();
         // Open audio clip and load samples from the audio input stream.
         clip.open(audioIn);
         clip.start();
      } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
      }
    }
    
}
