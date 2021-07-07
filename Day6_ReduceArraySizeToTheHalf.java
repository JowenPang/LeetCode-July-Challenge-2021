import java.util.*;

public class Day6_ReduceArraySizeToTheHalf {
    public static void main(String [] args){
        int [] arr=new int[]{9,77,63,22,92,9,14,54,8,38,18,19,38,68,58,19};
        System.out.println(minSetSize(arr));
    }
    public static int minSetSize(int[] arr) {
        Map<Integer,Integer> mapCount=new HashMap<>();
        //key storing the value in array
        //value storing its occurence

        for (int element :arr) {
            mapCount.put(element,mapCount.getOrDefault(element,0)+1);
        }

        System.out.println(mapCount);  //showing occurence for each value

        LinkedList<Integer> occList=new LinkedList<>(mapCount.values()); //convert hashmap collections of values into list
        Collections.sort(occList);
        System.out.println(occList);
        int count=0;
        int min=0;

        //remove from the highest occurence to minimize set of integer we need to remove
        while(count<arr.length/2){
            count+= occList.removeLast();
            min+=1;
        }
        return min;





        //Example using LinkedhashMap
      /*  Map<Integer,Integer> mapCount2=new LinkedHashMap<>();
        for (int element :arr) {
            if(!mapCount2.containsKey(element)){
                mapCount2.put(element,1);
            }
            else{
                Integer cur=mapCount2.get(element);
                mapCount2.put(element,cur+1);
            }
        }

        System.out.println(mapCount2);*/

        //example using treemap
      /*  Map<Integer,Integer> mapCount3=new TreeMap<>();
        for (int element :arr) {
            mapCount3.put(element,mapCount3.getOrDefault(element,0)+1);
        }
        System.out.println(mapCount3);*/


    }
}
