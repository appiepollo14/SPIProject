package nl.avasten.effectLoader;

import nl.avasten.Effect;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

public class EffectLoader {

    public static List<Effect> providers() {
        List<Effect> effects = new ArrayList<>();
        ServiceLoader<Effect> loader = ServiceLoader.load(Effect.class);
        loader.forEach(effect -> {
            effects.add(effect);
        });
        System.out.println(effects.size());
        return effects;
    }
}
