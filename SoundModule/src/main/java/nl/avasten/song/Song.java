package nl.avasten.song;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import nl.avasten.Effect;
import nl.avasten.SoundModule;
import nl.avasten.observer.EffectSong;

import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Song {
    @Id
    private String name;
    @Transient
    private EffectSong effectSong;
    @Transient
    private List<Effect> effectList = new ArrayList<>();
    @Transient
    private PropertyChangeSupport support;

    public Song(String name, String lyricsOriginal, SoundModule soundModule) {
        this.effectSong = new EffectSong(lyricsOriginal, soundModule);
        this.name = name;
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
