public class BooleanAlgorithms {

    /* a word with no repeating letters  return true*/
    public static boolean  isIsogram(String str) {
        if (str.length() == 0) return true;
        String[] arr = str.toLowerCase().split("");
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[j].matches(arr[i])) {
                    count++;
                }
            }
        }

        return count == str.length();

    }

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
