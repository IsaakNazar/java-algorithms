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


/*
ATM machines allow 4 or 6 digit PIN codes and PIN codes cannot contain anything but exactly 4 digits or exactly 6 digits.
 */
    public static boolean validatePin(String pin) {
//        return pin.matches("[0-9]+") && (pin.length() == 4 || pin.length() == 6);
        return pin.matches("\\d{4}|\\d{6}");
    }

}
