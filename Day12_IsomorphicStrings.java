import java.util.ArrayList;

public class Day12_IsomorphicStrings {
    public static void main(String [] args){
        System.out.println(isIsomorphic("bbbaaaba","aaabbbba"));
        System.out.println(isIsomorphic2("abbcaee","aabbcee"));
    }
    public static boolean isIsomorphic(String s, String t) {
        ArrayList<Character> list=new ArrayList<>();
        ArrayList<Character> list2=new ArrayList<>();
        String sNew="";
        String tNew="";
        for (int i = 0; i < s.length(); i++) {
            char x=s.charAt(i);
            if(!list.contains(x))
                list.add(x);
            sNew+=String.valueOf(list.indexOf(x));
            char x2=t.charAt(i);
            if(!list2.contains(x2))
                list2.add(x2);
            tNew+=String.valueOf(list2.indexOf(x2));
        }
        System.out.println(sNew);
        System.out.println(tNew);
        return sNew.equals(tNew);
    }

    //3ms solution
    public static boolean isIsomorphic2(String s, String t) {
        int[] countS = new int[128];
        int[] countT = new int[128];

        for(int i =0; i < s.length(); i++){
            char s_char = s.charAt(i), t_char = t.charAt(i);
            if(countS[s_char] != countT[t_char]) return false;
            countS[s_char] = i+1;
            countT[t_char] = i+1;
        }
        return true;
    }

}