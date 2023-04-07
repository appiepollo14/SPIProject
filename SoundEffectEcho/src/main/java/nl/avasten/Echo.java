package nl.avasten;

public class Echo implements Effect {

    @Override
    public String getSoundEffectName() {
        return "Echo";
    }

    @Override
    public String apply(String song) {
        return "test";
    }
}
