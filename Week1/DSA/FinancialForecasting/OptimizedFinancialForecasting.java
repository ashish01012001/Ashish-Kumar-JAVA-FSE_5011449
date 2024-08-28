package Week1.DSA.FinancialForecasting;

public class OptimizedFinancialForecasting {

    public static double calculateFutureValueIterative(double presentValue, double growthRate, int periods) {
        double futureValue = presentValue;
        for (int i = 0; i < periods; i++) {
            futureValue *= (1 + growthRate);
        }
        return futureValue;
    }

    public static void main(String[] args) {
        double presentValue = 1000.0;
        double growthRate = 0.05;
        int periods = 10;

        double futureValue = calculateFutureValueIterative(presentValue, growthRate, periods);
        System.out.println("Future Value: " + futureValue);
    }
}
