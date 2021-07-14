public class Day10_DecodeWays2 {
    public static void main(String [] args){
        String s="7*9*3*6*3*0*5*4*9*7*3*7*1*8*3*2*0*0*6*";
        System.out.println(numDecodings(s));
    }

    public static int numDecodings(String s) {
        long [] dp=new long[s.length()+1];
        dp[0]=1; //the case to handle when i-2
        if(s.charAt(0)=='0')
            dp[1]=0;
        else if(s.charAt(0)=='*')
            dp[1]=9;
        else
            dp[1]=1;
        for (int i = 2; i < dp.length; i++) {
            if(Character.getNumericValue(s.charAt(i-1))>0)
                dp[i]+=dp[i-1];
            else if(s.charAt(i-1)=='*')
                dp[i]+=dp[i-1]*9;
            else
                dp[i]+=0;


            if(s.charAt(i-2)=='*'){
                if (s.charAt(i-1)=='*')
                    dp[i]+=dp[i-2]*15; //15 = { 11,12,13,14,15,16,17,18,19,21,22,23,24,25,26 }
                else if(s.charAt(i-1)>='0'&&s.charAt(i-1)<='6')
                    dp[i]+=dp[i-2]*2;
                else
                    dp[i]+=dp[i-2];

            }
            else if(s.charAt(i-2)=='1'){
                if(s.charAt(i-1)=='*')
                    dp[i]+=dp[i-2]*9; //9 ={ 11,12,13,14,15,16,17,18,19 }
                else
                    dp[i]+=dp[i-2];
            }
            else if(s.charAt(i-2)=='2'){
                if(s.charAt(i-1)=='*')
                    dp[i]+=dp[i-2]*6; //6 = {21,22,23,24,25,26 }
                else if(s.charAt(i-1)>='0'&&s.charAt(i-1)<='6')
                    dp[i]+=dp[i-2];
                //{20,27,28,29 totally cannot form
            }


            dp[i]=dp[i]%1000000007;
        }
        return (int)(dp[dp.length-1]); //last element in the array will store maximum way
    }


}
