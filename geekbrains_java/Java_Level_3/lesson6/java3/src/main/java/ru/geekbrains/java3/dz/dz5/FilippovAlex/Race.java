package ru.geekbrains.java3.dz.dz5.FilippovAlex;

import java.util.ArrayList;
import java.util.Arrays;

class Race {
    private final ArrayList<Stage> stages;

    public ArrayList<Stage> getStages() { return stages; }

    Race(Stage... stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));
    }
}
