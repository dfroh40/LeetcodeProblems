import java.util.*;

public class ReverseNodeInkGroup {

     public class ListNode {
            int val;
            ListNode next;
            ListNode() {}
            ListNode(int val) { this.val = val; }
            ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head.next == null) return head;
        int count = 0;
        List<ListNode> lst = new ArrayList<>();
        ListNode curr = head;
        while(curr != null){
            if(count % k == 0) lst.add(curr);
            curr = curr.next;
            count++;
        }
        for(ListNode n : lst) System.out.println(n.val);
        return null;
    }
}
