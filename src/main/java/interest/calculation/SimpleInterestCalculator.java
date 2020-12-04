package interest.calculation;

public class SimpleInterestCalculator {

    public double calculateSimpleInterest(Double principle, double rateOfInterest, int months){
        return ( principle * rateOfInterest * months ) / 100;
    }
}
