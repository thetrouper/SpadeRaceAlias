package io.github.thetrouper.spaderacealias.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Randomizer<T> {

    private final List<T> array;

    public Randomizer(Collection<T> array) {
        this.array = new ArrayList<>(array);
    }

    public Randomizer(T[] array) {
        this.array = Arrays.asList(array);
    }

    public T pickRand() {
        return array.get(rand(array.size()));
    }

    public int rand(int max) {
        return (int)(Math.random() * max);
    }

    public int rand(int min, int max) {
        if (max <= min) throw new IllegalArgumentException("Failed to Generate!");
        return min + rand(max - min);
    }
}