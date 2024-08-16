import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;

public class Main {

    public static void main(String[] args) {

        System.out.format("Scratch Pad using Java version %s%n", getJavaVersion());
        calculateInvoiceUsingDouble();
        System.out.println("=================================");
        calculateInvoiceUsingBigDecimal();

    }

    private static void calculateInvoiceUsingBigDecimal() {
        System.out.println("========= Using BigDecimal ==========");
        BigDecimal total = new BigDecimal("123.45");
        BigDecimal discountPercent = new BigDecimal("0.10");
        BigDecimal discount = total.multiply(discountPercent);
        discount = discount.setScale(2, RoundingMode.HALF_UP);
        BigDecimal beforeTax = total.subtract(discount);
        beforeTax = beforeTax.setScale(2, RoundingMode.HALF_UP);
        BigDecimal salesTaxPercent = new BigDecimal("0.05");
        BigDecimal salesTax = beforeTax.multiply(salesTaxPercent);
        salesTax = salesTax.setScale(2, RoundingMode.HALF_UP);
        BigDecimal result = beforeTax.add(salesTax);
        result = result.setScale(2, RoundingMode.HALF_UP);
        System.out.println("Subtotal: " + total);
        System.out.println("Discount: " + discount);
        System.out.println("SubTotal after discount: " + beforeTax);
        System.out.println("Sales Tax: " + salesTax);
        System.out.println("Total: " + result);
    }

    private static void calculateInvoiceUsingDouble() {
        System.out.println("========= Using BigDecimal ==========");
        double total = 123.45;
        double discount = total * 0.01;
        double beforeTax = total - discount;
        double salesTax = beforeTax * 0.13;
        double result = beforeTax + salesTax;
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
        System.out.println("Subtotal: " + currencyFormat.format(total));
        System.out.println("Discount: " + currencyFormat.format(discount));
        System.out.println("SubTotal after discount: " + currencyFormat.format(beforeTax));
        System.out.println("Sales Tax: " + currencyFormat.format(salesTax));
        System.out.println("Total: " + currencyFormat.format(result));
    }

    /**
     * get the java version that is running the current program
     *
     * @return string containing the java version running the current program
     */
    private static String getJavaVersion() {
        Runtime.Version runTimeVersion = Runtime.version();
        return String.format("%s.%s.%s.%s", runTimeVersion.feature(), runTimeVersion.interim(), runTimeVersion.update(), runTimeVersion.patch());
    }

}
