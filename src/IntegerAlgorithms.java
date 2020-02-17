import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class IntegerAlgorithms {

    /* sum of all the numbers between, including them too */
    public static int GetSum(int a, int b) {
        return IntStream.range(Math.min(a, b), Math.max(a, b) + 1)
                .sum();
    }

    /* How many years does the town need to see its population greater or equal to numOfPopulationToOvercome = 1200 inhabitants? */
    public static int nbYear(int currentPopulation, double percent, int inhabitants, int numOfPopulationToOvercome) {
        int count = 0;
        while (currentPopulation < numOfPopulationToOvercome) {
            currentPopulation = currentPopulation + (int) (currentPopulation * percent / 100) + inhabitants;
            count++;
        }
        return count;
    }

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


    /*Calculate how many years it will take to make `desired` money
      Let P be the Principal = 1000.00
      Let I be the Interest Rate = 0.05
      Let T be the Tax Rate = 0.18
      Let D be the Desired Sum = 1100.00

      After 1st Year -->  P = 1041.00
      After 2nd Year -->  P = 1083.86
      After 3rd Year -->  P = 1128.30
     */

    public static int calculateYears(double principal, double interest, double tax, double desired) {
        int numOfYears = 0;
        while (desired > principal) {
            principal += (principal * interest) - (principal * interest * tax);
            numOfYears++;
        }
        return numOfYears;
    }

    /*
    [0, 0, 0, 1] ==> 1
    [0, 1, 0, 1] ==> 5
    [1, 0, 0, 1] ==> 9
     */
    public static int ConvertBinaryArrayToInt(List<Integer> binary) {
        int x = 0;

        for (int i = binary.size() - 1; i >= 0; i--) {
            if (binary.get(i) == 1) {
                x += Math.pow(2, binary.size() - 1 - i);
            }
        }

        return x;
//        return binary.stream().reduce((a, b) -> a * 2 + b).get();

    }



    /*
    1,9 -> 1,2,3,4,6,7,8,9 -> Result 8
    4,17 -> 4,6,7,8,9,10,11,12,13,14,16,17 -> Result 12
     */
    public static int dontGiveMeFive(int start, int end) {
        int count = 0;

        while (start <= end) {
            start++;
            count += (start == 5) ? 0 : 1;

            System.out.println(count);
        }
        return count;
    }
}
