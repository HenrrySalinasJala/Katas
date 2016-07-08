import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class BankTest {
    
    @Test
    public void testParseTxtumbersToString(){
        String line1=" _ "+
                "|_|"+
                "|_|";
        Bank ocr=new Bank();
        assertEquals(8,ocr.parseStringToNumber(line1));
        
    }
    @Test
    public void testParseTxt(){
        String line1=" _ "+
                "  |"+
                "  |";
        Bank ocr=new Bank();
        assertEquals(7,ocr.parseStringToNumber(line1));
        
    }
    @Test
    public void testEntryNumber(){
        String entry="    _  _     _  _  _  _  _ " +
                     "  | _| _||_||_ |_   ||_||_|" +
                     "  ||_  _|  | _||_|  ||_| _|"+
                     "                           ";
        
        Bank ocr=new Bank();
        assertEquals(123456789,ocr.readEntry(entry));
        
    }
    @Test
    public void testEntryRead(){
        String entry="    _  _     _  _  _  _  _ " +
                     "  || | _||_||_||_   ||_||_|" +
                     "  ||_| _|  ||_||_|  ||_| _|"+
                     "                           ";
        
        Bank ocr=new Bank();
        assertEquals(103486789,ocr.readEntry(entry));
        
    }
    @Test
    public void testIsValidAccount(){
        int account=345882865;
        Bank ocr=new Bank();
        assertTrue(ocr.isValidAccount(account));
        assertFalse(ocr.isValidAccount(345882864));
    }
}
