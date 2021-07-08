import java.util.ArrayList;
import java.util.Arrays;

public class Day7_KthSmallestElementInSortedArray {

    public static void main(String [] args){
        int [][] mat=new int [][]{{1,5,9},{10,11,13},{12,13,15}};
        int [][] mat2=new int [][]{{-5}};
        System.out.println(kthSmallest(mat, 8));
        System.out.println(kthSmallest(mat2, 1));
    }

    public static int kthSmallest(int[][] matrix, int k) { //similar to mergerSort
        int [] count=new int[matrix.length]; //column index of smallest element in the row
        int minIndex=0;
        int result=0;
        while(k-->0) {
            int min=Integer.MAX_VALUE;
            for (int i = 0; i < matrix.length; i++) {
                if (count[i] == matrix[0].length) //skip for those already completely add into list
                    continue;
                if (matrix[i][count[i]] < min) {
                    min = matrix[i][count[i]];
                    minIndex = i;
                }
            }
            result=min;
            count[minIndex]+=1;
        }
        return result;
    }
}
