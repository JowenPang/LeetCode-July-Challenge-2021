import java.util.Arrays;

public class Day15_ValidTriangleNumber {
    public static void main(String [] args){
        int [] nums=new int[]{2,2,3,4};
        System.out.println(triangleNumber2(nums));
        System.out.println(triangleNumber(nums));
    }
    //too many loops
    public static int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int ans=0;
        for (int i = 0; i < nums.length-2; i++) {
            for (int j = i+1; j < nums.length - 1; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    if(nums[i]+nums[j]>nums[k])
                        ans++;
                }
            }
        }
        return ans;
    }

    //29ms solution
    public static int triangleNumber2(int[] nums) {
        int c = 0;
        Arrays.sort(nums);
        for (int k = nums.length - 1; k >= 2; k--) {
            int i = 0;
            int j = k - 1;
            while (i < j) {
                if (nums[j] + nums[i] > nums[k]) {
                    c = c + j - i;
                    j--;

                } else
                    i++;
            }
        }
        return c;
    }
}
