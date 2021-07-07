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
            if(!mapCount.containsKey(element)){
                mapCount.put(element,1);
            }
            else{
                Integer cur=mapCount.get(element);
                mapCount.put(element,cur+1);
            }
        }

        //showing occurence of each value
        System.out.println(mapCount);

        LinkedList<Integer> occList=new LinkedList<>(); //use to store occurence only
        Iterator itr=mapCount.keySet().iterator();
        while (itr.hasNext()) {
            Integer temp= mapCount.get(itr.next()); //get the  value of each key
            occList.add(temp);
        }
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
    }
}
