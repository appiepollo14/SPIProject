package nl.avasten.soundEffects;

import nl.avasten.Effect;

public class Distortion implements Effect {

    private static Distortion distortion = null;
    private String soundEffectName;

    private Distortion() {
        this.soundEffectName = "Distortion";
    }

    public String getSoundEffectName() {
        return this.soundEffectName;
    }

    public static Distortion getInstance() {
        if (distortion == null)
            distortion = new Distortion();
        return distortion;
    }

    @Override
    public String apply(String song) {
        return song.replaceAll(" ", "~");
    }

    @Override
    public String toString() {
        return "Distortion{}";
    }
}
