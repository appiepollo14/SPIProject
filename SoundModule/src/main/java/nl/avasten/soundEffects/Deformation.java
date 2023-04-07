package nl.avasten.soundEffects;

import nl.avasten.Effect;

import java.util.Random;

public class Deformation implements Effect {
    Random random = new Random();

    private static Deformation deformation = null;
    private String soundEffectName;

    private Deformation() {
        this.soundEffectName = "Deformation";
    }

    public String getSoundEffectName() {
        return this.soundEffectName;
    }

    public static Deformation getInstance() {
        if (deformation == null)
            deformation = new Deformation();
        return deformation;
    }

    @Override
    public String apply(String song) {
        StringBuilder stringBuilder = new StringBuilder(song);
        for (int i = 0; i < (song.length() / 2); i++) {
            int randomInt = random.nextInt(song.length());
            stringBuilder.setCharAt(randomInt, Character.toUpperCase(stringBuilder.charAt(randomInt)));
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return "Deformation{}";
    }
}
