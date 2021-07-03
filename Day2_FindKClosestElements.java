import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day2_FindKClosestElements {
    public static void main(String [] args){
        int [] arr=new int[]{1,5,10};
        System.out.println(findClosestElements(arr,1,4));
    }
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        int low=0;
        int high=arr.length-1;
        int mid=-1;
        while(low<=high){
            mid=(high+low)/2;
            if(arr[mid]==x) {
                break;
            }
            else if(arr[mid]>x)
                high=mid-1;
            else
                low=mid+1;
        }
        int a=Math.max(0,mid-1);
        int b=a+1;
        while (a>=0 && b<arr.length&&list.size()<k){
            if(Math.abs(arr[a]-x)<Math.abs(arr[b]-x)) {
                list.add(arr[a]);
                a--;
            }
            else if(Math.abs(arr[a]-x)>Math.abs(arr[b]-x)) {
                list.add(arr[b]);
                b++;
            }
            else if(arr[a]<=arr[b]) {
                list.add(arr[a]);
                a--;
            }
        }
        if(a<0){
            while(list.size()<k){

                list.add(arr[b]);
                b++;
            }
        }
        else if(b>=arr.length) {
            while(list.size()<k){
                list.add(arr[a]);
                a--;
            }
        }
        Collections.sort(list);
        return list;
    }
}
