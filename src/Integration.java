
public class Integration {

    /**
     * calkowanie metoda Trapezow
     *
     * @param f całkowana funkcja
     * @param a lewy koniec przedzailu calkowania
     * @param b prawy  koniec przedzailu calkowania
     * @return przyblizona wartosc calki
     */
    public static double wzorTrapezow(Function f, double a, double b) {
        return (f.value(a) + f.value(b)) * (b - a) / 2;
    }

    /**
     * calkowanie metoda Simpsona
     *
     * @param f całkowana funkcja
     * @param a lewy koniec przedzailu calkowania
     * @param b prawy koniec przedzailu calkowania
     * @return przyblizona wartosc calki
     */
    public static double wzorSimpsona(Function f, double a, double b) {
        return (f.value(a) + 4 * f.value((a + b) / 2) + f.value(b)) * (b - a) / 6;
    }

    public static double zlozonyWzorTrapezow(Function f, double a, double b,
                                             int liczbaPodprzedzialow) {
        double dlugoscPodprzedzialu = (b - a) / liczbaPodprzedzialow;
        double result = 0;
        double left = a;
        double right = left + dlugoscPodprzedzialu;
        for (int k = 1; k <= liczbaPodprzedzialow; k++) {
            result += wzorTrapezow(f, left, right);
            left = right;
            right += dlugoscPodprzedzialu;
        }
        return result;
    }

    public static double zlozonyWzorSimpsona(Function f, double a, double b,
                                             int liczbaPodprzedzialow) {
        double dlugoscPodprzedzialu = (b - a) / liczbaPodprzedzialow;
        double result = 0;
        double left = a;
        double right = left + dlugoscPodprzedzialu;
        for (int k = 1; k <= liczbaPodprzedzialow; k++) {
            result += wzorSimpsona(f, left, right);
            left = right;
            right += dlugoscPodprzedzialu;
        }
        return result;
    }

    public static double ekstrapolacjaRichardsona(
            Function f, double x, double h, int n) {
        double result;
        if (n <= 0) {
            throw new IllegalArgumentException("jfh");
        }

        if (n == 1) {
            result = ilorazRoznicowy(f, x, h);
        } else {
            result = (1 / (Math.pow(4, n - 1) - 1)) * (Math.pow(4, n - 1) *
                    ekstrapolacjaRichardsona(f, x, h / 2, n - 1) -
                    ekstrapolacjaRichardsona(f, x, h, n - 1));
        }
        return result;
    }

    public static double ilorazRoznicowy(Function f, double x, double h) {
        return (f.value(x + h) - f.value(x - h)) / h / 2;
    }

    public static Polynomial wielomianInterpolacyjny1(double[] f, double[] x) {
        double ff = (f[1] - f[0]) / (x[1] - x[0]);
        Polynomial p = new Polynomial(new double[]{f[0]});
        Polynomial q = new Polynomial(new double[]{-ff * x[0], ff});
        return p.add(q);
    }

    public static Polynomial wielomianInterpolacyjny2(double[] f, double[] x) {
        Polynomial w1 = wielomianInterpolacyjny1(f, x);
        double iloraz = (f[2] - w1.valueAt(x[2])) / (x[2] - x[0] * (x[2] - x[0]));
        Polynomial p = new Polynomial(new double[]{x[0] * x[1], -x[0] - x[1]});
        Polynomial q = new Polynomial(new double[]{iloraz});
        return w1.add(p.multiply(q));
    }

    public static Polynomial wielomianInterpolacyjny3(double[] f, double[] x, int liczbaWezlow) {
//        Polynomial w1 = wielomianInterpolacyjny2(f,x);
//        double iloraz = (f[3] - w1.valueAt(x[3]))/(x[3]-x[0]*(x[3]-x[0]));
//        Polynomial p = new Polynomial(new double[]{x[0]*x[2], -x[0]-x[2]});
//        Polynomial q = new Polynomial(new double[]{iloraz});
//        return w1.add(p.multiply(q));
        Polynomial wynik;
        if (liczbaWezlow == 2) {
            wynik = wielomianInterpolacyjny1(f, x);
        } else {
            wynik = wielomianInterpolacyjny3(f, x, liczbaWezlow - 1);
            double iloraz = f[liczbaWezlow - 1] - wynik.valueAt(x[liczbaWezlow - 1]);
            for (int i = 0; i <= liczbaWezlow - 1; i++) {
                iloraz = iloraz / (x[liczbaWezlow - 1] - x[i]);
            }
            Polynomial p = new Polynomial(new double[]{iloraz});
            for (int i = 0; i <= liczbaWezlow - 1; i++) {
                p.multiply(new Polynomial(new double[]{-x[i],1}));
            }
            wynik =wynik.add(p);
        }
        return wynik;
    }

    public static Matrix macierzOdwrotna(SquareMatrix matrix, int n) {
        SquareMatrix identityMatrix = SquareMatrix.c
    }
}
