import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Define exchange rates
        Map<String, Double> exchangeRates = new HashMap<>();
        exchangeRates.put("USD", 1.0); // 1 USD = 1 USD
        exchangeRates.put("INR", 74.0); // 1 USD = 74 INR (Example rate)
        exchangeRates.put("EUR", 0.85); // 1 USD = 0.85 EUR (Example rate)

        // Prompt the user to choose the base currency
        System.out.print("Enter the base currency (USD, INR, EUR): ");
        String baseCurrency = scanner.nextLine().toUpperCase();

        // Prompt the user to choose the target currency
        System.out.print("Enter the target currency (USD, INR, EUR): ");
        String targetCurrency = scanner.nextLine().toUpperCase();

        // Prompt the user to enter the amount to convert
        System.out.print("Enter the amount to convert: ");
        double amount = scanner.nextDouble();

        // Fetch exchange rate
        double exchangeRate = getExchangeRate(baseCurrency, targetCurrency, exchangeRates);
        if (exchangeRate == -1) {
            System.out.println("Failed to fetch exchange rate. Please try again later.");
            return;
        }

        // Convert currency
        double convertedAmount = amount * exchangeRate;

        // Display result
        System.out.printf("%.2f %s = %.2f %s\n", amount, baseCurrency, convertedAmount, targetCurrency);
    }

    private static double getExchangeRate(String baseCurrency, String targetCurrency, Map<String, Double> exchangeRates) {
        // Check if exchange rates are available for both currencies
        if (exchangeRates.containsKey(baseCurrency) && exchangeRates.containsKey(targetCurrency)) {
            double baseRate = exchangeRates.get(baseCurrency);
            double targetRate = exchangeRates.get(targetCurrency);
            return targetRate / baseRate;
        } else {
            return -1; // Indicates failure
        }
    }
}
