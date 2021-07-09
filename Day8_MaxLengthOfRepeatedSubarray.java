public class Day8_MaxLengthOfRepeatedSubarray {
    public static void main(String [] args){
        int [] nums1=new int[]{1,2,3,2,1};
        int [] nums2=new int[]{3,2,1,4,5};
        System.out.println(findLength(nums1,nums2));
    }

    //Algorithm : Longest Common Subsequence
    public static int findLength(int[] nums1, int[] nums2) {
        //use dynamic programming
        int max=0;
        int [] [] memo = new int[nums1.length+1][nums2.length+1];
        for (int i = 1; i <=nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if(nums1[i-1]==nums2[j-1]) {
                    memo[i][j] = memo[i - 1][j - 1] + 1;
                    if(max<memo[i][j])
                        max=memo[i][j];
                }
            }
        }
        return max;













        //time limit exceeded
       /* int max=0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int temp=0;
                int tempJ=j;
                int tempI=i;
                while(tempJ<nums2.length&&tempI<nums1.length&& nums1[tempI]==nums2[tempJ]){ //found the same element
                    temp+=1;
                    tempI++;
                    tempJ++;
                }
                if(temp>max)
                    max=temp;
            }
        }
        return max;*/
    }
}
