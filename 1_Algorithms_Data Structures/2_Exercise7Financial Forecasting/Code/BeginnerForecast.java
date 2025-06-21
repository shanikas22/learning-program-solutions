public class BeginnerForecast {

    public static int forecast(int amount, int years) {
        if (years == 0) {
            return amount;  // stop when years reach 0
        }

        return forecast(amount + 1000, years - 1);  // add ₹1000 per year
    }

    public static void main(String[] args) {
        int start = 10000;
        int years = 3;

        int result = forecast(start, years);
        System.out.println("Future Value = ₹" + result);
    }
}
