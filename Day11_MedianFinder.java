import java.util.LinkedList;
import java.util.PriorityQueue;

class Day11_MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    /** initialize your data structure here. */
    public Day11_MedianFinder() {
        maxHeap=new PriorityQueue<>((x,y)-> Integer.compare(y,x)); //reverse Order
        minHeap=new PriorityQueue<>();

    }

    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if(maxHeap.size()<minHeap.size())
            maxHeap.offer(minHeap.poll());
    }

    public double findMedian() {
        if(maxHeap.size()==0)
            return 0;
        if(maxHeap.size()>minHeap.size())
            return maxHeap.peek();
        else
            return (double)(maxHeap.peek()+minHeap.peek())/2;

    }
    public static void main(String [] args){
        Day11_MedianFinder median=new Day11_MedianFinder();
        median.addNum(-1);
        System.out.println(median.findMedian());
        median.addNum(-2);
        System.out.println(median.findMedian());
        median.addNum(-3);
        System.out.println(median.findMedian());
        median.addNum(-4);
        System.out.println(median.findMedian());
        median.addNum(-5);
        System.out.println(median.findMedian());
    }

}