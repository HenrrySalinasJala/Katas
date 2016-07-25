import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class BankTest {
    private Bank ocr;
    @Before
    public void setUp(){
        ocr=new Bank();
    }
    @Test
    public void testParseStringToNumber1(){
        final String line1=
                " _ "+
                "|_|"+
                "|_|";
        final String expectedNum = "8";
        assertEquals(expectedNum,ocr.parseStringToNumber(line1));
        
    }
    @Test
    public void testParseStringToNumber2(){
        final String line1=
                " _ "+
                "  |"+
                "  |";
        final String expectedNum = "7";
        assertEquals(expectedNum,ocr.parseStringToNumber(line1));
        
    }
    @Test
    public void testReadEntry(){
        final String entry=
                "    _  _     _  _  _  _  _ " +
                "  | _| _||_||_ |_   ||_||_|" +
                "  ||_  _|  | _||_|  ||_| _|" +
                "                           ";
        final String expectedNum = "123456789";
        assertEquals(expectedNum,ocr.readEntry(entry));
        
    }
    @Test
    public void testEntryReadErrorAccount(){
        final String entry=
                "    _  _     _  _  _  _  _ " +
                "  || | _||_||_||_   ||_||_|" +
                "  ||_| _|  ||_||_|  ||_| _|" +
                "                           ";

        final String expectedNum = "103486789 ERR";
        assertEquals(expectedNum,ocr.readEntry(entry));
        
    }
    @Test
    public void testEntryReadUnknow(){
        final String entry=
                "    _  _     _  _  _  _  _ " +
                "  || | _||_||_||_   ||_||_|" +
                "  ||_| _|  ||_|| |  ||_| _|" +
                "                           ";

        final String expectedNum = "10348?789 ILL";
        assertEquals(expectedNum,ocr.readEntry(entry));

    }
    @Test
    public void testEntryReadInvalidAccount(){
        final String entry="345882864";
        final String expectedNum = "345882864 ERR";
        assertEquals(expectedNum,ocr.formatAccountNumbers(entry));

    }
    @Test
    public void testEntryOutputFormat(){
        final String entry="10348?789";
        final String expectedNum = "10348?789 ILL";
        assertEquals(expectedNum,ocr.formatAccountNumbers(entry));

    }
    @Test
    public void testIsValidAccount(){
        final int account=345882865;
        assertTrue(ocr.isValidAccount(account));

    }
    @Test
    public void testIsNotValidAccount(){
        final int account=345882864;
        assertFalse(ocr.isValidAccount(account));
    }
}
