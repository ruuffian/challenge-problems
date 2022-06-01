package challenge.problems;

public class ContainerWithMostWater {
    public static void main() {
        System.out.println("The Maximal Area Container:: ");
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    public static int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int area = 0, tmp = 0;
        while(i < j){
            if(height[i]>=height[j]){
                tmp = height[j] * (j-i);
                j--;
            } else{
                tmp = height[i] * (j-i);
                i++;
            }
            area = Math.max(tmp, area);
        }
        return area;
    }
}
