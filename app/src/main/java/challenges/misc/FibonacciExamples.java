package challenges.misc;

import java.math.BigInteger;
import java.util.Arrays;

public class FibonacciExamples {
    public static void main() {
        /* No Dynamic Programming */
        FibNoDP noDP = new FibNoDP();
        System.out.println("Stress Tests for No Dynamic Programming Methods::\n");
        printMetrics(noDP, 0, 35, 5);
        /* Time Intensive */
//        printMetrics(noDP, 45, 49, 1);

        /* Memoization Applied */
        FibMemo memoized = new FibMemo();
        System.out.println("\nStress Tests for Memoized Fibonacci Algorithm::\n");
        printMetrics(memoized, 0, 35, 5);
        /* Time Intensive */
        printMetrics(memoized, 45, 49, 1);
        /* Insanely Large Test */
        memoized.metrics(500);
        System.out.println(memoized);

        /* Bottoms Up Method */
        FibBotUp bottmUp = new FibBotUp();
        System.out.println("\nStress Tests for Bottoms Up Fibonacci Algorithm::\n");
        printMetrics(bottmUp, 0, 35, 5);
        /* Time Intensive */
        printMetrics(bottmUp, 45, 49, 1);
        /* Insanely Large Test */
        bottmUp.metrics(500);
        System.out.println(bottmUp);
    }

    private static void printMetrics(Fibonacci obj, int start, int stop, int step) {
        for (int i = start; i < stop; i += step) {
            obj.metrics(i);
            System.out.println(obj);
        }
        System.out.println();
    }
}

interface IFibonacci {
    String toString();
}

abstract class Fibonacci implements IFibonacci {
    int fibIndex;
    BigInteger fibVal;
    long totalTime;

    public BigInteger fib(int num) {
        if (num == 1 || num == 0) {
            return BigInteger.ONE;
        }
        return fib(num - 1).add(fib(num - 2));
    }

    public void metrics(int fibIndex) {
        this.fibIndex = fibIndex;
        long startTime = System.currentTimeMillis();
        fibVal = (fib(this.fibIndex));
        long stopTime = System.currentTimeMillis();
        this.totalTime = stopTime - startTime;
    }

    public static String ordinal(int i) {
        String[] suffixes = new String[]{"th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th"};
        return switch (i % 100) {
            case 11, 12, 13 -> i + "th";
            default -> i + suffixes[i % 10];
        };
    }

    public String toString() {
        return ordinal(fibIndex + 1) + " Fibonacci Number:: " + fibVal + ", Time to Complete:: " +
                (int) (totalTime / 1000) + "." + totalTime % 1000 + " Seconds";
    }
}

class FibNoDP extends Fibonacci {
}

class FibMemo extends Fibonacci {
    /* Array used to memoize algorithm */
    private BigInteger[] cache;

    @Override
    public void metrics(int fibIndex) {
        this.fibIndex = fibIndex;
        this.cache = Arrays.stream(new BigInteger[fibIndex + 1])
                .map(x -> x = BigInteger.ZERO)
                .toArray(BigInteger[]::new);
        long startTime = System.currentTimeMillis();
        fibVal = (fib(this.fibIndex));
        long stopTime = System.currentTimeMillis();
        this.totalTime = stopTime - startTime;
    }

    @Override
    public BigInteger fib(int num) {
        if (num == 0 || num == 1) {
            return BigInteger.ONE;
        }
        if (!this.cache[num].equals(BigInteger.ZERO)) {
            return this.cache[num];
        }
        this.cache[num] = fib(num - 1).add(fib((num - 2)));
        return this.cache[num];
    }
}

class FibBotUp extends Fibonacci {

    @Override
    public BigInteger fib(int num) {
        if (num == 0 || num == 1)
            return BigInteger.ONE;
        BigInteger right = BigInteger.ONE;
        BigInteger left = BigInteger.ONE;
        BigInteger tmp;
        for (int i = 2; i <= num; i++) {
            tmp = right;
            right = left;
            left = left.add(tmp);
        }
        return left;
    }
}