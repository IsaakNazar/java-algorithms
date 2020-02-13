import java.util.Arrays;

public class IntegerAlgorithms {

    /* return the length of the shortest word(s) */

    public static int findShort(String s) {
//        IntSummaryStatistics summary = Arrays
//                .stream(s.split(" "))
//                .mapToInt(String::length)
//                .summaryStatistics();
//        return summary.getMin();

        return Arrays.stream(s.split(" "))
                .mapToInt(String::length)
                .min()
                .getAsInt();
    }

    /* square every digit of a number. */
    public static int squareDigits(int n) {
//        String[] s = String.valueOf(n).split("");
//        String s2 = "";
//        for (String str : s) {
//            s2 += (int) Math.pow(Integer.parseInt(str), 2);
//        }
//        return Integer.parseInt(s2);

        String result = "";

        while (n != 0) {
            int digit = n % 10;
            result = digit * digit + result;
            n /= 10;
        }
        return Integer.parseInt(result);
    }

    /*
        1
       3 5
      7 9 11
    13 15 17 19
    rowSumOddNumbers(1); // 1
    rowSumOddNumbers(2); // 3 + 5 = 8
     */
    public static int rowSumOddNumbers(int n) {
//        int num = factorial(n) * 2 - 1;
//        int res = 0;
//        while(n > 0) {
//            res += num;
//            num = num - 2;
//            n--;
//        }
//        return res;

        return n * n * n;
    }

    public static int factorial(int n) {
        int x = 0;
        for (int i = 1; i <= n; i++) {
            x += i;
        }
        return x;
    }


    /*
    finds the next integral perfect square
    findNextSquare(625) --> returns 676
    findNextSquare(114) --> returns -1
     */
    public static long findNextSquare(long sq) {
        double sqr = Math.sqrt(sq);
        return sqr % 1 == 0 ? (long) Math.pow(sqr + 1, 2) : -1;
    }
}
