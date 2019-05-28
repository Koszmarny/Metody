public class FPAtest {
    public static void main(String[] args) {
        System.out.println(FloatingPointArithmetic.cut("3456.789", 10, 6));
        System.out.println(FloatingPointArithmetic.cut("0.0012345", 10, 2));
        System.out.println(FloatingPointArithmetic.cut("123456.7", 10, 3));
        System.out.println(FloatingPointArithmetic.cut("12", 10, 5));
    }
}
