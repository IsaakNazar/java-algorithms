import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

class Fighter {
    public String name;
    public int health, damagePerAttack;

    public Fighter(String name, int health, int damagePerAttack) {
        this.name = name;
        this.health = health;
        this.damagePerAttack = damagePerAttack;
    }
}

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


    /* *********************************
    return sorted string without duplicates
    a = "xyaabbbccccdefww"
    b = "xxxxyyyyabklmopq"
    longest(a, b) -> "abcdefklmopqwxy"
    */
    public static String longest(String s1, String s2) {
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

        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (str.contains(ch + "")) {
                out += ch;
                str.lastIndexOf(ch);
            }
        }
        return out;

    }



    /* ********* ********* ********* *********
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

    /* ********* ********* ********* ********* ********* ********* ********* *********
    remove all vowel occurrences from string */
    public static String disemvowel(String str) {
        return str.replaceAll("[aeiouAEIOU]", "");
    }

    /* capitalize */
    public static String toCapitalizeCase(String phrase) {
        if (phrase == null || phrase.equals("")) return null;
//    String[] str = phrase.split(" ");
//    String[] str2 = new String[str.length];
//    for (int i = 0; i < str.length; i++) {
//      str2[i] = str[i].substring(0, 1).toUpperCase() + str[i].substring(1);
//    }
//    return String.join(" ", str2);
        char[] array = phrase.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (i == 0 || array[i - 1] == ' ') {
                array[i] = Character.toUpperCase(array[i]);
            }
        }
        return new String(array);
    }

    /* ********* ********* ********* ********* ********* ********* *********
    change all but the last four characters into '#'
    */
    public static String maskify(String str) {
        if (str.length() < 5) return str;

        return str.substring(0, str.length() - 4).replaceAll(".", "#") +
                str.substring(str.length() - 4);
    }


    /*
    return the sum of following series upto nth term(parameter).
    Series: 1 + 1/4 + 1/7 + 1/10 + 1/13 + 1/16 +...
    SeriesSum(5) => 1 + 1/4 + 1/7 + 1/10 + 1/13 = "1.57"
     */

    public static String SeriesSum(int n) {
        double x = 1;
        double denom = 4;
        while (n > 1) {
            x += (1 / denom);
            denom += 3;
            n--;
        }
        return x > 1 ? String.format("%.2f", Math.round(x * 100.0) / 100.0) : n + ".00";
    }


    /* Declare winner */


    public static String declareWinner(Fighter first, Fighter second, String firstAttacker) {
        Fighter a = first, b = second;
        if (firstAttacker.equals(second.name)) {
            a = second;
            b = first;
        }
        while (true) {
            if ((b.health -= a.damagePerAttack) <= 0) return a.name; //a wins
            if ((a.health -= b.damagePerAttack) <= 0) return b.name;  // b wins
        }
    }



    /*
    Given a list of numbers, determine whether the sum of its elements is odd or even.
    odd_or_even([0])          ==  "even"
    odd_or_even([0, 1, 4])    ==  "odd"
    odd_or_even([0, -1, -5])  ==  "even"
     */
    public static String oddOrEven (int[] array) {
       return Arrays.stream(array).sum() % 2 == 0 ? "Even" : "Odd";
    }


    /*
    number(Arrays.asList()) # => []
    number(Arrays.asList("a", "b", "c")) // => ["1: a", "2: b", "3: c"]
    */

    public static List<String> number(List<String> lines) {

        List<String> newList = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            newList.add(i+1 + ": " + lines.get(i));
        }
        return newList;
    }

    /*
    remove duplicates
    Input:
    'alpha beta beta gamma gamma gamma delta alpha beta beta gamma gamma gamma delta'
    Output:
    'alpha beta gamma delta'
     */

    public static String removeDuplicateWords(String s){
        return Arrays.stream(s.split(" ")).distinct().collect(Collectors.joining(" "));
    }


    /*
    addLetters("a", "b", "c") = "f"
    addLetters("a", "b") = "c"
    addLetters("z") = "z"
     */

    public static String addLetters(String... letters) {
//        String s = "";
//        if (letters.length == 0) return "z";
//        for (char i = 'a'; i <= 'z'; i++) {
//            s += i;
//        }
//
//        char[] ch = s.toCharArray();
//        int sum = 0;
//        String theLetter = "";
//        for (int i = 0; i < ch.length; i++) {
//            for (String letter : letters) {
//                if (String.valueOf(ch[i]).equals(letter)) {
//                    sum += i+1;
//                }
//            }
//            theLetter = String.valueOf(ch[Math.abs((sum-1)%26)]);
//        }
//        return theLetter;

        if(letters.length == 0){
            return "z";
        }
        int sum = 0;

        for(int i = 0;i < letters.length; i++){
            sum += letters[i].charAt(0)%96;
        }
        if(sum > 26) sum = sum%26;
        if(sum < 1) sum = 26;
        return String.valueOf((char) (sum+96));
    }


    /*
    a = ["az", "toto", "picaro", "zone", "kiwi"] -->
    [
        ["az", "toto picaro zone kiwi"],
        ["az toto", "picaro zone kiwi"],
        ["az toto picaro", "zone kiwi"],
        ["az toto picaro zone", "kiwi"]
    ]
     */
//    public static String[][] partlist(String[] arr) {
//        // your code
//    }



    /*  ************    ************    *************

    make as few changes as possible.
    if the string contains equal number of uppercase and lowercase letters, convert the string to lowercase.
    solve("coDe") = "code". Lowercase characters > uppercase. Change only the "D" to lowercase.
    solve("CODe") = "CODE". Uppercase characters > lowercase. Change only the "e" to uppercase.
    solve("coDE") = "code". Upper == lowercase. Change all to lowercase.
     */
    public static String solve(final String str) {
//        char[] ch = str.toCharArray();
//        int count = 0;
//        for (int i = 0; i < ch.length; i++) {
//            if ((int)ch[i] > 96 && (int)ch[i] < 123) {
//                count++;
//                System.out.println(ch[i]);
//            }
//        }
//        return (double)str.length()/2 <= count ? str.toLowerCase() : str.toUpperCase();

        return str.chars().filter(Character::isLowerCase).count() < str.chars().filter(Character::isUpperCase).count()
                ? str.toUpperCase()
                : str.toLowerCase();
    }


    /*
    recursive reverse string
     */
    public static String reverse(String str) {
        return str.length() <= 1
                ? str
                : str.substring(str.length()-1) + reverse(str.substring(0,str.length()-1));
    }


}


