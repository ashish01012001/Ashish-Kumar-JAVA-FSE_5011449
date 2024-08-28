package Week1.DSA.FinancialForecasting;

public class FinancialForecasting {

    public static double calculateFutureValueRecursive(double presentValue, double growthRate, int periods) {
        if (periods == 0) {
            return presentValue;
        }
        return calculateFutureValueRecursive(presentValue * (1 + growthRate), growthRate, periods - 1);
    }

    public static void main(String[] args) {
        double presentValue = 1000.0;
        double growthRate = 0.05; // 5% growth rate
        int periods = 10; // Forecast for 10 periods

        double futureValue = calculateFutureValueRecursive(presentValue, growthRate, periods);
        System.out.println("Future Value: " + futureValue);
    }
}
