public class Integration {

    /**
     * calkowanie metoda Trapezow
     *
     * @param f całkowana funkcja
     * @param a lewy koniec przedzailu calkowania
     * @param b prawy  koniec przedzailu calkowania
     * @return przyblizona wartosc calki
     */
    public double wzorTrapezow(Function f, double a, double b) {
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
    public double wzorSimpsona(Function f, double a, double b) {
        return (f.value(a) + 4 * f.value((a + b) / 2) + f.value(b))*(b-a)/6;
    }

    public double zlozonyWzorTrapezow(Function f, double a, double b, int partnumber){

    }
}
