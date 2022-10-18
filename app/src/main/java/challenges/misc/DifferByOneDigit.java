package challenges.misc;

public class DifferByOneDigit {
    public static void main(){
        int[] nums = new int[]{22,21,12,13};
        DifferByOneDigit obj = new DifferByOneDigit();
        System.out.println(obj.solution(nums));
    }

    public int solution(int[] numbers){
        int count = 0;
        for(int i = 0; i < numbers.length; i++){
            for(int j = i; j < numbers.length; j++){
                if(check(numbers[i],numbers[j]))
                    count++;
            }
        }
        return count;
    }

    public static boolean check(int a, int b){
        if(a < 10 && b < 10)
            return a != b;
        int dig1, dig2;
        int diff = 0;
        while(a > 0 || b > 0){
            dig1 = a % 10;
            dig2 = b % 10;
            if(dig1 != dig2)
                diff++;
            a = a/10;
            b = b/10;
        }
        return diff == 1;
    }
}
