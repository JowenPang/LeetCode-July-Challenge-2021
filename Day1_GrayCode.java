import java.util.ArrayList;
import java.util.List;

public class Day1_GrayCode {
    static List<Integer> sol=new ArrayList<>();
    public static void main(String [] args){
        System.out.println(grayCode(6));
    }
    public static List<Integer> grayCode(int n) {
        if(n==1) {
            sol.add(0);
            sol.add(1);
            return sol;
        }
        if(sol.size()==Math.pow(2,n)){
            return sol;
        }

        grayCode(n-1);
        //1. duplicate reverse
        int x=sol.size();
        for (int i = 0; i < x; i++) {
            sol.add(sol.get(x-1-i));
        }
        //2.add 0 to previous half
        for (int i = 0; i < x; i++) {
            String bin= Integer.toBinaryString(sol.get(i));
            while(bin.length()<n-1){
                bin="0"+bin;
            }
            bin="0"+bin;
            sol.set(i,Integer.parseInt(bin,2));
        }
        //3.add 1 to later half
        for (int i = x; i < sol.size(); i++) {
            String bin= Integer.toBinaryString(sol.get(i));
            while(bin.length()<n-1){
                bin="0"+bin;
            }
            bin="1"+bin;
            sol.set(i,Integer.parseInt(bin,2));
        }
        return sol;
    }
}