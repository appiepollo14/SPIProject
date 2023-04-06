package nl.avasten;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class SoundModule {
    List<Effect> effectList = new ArrayList<>();
    List<Song> songList = new ArrayList<>();

    SoundModuleGUI gui;

    public SoundModule() {
        JFrame frame = new JFrame("SoundEffects");
        gui = new SoundModuleGUI(this);
        frame.setContentPane(gui.getRootPane());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        frame.setVisible(true);
    }

    public void addEffectToList(Effect effect) {
        effectList.add(effect);
    }

    public void addSongToList(Song song) {
        songList.add(song);
    }

    public void addEffectsToSong(String name, List<Effect> effectList) {
        Song songFind = songList.stream().filter(song -> name.equals(song.getName())).findFirst().orElseThrow(IllegalArgumentException::new);
        songFind.addEffectsToSong(effectList);
    }


    public void addEffectToSong(String name, Effect effect) {
        Song songFind = songList.stream().filter(song -> name.equals(song.getName())).findFirst().orElseThrow(IllegalArgumentException::new);
        songFind.addEffectToSong(effect);
    }

    public void removeEffectFromSong(String name, Effect effect) {
        Song songFind = songList.stream().filter(song -> name.equals(song.getName())).findFirst().orElseThrow(IllegalArgumentException::new);
        songFind.removeEffectFromSong(effect);
    }


    public List<Effect> getEffectList() {
        return this.effectList;
    }

    public void newEffect(String distortion, String distiortionTrigger) {


    }

    public String playSong(String name) {
        Song songFind = songList.stream().filter(song -> name.equals(song.getName())).findFirst().orElseThrow(IllegalArgumentException::new);
        return songFind.playSong();
    }

    public void setEffectList(List<Effect> effectList) {
        this.effectList = effectList;
    }

    public SoundModuleGUI getGui() {
        return gui;
    }

    public static void main(String[] args) {
        new SoundModule();
    }

}
