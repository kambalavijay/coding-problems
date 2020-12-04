package interest.calculation.mockito;

import interest.calculation.SimpleInterestCalculator;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


public class SimpleInterestCalculatorTest {

    private static SimpleInterestCalculator simpleInterestCalculator;

    @BeforeClass
    public static void setupBeforeClass(){
        simpleInterestCalculator = new SimpleInterestCalculator();
    }

    @Test
    public void testSimpleInterestCalculation(){
        Double interest = simpleInterestCalculator.
                calculateSimpleInterest(100000.0, 2.0, 1);
        Double actual  = 2000.0;
        Assert.assertEquals("Invalid interest calculated", actual.toString(), interest.toString());
    }

    @Test
    public void testSimpleInterestCalculation1(){
        Double interest = simpleInterestCalculator.
                calculateSimpleInterest(50000.0, 2.0, 1);
        Double actual  = 1000.0;
        Assert.assertEquals("Invalid interest calculated", actual.toString(), interest.toString());
    }
}
