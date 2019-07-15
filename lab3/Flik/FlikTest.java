import static org.junit.Assert.*;

import org.junit.Test;

public class FlikTest {
    @Test
    public void testisSameNumber(){
        int a = 8848;
        int b = 8848;
        int c = 4484;
        boolean ans0 = Flik.isSameNumber(a, b);
        boolean ans1 = Flik.isSameNumber(a, c);
        assertTrue(ans0);
        assertFalse(ans1);
    }
}
