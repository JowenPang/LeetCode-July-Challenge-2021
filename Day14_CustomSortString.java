import java.util.ArrayList;

public class Day14_CustomSortString {
    public static void main(String [] args){
        System.out.println(customSortString("abcn","ebbncadzzerfnjvnin"));
    }
    public static String customSortString(String order, String s) {
        int [] ans=new int[26];

        for (int i = 0; i < s.length(); i++) {
            ans[s.charAt(i)-'a']=ans[s.charAt(i)-'a']+1;
        }
        String sb="";
        for (int i = 0; i < order.length(); i++) {
            if(s.contains(Character.toString(order.charAt(i)))){
                while(ans[order.charAt(i)-'a']>0){
                    sb+=order.charAt(i);
                    ans[order.charAt(i)-'a']=ans[order.charAt(i)-'a']-1;
                }
            }
        }
        for (int i = 0; i < ans.length; i++) {
            if(ans[i]!=0){
                while(ans[i]>0){
                    sb+=(char)(i+'a');
                    ans[i]--;
                }
            }
        }
        return sb;
    }
}
