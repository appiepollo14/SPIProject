package nl.avasten;

public class Distortion implements Effect {

    private static Distortion distortion = null;

    private Distortion() {
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
