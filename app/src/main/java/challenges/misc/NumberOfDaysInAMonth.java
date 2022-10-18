package challenges.misc;

public class NumberOfDaysInAMonth {
    public static void main() {
        int month = 3;
        int year = 2022;
        System.out.println(numberOfDaysInMonth(month, year));
    }

    private static int numberOfDaysInMonth(int month, int year) {
        return switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 2 -> (year % 4 == 0 || year % 400 == 0) ? 29 : 28;
            default -> 30;
        };
    }
}
