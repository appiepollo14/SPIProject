package nl.avasten;

@FunctionalInterface
public interface Effect {
    String apply(String song);
}
