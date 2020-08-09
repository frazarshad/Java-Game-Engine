/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import java.io.File;
import java.util.HashMap;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author Fraz
 */
public class AudioController {

//    private HashMap<String, AudioStream> audioClipList;
    private HashMap<String, AudioInputStream> audioClipList;
//    private AudioStream currentAudioStream;
    private AudioInputStream currentAudioStream;
    private Clip clip = null;

    public AudioController() {
        try {
            clip = AudioSystem.getClip();
            audioClipList = new HashMap<>();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void addAudio(String name, String location) {

        try {
            File file = new File(location);
            AudioInputStream stream = AudioSystem.getAudioInputStream(file);

            audioClipList.put(name, stream);
            int x = 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
//        try {
//            InputStream file = new FileInputStream(location);
//            audioClipList.put(name, new AudioStream(file));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    public final void playOnce(String name) {
//        AudioPlayer.player.start(currentAudioStream);
        try {
            if (currentAudioStream != audioClipList.get(name)) {
                currentAudioStream = audioClipList.get(name);
                clip.open(currentAudioStream);
            }
            clip.setFramePosition(0);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public final void play(String name) {
        try {
            if (currentAudioStream != audioClipList.get(name)) {
                currentAudioStream = audioClipList.get(name);
                clip.open(currentAudioStream);
            }
            clip.setFramePosition(0);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public final void stop() {
//        AudioPlayer.player.stop();
        currentAudioStream = null;        
        clip.stop();
    }

}
