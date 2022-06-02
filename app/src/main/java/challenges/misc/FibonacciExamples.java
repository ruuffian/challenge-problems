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
        printMetrics(noDP, 45, 49, 1);

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
    }
}

interface IFibonacci {
    void metrics(int fibIndex);

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

    public static String ordinal(int i) {
        String[] suffixes = new String[]{"th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th"};
        return switch (i % 100) {
            case 11, 12, 13 -> i + "th";
            default -> i + suffixes[i % 10];
        };
    }

    public String toString() {
        String expression;
        expression = ""
                .concat(ordinal(fibIndex) + " Fibonacci Number:: ").concat(String.valueOf(fibVal)).concat("\n")
                .concat("Time to Complete:: ").concat(String.valueOf((int) (totalTime / 1000)))
                .concat(".").concat(String.valueOf(totalTime % 1000)).concat(" Seconds");
        return expression;
    }
}

class FibNoDP extends Fibonacci {

    public void metrics(int fibIndex) {
        this.fibIndex = fibIndex;
        long startTime = System.currentTimeMillis();
        fibVal = (new FibNoDP().fib(this.fibIndex));
        long stopTime = System.currentTimeMillis();
        this.totalTime = stopTime - startTime;
    }
}

class FibMemo extends Fibonacci {
    private BigInteger[] cache;

    public void metrics(int fibIndex) {
        this.fibIndex = fibIndex;
        /* Array used to memoize algorithm */
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
            this.cache[num] = BigInteger.ONE;
            return BigInteger.ONE;
        }
        if (!this.cache[num].equals(BigInteger.ZERO)) {
            return this.cache[num];
        }
        this.cache[num] = fib(num - 1).add(fib((num - 2)));
        return this.cache[num - 1];
    }
}

class FibBotUp extends Fibonacci {
    public void metrics(int fibIndex) {
        this.fibIndex = fibIndex;
        long startTime = System.currentTimeMillis();
        fibVal = (fib(this.fibIndex));
        long stopTime = System.currentTimeMillis();
        this.totalTime = stopTime - startTime;
    }

    @Override
    public BigInteger fib(int num) {
        BigInteger[] fib = new BigInteger[num];
        fib[0] = BigInteger.ONE;
        fib[1] = BigInteger.ONE;
        for (int i = 2; i < num - 1; i++) {
            fib[i] = fib[i - 1].add(fib[i - 2]);
        }
        return fib[num - 1];
    }
}