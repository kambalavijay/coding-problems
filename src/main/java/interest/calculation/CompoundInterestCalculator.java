package interest.calculation;

public class CompoundInterestCalculator {

    private SimpleInterestCalculator simpleInterestCalculator;

    public CompoundInterestCalculator(SimpleInterestCalculator simpleInterestCalculator) {
        this.simpleInterestCalculator = simpleInterestCalculator;
    }

    public double calculateCompoundInterest(Double principle, double rateOfInterest, int months, int intresetCalPeriod){
        int n = months / intresetCalPeriod;
        Double compoundInterest = 0.0;

        for (int i = 0; i < n; i++) {
            Double simpleInterest = simpleInterestCalculator.
                    calculateSimpleInterest(principle, rateOfInterest, intresetCalPeriod);
            principle = principle + simpleInterest;
            compoundInterest = compoundInterest + simpleInterest;
        }
        return compoundInterest;
    }

    public static void main(String[] args) {
        CompoundInterestCalculator c = new CompoundInterestCalculator(new SimpleInterestCalculator());
        c.calculateCompoundInterest(100000.0, 2, 12, 4);
    }
}