package challenge.problems;

public class PalindromeNumber{
    public static void main(){
        System.out.println(new PalindromeNumber().isPalindrome(121));
        System.out.println(new PalindromeNumber().isPalindrome(123));

    }

        public boolean isPalindrome(int x) {
            if(x < 0)
                return false;
            int p1 = 0, p2 = 0;
            int tmp = x;
            while(tmp > 0){
                tmp = tmp / 10;
                p2++;
            }
            p2--;
            String str = String.valueOf(x);
            while(p1 != p2){
                if(str.charAt(p1) != str.charAt(p2))
                    return false;
                p1++;
                p2--;
            }
            return true;
        }
}
