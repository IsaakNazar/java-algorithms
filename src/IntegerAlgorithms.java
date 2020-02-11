import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.stream.Stream;

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
}
