import java.util.*;

public class Day16_FourSum {
    public static void main(String [] args){
        int [] nums=new int[]{-5,5,4,-3,0,0,4,-2};
        System.out.println(fourSum(nums,4));
    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans=new LinkedList<>();

        Arrays.sort(nums);
        for (Integer i = 0; i < nums.length-3; i++) {
            for (Integer j = i+1; j < nums.length - 2; j++) {
                for (Integer k = j+1; k < nums.length-1; k++) {
                    for (Integer l = k+1; l < nums.length; l++) {
                        if (nums[i] + nums[j]+nums[k]+nums[l]==target) {
                            List<Integer> list = new LinkedList<>();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[k]);
                            list.add(nums[l]);
                            if(!ans.contains(list))
                                ans.add(list);
                        }
                    }
                }
            }
        }
        return ans;

    }


}
