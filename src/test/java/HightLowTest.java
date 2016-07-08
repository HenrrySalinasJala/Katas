import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HightLowTest {

    private Examples hightLow;

    @Before
    public void setUp() {
        hightLow = new Examples();
    }

    @Test
    public void testCalculateHightAndLowNumbers0() {
        String expectedDNASide = "5 1";
        assertEquals(expectedDNASide, hightLow.highAndLow("1 2 3 4 5"));
    }

    @Test
    public void testCalculateHightAndLowNumbers1() {
        String expectedDNASide = "9 -5";
        assertEquals(expectedDNASide, hightLow.highAndLow("1 9 3 4 -5"));
    }

    @Test
    public void testCalculateHightAndLowNumbers2() {
        String expectedDNASide = "5 -3";
        assertEquals(expectedDNASide, hightLow.highAndLow("1 2 -3 4 5"));
    }

    @Test
    public void testCalculateHightAndLowNumbers3() {
        String expectedDNASide = "1 1";
        assertEquals(expectedDNASide, hightLow.highAndLow("1 1"));
//        assertEquals("", hightLow.highAndLow("  "));
    }
}
