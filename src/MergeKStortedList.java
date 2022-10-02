import java.util.LinkedList;

public class MergeKStortedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        LinkedList<ListNode> l = new LinkedList<>();
        while(!reachedEnd(lists)){
            int min = Integer.MAX_VALUE;
            int minInd = -1;
            for(int i = 0; i < lists.length; i++){
                if(lists[i] == null) continue;
                if(lists[i].val < min){
                    min = lists[i].val;
                    minInd = i;
                }
            }
            l.add(lists[minInd]);
            lists[minInd] = lists[minInd].next;
        }
        for(int i = 0; i < l.size()-1; i++) l.get(i).next = l.get(i+1);
        return (!l.isEmpty()) ? l.getFirst() : null;

    }

    private boolean reachedEnd(ListNode[] ln) {
        boolean contains = true;
        for(ListNode n : ln) contains &= (n == null);
        return contains;
    }
}
