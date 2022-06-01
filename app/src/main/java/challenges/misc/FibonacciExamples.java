package challenges.misc;

public class FibonacciExamples {
    public static void main() {
        System.out.println("0th, 1st, 3rd, and 5th Fibonacci Numbers:: ");
        System.out.print(new FibonacciExamples().noDPFibonacci(0) + " ");
        System.out.print(new FibonacciExamples().noDPFibonacci(1) + " ");
        System.out.print(new FibonacciExamples().noDPFibonacci(3) + " ");
        System.out.println(new FibonacciExamples().noDPFibonacci(5));
        System.out.println("Stress Tests::\n");

        long timeBefore = System.currentTimeMillis();
        long twentieth = (new FibonacciExamples().noDPFibonacci(20));
        long timeAfter = System.currentTimeMillis();
        System.out.println("Twentieth:: ");
        System.out.println("Value:: " + twentieth);
        System.out.println("Time Taken:: " + (timeAfter - timeBefore));

        timeBefore = System.currentTimeMillis();
        long twentyFifth = (new FibonacciExamples().noDPFibonacci(25));
        timeAfter = System.currentTimeMillis();
        System.out.println("Twenty-Fifth:: ");
        System.out.println("Value:: " + twentyFifth);
        System.out.println("Time Taken:: " + (timeAfter - timeBefore));

        timeBefore = System.currentTimeMillis();
        long thirty = (new FibonacciExamples().noDPFibonacci(30));
        timeAfter = System.currentTimeMillis();
        System.out.println("Thirtieth:: ");
        System.out.println("Value:: " + thirty);
        System.out.println("Time Taken:: " + (timeAfter - timeBefore));

        timeBefore = System.currentTimeMillis();
        long eighty = (new FibonacciExamples().noDPFibonacci(80));
        timeAfter = System.currentTimeMillis();
        System.out.println("Hundredth:: ");
        System.out.println("Value:: " + eighty);
        System.out.println("Time Taken:: " + (timeAfter - timeBefore));
    }

    public long noDPFibonacci(int num) {
        if (num == 1 || num == 0) {
            return 1;
        }
        return noDPFibonacci(num - 1) + noDPFibonacci(num - 2);
    }
}
