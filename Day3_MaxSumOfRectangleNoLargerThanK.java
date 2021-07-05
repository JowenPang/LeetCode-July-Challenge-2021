import java.util.TreeSet;

public class Day3_MaxSumOfRectangleNoLargerThanK {
    public static void main(String [] args){
        int [][] arr=new int[][]{{5,-4,-3,4},{-3,-4,4,5},{5,1,5,-4}};
        System.out.println(maxSumSubmatrix(arr,10));
    }
    public static int maxSumSubmatrix(int[][] matrix, int k) {
        int m= matrix.length;
        int n= matrix[0].length;
        int max=Integer.MIN_VALUE;
        for (int row = 0; row < m; row++) {
            int [] column=new int[n];
            for (int i = row; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    column[j] +=matrix[i][j];
                }
                int res=Integer.MIN_VALUE;
                TreeSet<Integer> set=new TreeSet<>();
                set.add(0);
                int sum=0;
                for (int col = 0; col <column.length; col++) {
                    sum += column[col];
                    Integer target = set.ceiling(sum - k);

                    if (target != null) {
                        res = Math.max(res, sum - target);
                    }
                    set.add(sum);
                }
                max=Math.max(max,res);
            }
        }
        return max;
    }
}
