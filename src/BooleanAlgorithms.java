public class BooleanAlgorithms {

    /* You're a square! */
    public static boolean isSquare(int n) {
        return Math.sqrt(n) % 1 == 0;
    }

    /* see if a string has the same amount of 'x's and 'o's. */
    public static boolean getXO (String str) {
       str = str.toLowerCase();
       return str.replace("o", "").length() == str.replace("x", "").length();
    }

}
