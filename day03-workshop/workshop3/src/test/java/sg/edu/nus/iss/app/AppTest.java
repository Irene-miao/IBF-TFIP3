package sg.edu.nus.iss.app;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void CartContainsValue() throws IOException {
        List<String> result = ShoppingCart.getDataFromText("/Users/super/TFIP3/day03-workshop/workshop3/db/anon.cart");
        assertTrue(result.size() > 0);
    }

    @Test
    public void testCartisNotNull() throws IOException {
        List<String> result = ShoppingCart.getDataFromText("/Users/super/TFIP3/day03-workshop/workshop3/db/anon.cart");
        assertTrue(result != null);
    }

}
