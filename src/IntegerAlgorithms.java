import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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

    /* ******* *********** ********** ************ *************** ************* *********/

    /*
    finds the next integral perfect square
    findNextSquare(625) --> returns 676
    findNextSquare(114) --> returns -1
     */
    public static long findNextSquare(long sq) {
        double sqr = Math.sqrt(sq);
        return sqr % 1 == 0 ? (long) Math.pow(sqr + 1, 2) : -1;
    }

    /* ******* *********** ********** ************ *************** ************* *********/

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


    /* ******* *********** ********** ************ *************** ************* *********/


    /*
    1,9 -> 1,2,3,4,6,7,8,9 -> Result 8
    4,17 -> 4,6,7,8,9,10,11,12,13,14,16,17 -> Result 12
     */
    public static int dontGiveMeFive(int start, int end) {
        int count = 0;

        while (start <= end) {
            if (!hasFive(start)) {
                count++;
            }
            start++;
        }
        return count;
    }

    public static boolean hasFive(int number) {
        while (number > 0) {
            if (number % 10 == 5) {
                return true;
            } else {
                number /= 10;
            }
        }
        return false;
    }

    /* ******* *********** ********** ************ *************** ************* *********/

    /*
    [ [10,0],[3,5],[5,8] ]  returns 5
    [ [3,0],[9,1],[4,10],[12,2],[6,1],[7,10] ] returns 17
     */
    public static int countPassengers(ArrayList<int[]> stops) {

//        int sum = 0;
//        for (int[] x : stops) {
//            sum += x[0] - x[1];
//        }
//        return sum;

        return stops.stream().mapToInt(x -> x[0] - x[1]).sum();
    }

    /* ******* *********** ********** ************ *************** ************* *********/

    /*
    Complete the method which accepts such an array, and returns that single different number.
    [1, 1, 2] ==> 2
    [17, 17, 3, 17, 17, 17, 17] ==> 3
     */

    static int stray(int[] numbers) {
//        Arrays.sort(numbers);
//        return numbers[1] == numbers[0] ? numbers[numbers.length-1] : numbers[0];

        if (numbers[0] != numbers[1] && numbers[0] != numbers[2]) return numbers[0];
        for (int i : numbers) if (i != numbers[0]) return i;
        return 0;
    }


    /*
    MinMax.minMax(new int[]{1,2,3,4,5}) == {1,5}
    MinMax.minMax(new int[]{2334454,5}) == {5, 2334454}
    MinMax.minMax(new int[]{1}) == {1, 1}
     */

    public static int[] minMax(int[] arr) {
        // Your awesome code here
        IntSummaryStatistics summary = Arrays
                .stream(arr)
                .summaryStatistics();
        return new int[]{summary.getMin(), summary.getMax()};
    }

    /* ******* *********** ********** ************ *************** ************* *********/

    /*
    You are given two arrays a1 and a2 of strings. Each string is composed with letters from a to z.
    Let x be any string in the first array and y be any string in the second array.

    Find max(abs(length(x) − length(y)))
     */
    public static int mxdiflg(String[] a1, String[] a2) {
        if (a1.length == 0 || a2.length == 0) return -1;
        int res1 = Math.abs(findMinMax(a1)[0] - findMinMax(a2)[1]);
        int res2 = Math.abs(findMinMax(a1)[1] - findMinMax(a2)[0]);
        return Math.max(res1, res2);
    }

    public static int[] findMinMax(String[] a) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (String s : a) {
            if (max < s.length()) max = s.length();
            if (min > s.length()) min = s.length();
        }
        return new int[]{min, max};
    }

    /* ******* *********** ********** ************ *************** ************* *********/


    /*
    56789. Rotate left, you get 67895.
    Keep the first digit in place and rotate left the other digits: 68957.
    Keep the first two digits in place and rotate the other ones: 68579.
    56789 -> 67895 -> 68957 -> 68579 -> 68597
    and you must return the greatest: 68957.
     */
    public static long maxRot(long n) {
//        long max = n;
//        for (int i = 0; i < str.length()-1; i++) {
//            String s = str.substring(i, i+1);
//            str = str.replace(str.substring(i, i+1), "") + s;
//            max = Math.max(max, Long.parseLong(str));
//            System.out.println(str);
//        }
//
//        return max;
        String num = String.valueOf(n);

        for (int i = 0; i < num.length() - 1; i++) {
            num = num.substring(0, i) +
                    num.substring(i + 1) +
                    num.charAt(i);

            if (Long.parseLong(num) > n) {
                n = Long.parseLong(num);
            }
        }

        return n;
    }


    /*
    Write a function to calculate factorial for a given input.
    If input is below 0 or above 12 throw an exception of type IllegalArgumentException
     */
    public static int factorialN(int n) {
//        int acc = 1;
//        if (n < 0 || n > 12) {
//            throw new IllegalArgumentException("Factorial Exception");
//        }
//        if (n == 0) return 1;
//        int i = 1;
//        while (i <= n) {
//            acc *= i;
//            i++;
//        }
//        return acc;

        if(n < 0 || n > 12) throw new IllegalArgumentException("Useless fuffery!");
        return n <= 1 ? 1 : n * factorialN(n - 1);
    }


    /* ********* ********* ********* *********
    Find the number with the most digits.
    If two numbers in the argument array have the same number of digits, return the first one in the array.
     */

    public static int findLongest(int[] numbers) {
//        int max = 0;
//        int res = 0;
//        for (int i = 0; i < numbers.length; i++) {
//            int abs = Math.abs(numbers[i]);
//            if (String.valueOf(abs).length() > max) {
//                max = String.valueOf(abs).length();
//                res = numbers[i];
//            }
//
//        }
//        return res;

        int index = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (String.valueOf(Math.abs(numbers[i])).length() > String.valueOf(Math.abs(numbers[index])).length()) {
                index = i;
            }
        }
        return numbers[index];
    }


    /*
    Given a list of digits, return the smallest number that could be formed from these digits,
    using the digits only once (ignore duplicates).
    minValue ({1, 3, 1})  ==>  (13)
    minValue({5, 7, 5, 9, 7})  ==>  (579)
     */

    public static int minValue(int[] values){

//        return Integer.parseInt(Arrays.stream(values)
//                .distinct()
//                .sorted()
//                .mapToObj(String::valueOf)
//                .reduce("", (a,b) -> a + b));

        return Arrays.stream(values)
                .distinct()
                .sorted()
                .reduce(0, (a, b) -> 10 * a + b);
    }

    /*
    Flatten 2 dim array and sort
     */
    public static int[] flattenAndSort(int[][] array) {
        IntStream stream = Stream.of(array).flatMapToInt(Arrays::stream).sorted();
        return stream.toArray();
    }


    /*
    Given a number, write a function to output its reverse digits. (e.g. given 123 the answer is 321)

    Numbers should preserve their sign; i.e. a negative number should still be negative when reversed.

     123 ->  321
    -456 -> -654
    1000 ->    1
     */

    public static int reverse(int number) {
//        int reversed = Integer.parseInt(StringAlgorithms.reverse(String.valueOf(Math.abs(number))));
//        return number > 0 ? reversed : -reversed;

        return number < 0 ? -reverse(-number) : Integer.parseInt(new StringBuilder().append(number).reverse().toString());
    }

}
