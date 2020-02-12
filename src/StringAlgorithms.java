import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

public class StringAlgorithms {
    public static String getMiddle(String word) {

//        int len = word.length();
//        if (len % 2 == 0) {
//            return word.split("")[len / 2 - 1] + word.split("")[len / 2];
//        } else {
//            return word.split("")[len / 2];
//        }

        int len = word.length();
        int half = len / 2;

        if (len % 2 == 0) {
            return word.substring(half - 1, half + 1);
        } else {
            return word.substring(half, half + 1);
        }
    }


/* have to return the highest and lowest number. */
/* highAndLow("1 2 3 4 5 -3")  // return "5 -3" */

    public static String highAndLow(String numbers) {
//        String[] arr = numbers.split(" ");
//        int[] arr2 = new int[arr.length];
//        for (int i = 0; i < arr.length; i++) {
//            arr2[i] = Integer.parseInt(arr[i]);
//        }
//        Arrays.sort(arr2);
//
//        return arr2[arr2.length - 1] + " " + arr2[0];

        IntSummaryStatistics summary = Arrays
                .stream(numbers.split(" "))
                .mapToInt(Integer::parseInt)
                .summaryStatistics();
        return String.format("%d %d", summary.getMax(), summary.getMin());

    }

    /* symbols "A" and "T" are complements of each other, as "C" and "G". */
    public static String makeComplement(String dna) {
//        String[] s = dna.split("");
//        String[] s2 = new String[s.length];
//        for (int i = 0; i < s.length; i++) {
//            if (s[i].contains("A")) s2[i] = "T";
//            if (s[i].contains("T")) s2[i] = "A";
//            if (s[i].contains("G")) s2[i] = "C";
//            if (s[i].contains("C")) s2[i] = "G";
//        }
//        return String.join("", s2);

        return dna
                .replace("A", "Z")
                .replace("T", "A")
                .replace("Z", "T")
                .replace("G", "Z")
                .replace("C", "G")
                .replace("Z", "C");
    }

    /*
    return sorted string without duplicates
    a = "xyaabbbccccdefww"
    b = "xxxxyyyyabklmopq"
    longest(a, b) -> "abcdefklmopqwxy"
    */
    public static String longest (String s1, String s2) {
//        char[] charArr = (s1 + s2).toCharArray();
//        Arrays.sort(charArr);
//
//        int resIndex = 1, currIndex = 1;
//        while (currIndex != charArr.length) {
//            if (charArr[currIndex] != charArr[currIndex - 1]) {
//                charArr[resIndex] = charArr[currIndex];
//                resIndex++;
//            }
//            currIndex++;
//        }
//        return String.valueOf(charArr).substring(0, resIndex);

        String str = s1 + s2, out = "";

        for (char ch='a'; ch <= 'z'; ch++) {
            if (str.contains(ch + "")) {
                out += ch;
                str.lastIndexOf(ch);
            }
        }
        return out;

    }



    /*
    print error if 's' is not between 'a-m'
    s="aaaxbbbbyyhwawiwjjjwwm"
    error_printer(s) => "8/22"
    */

    public static String printerError(String s) {
//        char[] arr = s.toCharArray();
//        Arrays.sort(arr);
//        String str = String.valueOf(arr);
//        int ind = -1;
//        for (char ch='n'; ch <= 'z'; ch++) {
//            if (str.contains(ch + "")) {
//                ind = str.indexOf(ch);
//                break;
//            }
//        }
//        return ind >= 0 ? "" + str.substring(ind).length() + "/" + str.length() : "0/"+str.length();

        return s.replaceAll("[a-m]", "").length() + "/" + s.length();
    }
}
