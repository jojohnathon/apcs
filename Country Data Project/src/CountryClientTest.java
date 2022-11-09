import static org.junit.Assert.*;

import org.junit.Test;

public class CountryClientTest {

    @Test
    public void testMain() {
        fail("Not yet implemented");
    }

    @Test
    public void testMin() {
        double[] values = {}
        
        double actual = CountryClient.min(values);
        double expected = 28.149;
    }
    
    String msg = String.format("For min%s", values);
    assertEquals(msg, expected, actual);

}
