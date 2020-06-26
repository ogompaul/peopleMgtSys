

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class RatioTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class RatioTest
{
    /**
     * Default constructor for test class RatioTest
     */
    public RatioTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void testEquals()
    {
        Ratio one = new Ratio(1,1);
        Ratio alsoOne = new Ratio(2, 2);
        assertEquals(true, alsoOne.equals(one));
    }

  
    @Test
    public void testInverted()
    {
        Ratio ratio1 = new Ratio(2, 4);
        assertEquals(new Ratio(4, 2), ratio1.inverted());
    }

    @Test
    public void testMultiply()
    {
        Ratio ratio1 = new Ratio(3, 5);
        Ratio ratio2 = new Ratio(5, 12);
        assertEquals(new Ratio(1, 4), ratio1.multiply(ratio2));
    }

    @Test
    public void testValue()
    {
        Ratio ratio1 = new Ratio(3, 5);
        assertEquals(0.6, ratio1.doubleValue(), 0.1);
    }
    
     @Test
    public void testNull()
    {
        try
        {
         Ratio ratio1 = new Ratio(3, 0);
        } catch(ArithmeticException e)
        {
          assertTrue(e.getMessage() != null);
        }
        
    }
}









