package challenges.misc;

public class ComputingFactorial {
    public static void main(){
        double BASEVAL = 170;
        long before1 = System.currentTimeMillis();
        System.out.println((new ComputingFactorial().iterativeFactorial(BASEVAL)));
        long after1 = System.currentTimeMillis();
        System.out.println("Time to compute in milliseconds:: " + (after1 - before1));
        long before2 = System.currentTimeMillis();
        System.out.println((new ComputingFactorial().recursiveFactorial(BASEVAL)));
        long after2 = System.currentTimeMillis();
        System.out.println("Time to compute in milliseconds:: " + (after2 - before2));
    }

    public double iterativeFactorial(double val){
        double solution = 1;
        while(val > 0){
            solution *= val;
            val--;
        }
        return solution;
    }

    public double recursiveFactorial(double val){
        if(val == 1)
            return 1;
        return val * recursiveFactorial((--val));
    }
}
