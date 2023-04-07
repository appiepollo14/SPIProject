package nl.avasten.observer;

import nl.avasten.Effect;
import nl.avasten.SoundModule;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

public class EffectSong implements PropertyChangeListener {

    private String lyricsOriginal;
    private String lyricsAfterEffect;

    private final SoundModule soundModule;

    public void propertyChange(PropertyChangeEvent evt) {
        this.setLyricsAfterEffect((List) evt.getNewValue());
    }

    public EffectSong(String lyricsOriginal, SoundModule soundModule) {
        this.lyricsOriginal = lyricsOriginal;
        this.soundModule = soundModule;
    }

    public String getLyricsAfterEffect() {
        return this.lyricsAfterEffect;
    }

    public String getLyricsOriginal() {
        return this.lyricsOriginal;
    }

    public void setLyricsAfterEffect(List<Effect> effectListAfterChange) {

        String lyricsAfterEffect2 = lyricsOriginal;

        for (Effect e : effectListAfterChange) {
            lyricsAfterEffect2 = e.apply(lyricsAfterEffect2);
        }

        this.lyricsAfterEffect = lyricsAfterEffect2;

        System.out.println("Liedje na toevoeging effect:");
        System.out.println(this.lyricsAfterEffect);
        this.soundModule.getGui().setTextpane(this.lyricsAfterEffect);
    }

    public void setLyricsOriginal(String lyricsOriginal) {
        this.lyricsOriginal = lyricsOriginal;
    }
}
