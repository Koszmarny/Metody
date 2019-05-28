public class FloatingPointArithmetic {
    /**
     * Metoda znajduje przybli»enie danej liczby zapisanej w systemie o podstawie
     * {@radix} do {@code precision} cyfr znacz¡cych uzyskane za pomoc¡ obci¦cia
     * cyfr.
     *
     * @param number    dana liczba
     * @param radix     podstawa systemu
     * @param precision liczba cyfr znacz¡cych po wykonaniu przybli»enia
     * @return przybli»enie danej liczby zapisanej w systemie o podstawie
     * {@radix} do {@code precision} cyfr znacz¡cych uzyskane za pomoc¡
     * obci¦cia cyfr.
     */
    public static String cut(String number, int radix, int precision) {
        int dotplace = number.indexOf('.');
        int zeros;
        int leadingZeros;

        if (dotplace == -1) {
            dotplace = number.length();
        } else {
            number = number.substring(0, dotplace) + number.substring(dotplace + 1);
        }

        leadingZeros = countLeadingZeros(number);
        if (leadingZeros > 0) {
            number = number.substring(leadingZeros);
        }

        if (number.length() > precision) {
            number = number.substring(0, precision);
        } else {
            zeros = precision - number.length();
            number = appendZeros(zeros, number);
        }

        number = appendLeadingZeros(leadingZeros, number);
        if (dotplace < number.length()) {
            number = number.substring(0, dotplace) + '.' + number.substring(dotplace);
        } else {
            number = appendZeros(dotplace - number.length(), number);
        }

        return number;
    }

    private static int countLeadingZeros(String number) {
        int index = 0;
        for (index = 0; index < number.length() && number.charAt(index) == '0'; index++) ;
        return index;
    }

    private static String appendZeros(int numberOfZeros, String number) {
        for (int i = 0; i < numberOfZeros; i++) {
            number = number + '0';
        }
        return number;
    }

    private static String appendLeadingZeros(int numberOfZeros, String number) {
        for (int i = 0; i < numberOfZeros; i++) {
            number = '0' + number;
        }
        return number;
    }

    /**
     * Metoda znajduje przybli»enie danej liczby zapisanej w systemie o podstawie
     * {@radix} do {@code precision} cyfr znacz¡cych uzyskane za pomoc¡
     * zaokr¡glenia.
     *
     * @param number    dana liczba
     * @param radix     podstawa systemu
     * @param precision liczba cyfr znacz¡cych po wykonaniu przybli»enia
     * @return przybli»enie danej liczby zapisanej w systemie o podstawie
     * {@radix} do {@code precision} cyfr znacz¡cych uzyskane za pomoc¡
     * zaokr¡glenia.
     */
    public static String round(String number, int radix, int precision) {
        return null;
    }
}
