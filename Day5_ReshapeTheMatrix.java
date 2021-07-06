import java.util.Arrays;

public class Day5_ReshapeTheMatrix {
    public static void main(String [] args){
        int [][] mat=new int [][]{{1,2},{3,4},{5,6},{8,9}};
        System.out.println(Arrays.deepToString(matrixReshape(mat, 8, 1)));
    }

    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        if(mat.length*mat[0].length!=r*c)
            return mat;
        int [][] newMat =new int[r][c];
        int newRow=0; //row of newMat
        int newCol=0; //column of newMat
        for (int i = 0; i < mat.length; i++) { //looping through old matrix
            for (int j = 0; j < mat[i].length; j++) {
                if(newCol==newMat[newRow].length) { //update new row and reset new column
                    newRow+=1;
                    newCol = 0;
                }
                newMat[newRow][newCol]=mat[i][j];
                newCol+=1;

            }
        }
        return newMat;
    }
}
