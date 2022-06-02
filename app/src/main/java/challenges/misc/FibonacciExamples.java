package challenges.misc;

import java.util.HashMap;

public class FibonacciExamples {
    public static void main() {
        int i = 0;
        /* No Dynamic Programming */
        FibNoDP noDynamic = new FibNoDP();
        System.out.println("Stress Tests for No Dynamic Programming Methods::\n");
        for (i = 10; i < 50; i += 10) {
            noDynamic.fibNoDynProg(i);
            System.out.println(noDynamic);
        }
        /* Time Intensive */
        for (i = 45; i < 49; i++) {
            noDynamic.fibNoDynProg(i);
            System.out.println(noDynamic);
        }

        /* Memoization Applied */
        FibMemo memoAlg = new FibMemo();
        System.out.println("\nStress Tests for Memoized Fibonacci Algorithm::\n");
        for (i = 10; i < 50; i += 10) {
            memoAlg.fibMemoized(i);
            System.out.println(memoAlg);
        }
        /* Time Intensive */
        for (i = 45; i < 49; i++) {
            memoAlg.fibMemoized(i);
            System.out.println(memoAlg);
        }
        /* Insanely Large Test */
        memoAlg.fibMemoized(90);
        System.out.println(memoAlg);

        /* Bottoms Up Method */
        FibBotUp botUp = new FibBotUp();
        System.out.println("\nStress Tests for Bottoms Up Fibonacci Algorithm::\n");
        for (i = 10; i < 50; i += 10) {
            botUp.fibBotUp(i);
            System.out.println(botUp);
        }
        /* Time Intensive */
        for (i = 45; i < 49; i++) {
            botUp.fibBotUp(i);
            System.out.println(botUp);
        }
        /* Insanely Large Test */
        botUp.fibBotUp(90);
        System.out.println(botUp);
    }


    static class FibNoDP {
        int fibIndex;
        long fibVal;
        long totalTime;

        public void fibNoDynProg(int fibIndex) {
            this.fibIndex = fibIndex;
            long startTime = System.currentTimeMillis();
            fibVal = (new FibNoDP().fib(this.fibIndex));
            long stopTime = System.currentTimeMillis();
            this.totalTime = stopTime - startTime;
        }

        public long fib(int num) {
            if (num == 1 || num == 0) {
                return 1;
            }
            return fib(num - 1) + fib(num - 2);
        }

        public String toString() {
            String expression;
            expression = ""
                    .concat(fibIndex + "th Fibonacci Number:: ").concat(String.valueOf(fibVal)).concat("\n")
                    .concat("Time to Complete:: ").concat(String.valueOf((int) (totalTime / 1000)))
                    .concat(".").concat(String.valueOf(totalTime % 1000)).concat(" Seconds");
            return expression;
        }
    }

    static class FibMemo {
        int fibIndex;
        long fibVal;
        long totalTime;
        /* HashMap used to memoize algorithm */
        HashMap<Integer, Long> cache = new HashMap<>();


        public void fibMemoized(int fibIndex) {
            this.fibIndex = fibIndex;
            long startTime = System.currentTimeMillis();
            fibVal = (new FibMemo().fib(this.fibIndex));
            long stopTime = System.currentTimeMillis();
            this.totalTime = stopTime - startTime;
        }

        public long fib(int num) {
            if (num == 0 || num == 1) {
                cache.put(num, 1L);
                return 1;
            }
            if (cache.containsKey(num)) {
                return cache.get(num);
            }
            cache.put(num, fib(num - 1) + fib((num - 2)));
            return cache.get(num);
        }

        public String toString() {
            String expression;
            expression = ""
                    .concat(fibIndex + "th Fibonacci Number:: ").concat(String.valueOf(fibVal)).concat("\n")
                    .concat("Time to Complete:: ").concat(String.valueOf((int) (totalTime / 1000)))
                    .concat(".").concat(String.valueOf(totalTime % 1000)).concat(" Seconds");
            return expression;
        }
    }

    static class FibBotUp {
        int fibIndex;
        long fibVal;
        long totalTime;

        public void fibBotUp(int fibIndex) {
            this.fibIndex = fibIndex;
            long startTime = System.currentTimeMillis();
            fibVal = (new FibBotUp().fib(this.fibIndex));
            long stopTime = System.currentTimeMillis();
            this.totalTime = stopTime - startTime;
        }

        public long fib(int num) {
            long[] fib = new long[num + 1];
            fib[0] = 1;
            fib[1] = 1;
            for (int i = 2; i <= num; i++) {
                fib[i] = fib[i - 1] + fib[i - 2];
            }
            return fib[num];
        }

        public String toString() {
            String expression;
            expression = ""
                    .concat(fibIndex + "th Fibonacci Number:: ").concat(String.valueOf(fibVal)).concat("\n")
                    .concat("Time to Complete:: ").concat(String.valueOf((int) (totalTime / 1000)))
                    .concat(".").concat(String.valueOf(totalTime % 1000)).concat(" Seconds");
            return expression;
        }
    }
}