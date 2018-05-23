import Pillars.Pillar;
import RollerStackGenerator.Roller;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class PillarTest {
    private Pillar pillar;

    @BeforeMethod
    public void setUp(){
        pillar = new Pillar();
    }

    @Test
    public void addRollers_toEmptyPillars_returnsTrue() {
        assertTrue(pillar.addRoller(new Roller(3)));
    }

    /*@Test
    public void addRollers_toPillarWithRoller3AddRoller4_returnsFalse() {
        pillar.addRoller(new Roller(3));
        assertFalse(pillar.addRoller(new Roller(4)));
    }*/
}
