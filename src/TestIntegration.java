public class TestIntegration {
    public static void main(String[] args) {
        Function f = x -> Math.pow(4,x);
        System.out.println(Integration.wzorTrapezow(f,-1,2));
        System.out.println(Integration.wzorSimpsona(f,-1,2));
        System.out.println(Integration.zlozonyWzorTrapezow(f,-1,2,5));
        System.out.println(Integration.zlozonyWzorSimpsona(f,-1,2,2));
        System.out.println(Integration.ekstrapolacjaRichardsona(f,1,0.5,5));
//        System.out.println(Integration.wielomianInterpolacyjny1());
//        System.out.println(Integration.wielomianInterpolacyjny2());
    }
}
