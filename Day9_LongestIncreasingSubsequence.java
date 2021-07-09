import java.util.Arrays;

public class Day9_LongestIncreasingSubsequence {
    public static void main(String [] args){
        int [] nums1=new int[]{10,2,5,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums1));
        System.out.println(lengthOfLIS2(nums1));
    }

    //nums=[0,3,1,6,2,2,7]
    //memo=[1,2,2,4,2,2,7]

    //nums =[4,10,4,3,8,9]
    //memo =[1,2,1,1,2,3]

    //nums = [10,9,2,5,3,7,101,18]
    //memo = [1,1,1,2,2,3,4,4]

    //98ms
    public static  int lengthOfLIS(int[] nums) {
        int [] memo=new int[nums.length];
        memo[0]=1;
        int maxLength=memo[0];
        for (int i = 1; i <nums.length; i++) {
            int max=0;
            for (int j = 0; j < i; j++) {
                if(nums[j]<nums[i]&& memo[j]>max){
                    max=memo[j];
                }
            }
            memo[i]=max+1;
            if(memo[i]>maxLength)
                maxLength=memo[i];

        }
        return maxLength;
    }

    //1ms solution
    public static int lengthOfLIS2(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int length = 0;
        for (int x : nums) {
            //binarySearch(array, fromIndex, toIndex, key)
            int i = Arrays.binarySearch(dp, 0, length, x);
            if (i < 0) i = -(i+1);
            dp[i] = x;
            if (i == length) length++;
        }
        return length;
    }
}
