public class Main {
    public static void main(String[] args) {
        String s = StringAlgorithms.oddOrEven(new int[] {0, -19, -8});

        int x = IntegerAlgorithms.stray(new int[] { 12, 12, 0});

        boolean b = BooleanAlgorithms.validatePin("123323");

        System.out.println("==> " + x);
    }
}
