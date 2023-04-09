package nl.avasten;

public class Echo implements Effect {

    @Override
    public String getSoundEffectName() {
        return "Echo";
    }

    @Override
    public String apply(String song) {
        StringBuilder result = new StringBuilder();
        int length = song.length();
        for (int i = length; i > 0; i -= 5) {
            String substr = song.substring(length - i);
            result.append(substr).append(" ");
        }
        return result.toString().trim();
    }
}
