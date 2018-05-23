import Pillars.Pillar;
import RollerStackGenerator.Roller;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class PillarTest {
    private Roller rollerSize3, rollerSize4;
    private Pillar pillar;

    @BeforeMethod
    public void setUp(){
        pillar = new Pillar();
        rollerSize3 = new Roller(3);
        rollerSize4 = new Roller(4);
    }

    @Test
    public void addRollers_toEmptyPillars_returnsTrue() {
        assertTrue(pillar.addRoller(rollerSize3));
    }

    @Test
    public void addRollers_toPillarWithRoller3AddRoller4_returnsFalse() {
        pillar.addRoller(rollerSize3);
        assertFalse(pillar.addRoller(rollerSize4));
    }

    @Test
    public void addRollers_toPillarWithRoller4AddRoller3_returnsTrue() {
        pillar.addRoller(rollerSize4);
        assertTrue(pillar.addRoller(rollerSize3));
    }
}
