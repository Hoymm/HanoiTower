import RollerStackGenerator.Rollers.Roller;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class RollerTest {
    private Roller rollerSize3, rollerSize4;

    @BeforeMethod
    public void setUp(){
        rollerSize3 = new Roller(3);
        rollerSize4 = new Roller(4);
    }

    @Test
    public void isSmallerThan_rollerSize3_than_rollerStize4_returnsTrue() {
        assertTrue(rollerSize3.isSmallerThan(rollerSize4));
    }

    @Test
    public void isSmallerThan_rollerSize4_than_rollerStize4_returnsFalse() {
        assertFalse(rollerSize4.isSmallerThan(rollerSize4));
    }

    @Test
    public void isSmallerThan_rollerSize4_than_rollerStize3_returnsFalse() {
        assertFalse(rollerSize4.isSmallerThan(rollerSize3));
    }

}
