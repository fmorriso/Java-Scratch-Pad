import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        System.out.format("Scratch Pad using Java version %s%n", getJavaVersion());

        checkXY(10, 5);

        calculateInvoiceUsingDouble();
        System.out.println("=================================");
        calculateInvoiceUsingBigDecimal();


        print();
        changeVar();
        multDriver();

        suchFun(1, 2, 3);
        suchFun(1, 2, 1);
        suchFun(1, 1, 3);
        suchFun(1, 1, 1);

      System.out.print("Area of triangle 3, 4, 5 is ");
      System.out.println(Formula.findAreaTriangle(3, 4, 5));

      System.out.print("Surface area of pyramid with w=3, len=5, slantH=10 is ");
      System.out.println(Formula.pyramidSA(3, 5, 10));


      System.out.println( new RubberDuck() );
      System.out.println( new RubberDuck("brown") );

      RubberDuck rdg = new RubberDuck("green", 3);
      System.out.println(rdg);
      rdg.squeak(Integer.MAX_VALUE / 3);

    }

    private static void checkXY(int x, int y) {
    /*    if (x > 0 && (y / x) == 3)System.out.println("first case");
        else System.out.println("second case");*/

 /*       if (x == 0 || (y / x) == 3) System.out.println("first case");
        else System.out.println("second case");*/

        if (x % 2 == 0 && y % 2 == 0 || x > y)
        {
            System.out.print("First ");

            if (y * 2 == x || y > 5 && x <= 10)
            {
                System.out.print("Second ");
            }
            else
            {
                System.out.print("Third ");
            }
        }
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

    /*
        A RubberDuck party is successful when the number of jelly beans consumed
        is between 40 and 60, inclusive, unless it is the weekend,
        in which case there is no upper bound on the number of jelly beans.
     */
    public static boolean jellyParty(int n, boolean isWeekend) {
      /*
      return (n >=40 && n <= 60)
          || (isWeekend && n >= 40);
      */

        if (isWeekend) return n >= 40;
        return n >= 40 && n <= 60;

    }

    public static void modParams(int x, String str1, String str2) {
        x++;
        str1 = str1 + "BB";
        str2 = "memory";
    }

    public static void changeVar() {
        int a = 20;
        int b = 3;
        a++;
        b += a;
        System.out.println(a + ", " + b);
    }

    public static int mult(int x) {
        return 4 * x;
    }

    public static void multDriver() {
        int a = 3, b = 2;
        a -= b;
        b = mult(a);
        System.out.println("a = " + a + ", b = " + b);
    }

    public static void suchFun(int a, int b, int c) {
        if (a == b && b == c) {
            System.out.println("boring");
        } else if (a == b || a == c || b == c) {
            System.out.println("twins");
        } else {
            System.out.println("unique");
        }
    }

    public static void print()
    {
        int k = 1;
        String s1 = "AA";
        String s2 = "space";
        modParams(k, s1, s2);
        System.out.println(k + ", " + s1 + ", " + s2);

        // one way to fix this is to have a class to hold and modify the variables:
        Payload p = new Payload(k, s1, s2);
        System.out.println(p);
        p.modParams();
        System.out.println("Using Payload helper class:");
        System.out.println(p);
    }

    public static void mystery(){
        int[ ] arr = {-17,  -14,  3,  9,  21,  34};

        for (int i = 0; i < arr.length / 2; i += 2)
        {
            arr[i] = arr[i]  *  2;
        }

        System.out.println(Arrays.toString(arr));
    }

    private static void array2d() {
        int square = 4;
        int[][] board = new int[square][square];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                System.out.format("board[%d][%d] = %d%n", row, col, board[row][col]);
            }
        }
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
