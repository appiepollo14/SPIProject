package nl.avasten;

import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class Song {
    private String name;
    // TODO Check whether this is OKAY
//    private String lyricsOriginal;
    private EffectSong effectSong;
    //    private String lyricsAfterEffect;
    private List<Effect> effectList = new ArrayList<>();
    private PropertyChangeSupport support;

    public Song(String name, String lyricsOriginal, SoundModule soundModule) {
        this.effectSong = new EffectSong(lyricsOriginal, soundModule);
        this.name = name;
//        this.effectSong.setLyricsOriginal(lyricsOriginal);
        support = new PropertyChangeSupport(this);
        support.addPropertyChangeListener(this.effectSong);
    }

    public void addEffectToSong(Effect effect) {
        List<Effect> currentList = new ArrayList<>(effectList);
        currentList.add(effect);
        addEffectsToSong(currentList);
    }

    public void removeEffectFromSong(Effect effect) {
        List<Effect> currentList = new ArrayList<>(effectList);
        currentList.remove(effect);
        addEffectsToSong(currentList);
    }

    public void addEffectsToSong(List<Effect> appliedEffectList) {
        support.firePropertyChange("effectListChanged", this.effectList, appliedEffectList);
        this.effectList = appliedEffectList;
    }

    public String getName() {
        return name;
    }

    public String playSong() {
        if (this.effectList.size() > 0) {
            return (this.effectSong.getLyricsAfterEffect());

        } else {
            return (this.effectSong.getLyricsOriginal());
        }


    }

    public void setEffectSong(EffectSong effectSong) {
        this.effectSong = effectSong;
    }
}
