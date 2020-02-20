import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String s = StringAlgorithms.oddOrEven(new int[] {0, -19, -8});
        String[] s1 = new String[]{};
        String[] s2 = new String[]{"cccooommaaqqoxii", "gggqaffhhh", "tttoowwwmmww"};

        int x = IntegerAlgorithms.mxdiflg(s1, s2);

        boolean b = BooleanAlgorithms.validatePin("123323");

        System.out.println("==> " + x);
    }
}
