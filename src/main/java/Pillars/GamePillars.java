package Pillars;

import RollerStackGenerator.RollersStackGenerator;

import java.util.ArrayList;
import java.util.List;

public class GamePillars {
    private List<Pillar> pillars = new ArrayList<>(3);

    public GamePillars(RollersStackGenerator rollersStackGenerator) {
        initPillars();
        //pillars.get(0).addRoller(rollersStackGenerator.generate());
    }

    private void initPillars() {
        pillars.add(new Pillar());
        pillars.add(new Pillar());
        pillars.add(new Pillar());
    }


}
