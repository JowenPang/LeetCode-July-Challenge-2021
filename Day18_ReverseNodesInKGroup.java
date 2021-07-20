import java.util.Collections;

public class Day18_ReverseNodesInKGroup {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) {
          this.val = val; }
      ListNode(int val, ListNode next) {
          this.val = val; this.next = next; }
  }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int n = 0;
        while (curr != null) {
            n++;
            curr = curr.next;
        }
        curr = head;
        int segment = n / k;
        ListNode start_curr=curr, start_prev = curr;
        for (int i = 0; i < segment; i++) {
            ListNode prev = null;
            start_curr = curr;
            for (int j = 0; j < k; j++) {  //reversing all elements inside segments
                ListNode nextNode = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextNode;
            }
            if (i == 0)//first segment
                head = prev;
            else
                start_prev.next = prev;
            start_prev = start_curr;
        }
        if (start_curr!=null) //remaining element less than k that no need to reverse
            start_curr.next = curr;
        return head;
    }

}
