public class Day4_CountVowelsPermutation {
    public static void main(String [] args){
        System.out.println(countVowelPermutation(144));
    }
    public static int countVowelPermutation(int n) {
        int MOD = (int) 1e9 +7;
        int sum=0;
        long [] [] dp=new long[n+1][5];
        //Let dp[i][j] be the number of strings of length i that ends with the j-th vowel.
        //j =5 to store a,e,i,o,u
        for (int i = 0; i < dp[0].length; i++) {
            dp[1][i]=1;
        }
        //for vowels end with _ -> can have vowels _ in front of it
        //a -> e i u
        //e -> a i
        //i -> e o
        //o -> i
        //u -> i o
        //dynamic programming , save the length of String for previous i
        for (int i = 2; i < n+1; i++) {
            dp[i][0]=(dp[i-1][1]+dp[i-1][2]+dp[i-1][4])%MOD;
            dp[i][1]=(dp[i-1][0]+dp[i-1][2])%MOD;
            dp[i][2]=(dp[i-1][1]+dp[i-1][3])%MOD;
            dp[i][3]=(dp[i-1][2])%MOD;
            dp[i][4]=(dp[i-1][2]+dp[i-1][3])%MOD;
        }

        for (int i = 0; i < dp[n].length; i++) {
            sum=(int)(sum+dp[n][i])%MOD;
        }
        return sum;
    }

    /*dp[0][j] = 0 0 0 0 0
      dp[1][j] = 1 1 1 1 1     = 5
      dp[2][j] = 3 2 2 1 2     = 10
      dp[3][j] = 6 5 3 2 3     = 19
      dp[4][j] = 11 9 7 3 5    = 35
      dp[5][j] = 21 18 12 7 10 = 68*/

}
