import java.util.Arrays;
import java.util.Collections;

public class Day13_FindPeakElement {
    public static void main(String [] args){
        int [] nums=new int[]{1,9};
        System.out.println(findPeakElement(nums));
    }
    public static int findPeakElement(int[] nums) {
        int [] copy= nums.clone();
        Arrays.sort(copy);
        System.out.println(Arrays.toString(copy));
        System.out.println(Arrays.toString(nums));
       for (int i = copy.length-1; i >=0; i--) {
           for (int j = 0; j < nums.length; j++) {
               if(nums[j]==copy[i]){
                   if(nums.length==1)  //case only one element
                       return j;
                   else if(j-1<0 && nums[j + 1] < nums[j]) //case peak is first element
                           return j;
                   else if (j+1>=nums.length && nums[j-1]<nums[j]) //case peak is last element
                           return j;
                   else if (nums[j - 1] < nums[j] && nums[j + 1] < nums[j]) //case peak is at middle
                           return j;

               }
           }
        }
       return -1;
    }
}
