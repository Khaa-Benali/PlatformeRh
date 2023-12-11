/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UserModel;

import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 *
 * @author khadi
 */
public class SoundPlayer {

public static void playSound(String filePath) {
       
            File soundFile = new File(filePath);
            
            
            Media media = new Media(soundFile.toURI().toString());
            MediaPlayer MP = new MediaPlayer(media);
            MP.play();
      
    }
    
}
