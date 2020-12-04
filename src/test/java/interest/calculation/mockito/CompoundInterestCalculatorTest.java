package interest.calculation.mockito;

import interest.calculation.CompoundInterestCalculator;
import interest.calculation.SimpleInterestCalculator;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.Silent.class)
public class CompoundInterestCalculatorTest {

    private static CompoundInterestCalculator compoundInterestCalculator;
    private static SimpleInterestCalculator simpleInterestCalculator;

    @BeforeClass
    public static void setupBeforeClass(){
        simpleInterestCalculator = mock(SimpleInterestCalculator.class);
        compoundInterestCalculator = new CompoundInterestCalculator(simpleInterestCalculator);
    }

    @Test
    public void testCompoundInterestCalculation(){


        Mockito.when(simpleInterestCalculator.calculateSimpleInterest(100000.0, 2.0, 4)).
                thenReturn(8000.0);
        Mockito.when(simpleInterestCalculator.calculateSimpleInterest(108000.0, 2.0, 4)).
                thenReturn(8640.0);
        Mockito.when(simpleInterestCalculator.calculateSimpleInterest(116640.0, 2.0, 4)).
                thenReturn(9331.2);


        Double interest = compoundInterestCalculator.
                calculateCompoundInterest(100000.0, 2.0, 12, 4);
        Double actual  = 25971.2;
        Assert.assertEquals("Invalid interest calculated", interest.toString(), actual.toString());
    }
}
