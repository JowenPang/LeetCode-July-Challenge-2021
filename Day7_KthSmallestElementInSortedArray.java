public class Day7_KthSmallestElementInSortedArray {

    public static void main(String [] args){
        int [][] mat=new int [][]{{1,5,9},{10,11,13},{12,13,15}};
        int [][] mat2=new int [][]{{-5}};
        System.out.println(kthSmallest(mat, 8));
        System.out.println(kthSmallest(mat2, 1));
    }

    //my solution
    //similar to mergeSort 24ms
    public static int kthSmallest(int[][] matrix, int k) {
        int [] colIndex =new int[matrix.length]; //column index of smallest element in the ith row which haven't been visited
        int minIndex=0; //to store the row we need to update for count array
        int min=0;
        while(k-->0) {
            min=Integer.MAX_VALUE;
            for (int i = 0; i < matrix.length; i++) {
                if (colIndex[i] == matrix[0].length) //skip for those already visited till the end of row
                    continue;
                if (matrix[i][colIndex[i]] < min) {
                    min = matrix[i][colIndex[i]];
                    minIndex = i;
                }
            }
            colIndex[minIndex]+=1; //update the column index for the specific row
        }
        return min; //the last min updated is the kth value
    }



   /* public static int kthSmallest(int[][] matrix, int k) { //others : Oms solution
        int row = matrix.length;
        int col = matrix[0].length;
        int l = matrix[0][0];
        int r = matrix[row-1][col-1];
        while(l <= r) {
            int mid = l+(r-l)/2;
            if(check(matrix, mid, k, col)) {
                r = mid -1;
            } else {
                l = mid+1;
            }
        }
        return l;
    }

    private static boolean check(int[][] matrix, int mid, int k, int n) {
        int i = n - 1;
        int j = 0;
        int num = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= mid) {
                num += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return num >= k;

    }*/
}
