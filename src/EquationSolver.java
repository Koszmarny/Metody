public class EquationSolver {
    /**
     * zad 2
     *
     * @param f       funkcja
     * @param alpha   lewy koniec przedzialu
     * @param beta    prawy koniec przedzialu
     * @param maxN    max liczba wyliczanych przyblizen
     * @param delta   dokladnosc miejsca zerowego
     * @param epsilon dokladnosc wartosci funkcji
     * @return przybllizenie miejsca zerowego funkcji
     */
    public static double bisection(Function f, double alpha, double beta,
                                   int maxN, double delta, double epsilon) {
        int i = 0;
        double a = alpha;
        double b = beta;
        double d = (b - a) / 2;
        double c = d + a;
        double u = f.value(a);
        double v = f.value(b);
        double w = f.value(c);

        if (u * v > 0) {
            throw new RuntimeException("zle dane");
        }

        while (Math.abs(w) >= epsilon && d >= delta && i != maxN) {
            i++;
            if (u * w < 0) {
                b = c;
                v = w;
            } else {
                a = c;
                u = w;
            }
            d = d / 2;
            c = d + a;
            w = f.value(c);
        }
        return c;
    }

    /**
     * zad 3
     *
     * @param f          funkcja
     * @param fPrim      pochodna f
     * @param startpoint punkt poczatkowy
     * @param epsilon    przyblizenie wartosci
     * @param delta      przyblizenie mz
     * @return
     */
    public static double newtonMethod(Function f, Function fPrim, double startpoint,
                                      double epsilon, double delta, int maxKrokow) {
        int krok = 0;
        double x;
        double xNext = startpoint;
        double xValue;
        double nextValue;
        do {
            x = xNext;
            xValue = f.value(x);
            xNext = x - xValue / fPrim.value(x);
            nextValue = f.value(xNext);
            krok++;
        } while (Math.abs(xValue - nextValue) >= delta
                && Math.abs(nextValue) >= epsilon && krok < maxKrokow);
        return xNext;
    }

    /**
     * zad 4
     *
     * @param f       funkcja
     * @param alpha   pierwszy element
     * @param beta    drugi element
     * @param epsilon przyblizenie wartosci
     * @param delta   przyblizenie mz
     * @return
     */
    public static double secantMethod(Function f, double alpha, double beta,
                                      double epsilon, double delta, int maxKrokow) {
        double x = alpha;
        double xNext = beta;
        double xNN;
        double xValue;
        double xNValue;
        int krok = 0;
        do {
            xValue = f.value(x);
            xNValue = f.value(xNext);
            xNN = xNext - xValue * (x - xValue);
            xNValue = f.value(xNext);
            krok++;
        } while (Math.abs(xValue - xNValue) >= delta
                && Math.abs(xNValue) >= epsilon && krok < maxKrokow);
        return xNext;
    }

    /**
     * zad 5
     *
     * @param f         funkcja
     * @param alpha
     * @param beta
     * @param epsilon   przyblizanie wartosci
     * @param maxKrokow maksymalna liczba krokow
     * @return
     */
    public static double falsiMethod(Function f, double alpha, double beta, double epsilon, int maxKrokow) {
        int krok = 0;
        double Fa = f.value(alpha);
        double Fb = f.value(beta);
        double x1 = alpha;
        double x0 = beta;
        double F0;
        if (Fa * Fb > 0) {
            return Double.NaN;
        } else {
            do {
                x1 = x0;
                x0 = alpha - Fa * ((beta - alpha) / (Fb - Fa));
                F0 = f.value(x0);
                if (Math.abs(F0) < epsilon) {
                    return x0;
                } else if ((Fa * F0) < 0) {
                    beta = x0;
                    Fb = F0;
                } else {
                    alpha = x0;
                    Fa = F0;
                    krok++;
                }
            } while (Math.abs(x1 - x0) <= epsilon && krok < maxKrokow);
            return x0;
        }
    }


    /**
     * zad 6
     *
     * @param f         funkcja
     * @param x
     * @param epsilon   przyblizenie wartosci
     * @param maxKrokow ilosc krokow do wykonania
     * @return
     */
    public static double fixPointBanach(Function f, double x, double epsilon,
                                        double maxKrokow) {
        int krok = 0;
        double xNext = f.value(x);
        while (Math.abs(xNext - x) >= epsilon && krok < maxKrokow) {
            x = xNext;
            xNext = f.value(x);
            krok++;
        }
        if (krok == maxKrokow) {
            return Double.NaN;
        } else {
            return xNext;
        }

    }

    /**
     * zad 7
     *
     * @param g         funkcja
     * @param x
     * @param epsilon   przyblizenie wartosci
     * @param maxKrokow max liczba przyblizen
     * @return
     */
    public static double aitkenSteffensen(Function g, double x,
                                          double epsilon, int maxKrokow) {
        int i = 0;
        double e = 0;
        double f = 1;
        double y;
        do {
            i = i + 1;
            x = x - ((e * e) / (f - e));
            y = g.value(x);
            e = y - x;
            f = g.value(y) - y;
        } while (Math.abs(e) >= epsilon && Math.abs(f) >= epsilon && i < maxKrokow);

        if (i == maxKrokow) {
            return Double.NaN;
        } else {
            return y;
        }
    }

    public static double horner(double[] coefficients, int x) {
        double result = 0;
        for (int i = coefficients.length - 1; i >= 0; i--)
            result = result * x + coefficients[i];
        return result;
    }

}
