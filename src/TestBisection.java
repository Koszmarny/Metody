public class TestBisection {
    public static void main(String[] args) {
        Function f = x -> x * x - 2;
        //Function g =
        Function fPrim = x -> 2 * x;
        double wynik = EquationSolver.bisection(f, 0, 2, 10000,
                0.0001, 0.000001);
        System.out.println("zad 2: " + wynik);

        //wynik = EquationSolver.bisection(f, 5, 10, 10000,
        //         0.0001, 0.000001);
        // System.out.println(wynik);

        wynik = EquationSolver.newtonMethod(f, fPrim, 1, 0.0001,
                0.000001, 3);
        System.out.println("zad 3: " + wynik);

        wynik = EquationSolver.secantMethod(f, 2, 4, 0.0001,
                0.01, 10000);
        System.out.println("zad 4: " + wynik);

        wynik = EquationSolver.falsiMethod(f, 1, 2, 0.0001, 1000);
        System.out.println("zad 5: " + wynik);

        wynik = EquationSolver.fixPointBanach(f, 1, 0.00001, 100000);
        System.out.println("zad 6: " + wynik);

        Function g = x -> x * x * x - 5 * x * x + 3 * x - 7;
        wynik = EquationSolver.aitkenSteffensen(g, 5, 10e-4, 100);
        System.out.println("zad 7: " + wynik);

        System.out.println(EquationSolver.horner(new double[] {6, 7, -5, 0, 1}, 1));
        System.out.println(EquationSolver.horner(new double[] {6, 7, -5, 0, 1}, 0));
        System.out.println(EquationSolver.horner(new double[] {6, 7, -5, 0, 1}, -2));
    }
}
