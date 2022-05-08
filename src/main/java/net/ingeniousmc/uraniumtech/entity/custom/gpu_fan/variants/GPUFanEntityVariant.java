package net.ingeniousmc.uraniumtech.entity.custom.gpu_fan.variants;

import java.util.Arrays;
import java.util.Comparator;

public enum GPUFanEntityVariant {
    DEFAULT(0),
    INVERTED(1),
    INVERTED2(2);

    private static final GPUFanEntityVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(GPUFanEntityVariant::getId)).toArray(GPUFanEntityVariant[]::new);
    private final int id;

    GPUFanEntityVariant(int p_30984_) {
        this.id = p_30984_;
    }

    public int getId() {
        return this.id;
    }

    public static GPUFanEntityVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
