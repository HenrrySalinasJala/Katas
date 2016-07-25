import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Administrator on 7/6/2016.
 */
public class DnaTest {
    private Examples dna;
    @Before
    public void setUp(){
        dna = new Examples();
    }
    @Test
    public void testCompleteDNA(){
        String expectedDNASide="TAACG";
        assertEquals(expectedDNASide,dna.makeComplement("ATTGC"));
    }
    @Test
    public void testCompleteDNA2(){
        String expectedDNASide="CATA";
        assertEquals(expectedDNASide,dna.makeComplement("GTAT"));
        assertEquals("WWWW",dna.makeComplement("WWWW"));
    }

}
