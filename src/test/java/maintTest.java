import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class maintTest {


        GreetMe greetme = new GreetMe();
        @Test
        public void basicTests() {
            //assertEquals(greetme.greet("RILEY"), "Hello Riley!");
            assertEquals("Hello Riley!",greetme.greet("RILEY"));
        }
}
