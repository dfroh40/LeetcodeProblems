public class AddTwoNumbers {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode solution = new ListNode();
        ListNode curr1 = l1;
        ListNode curr2 = l2;
        ListNode curr3 = solution;
        int carry = 0;
        while(curr1 != null && curr2 != null){
            int i1 = curr1.val;
            int i2 = curr2.val;
            curr3.next = new ListNode((i1 + i2 + carry) % 10);
            if(i1 + i2 + carry > 9){
                carry = 1;
            } else {
                carry = 0;
            }
            if(curr1.next == null && curr2.next != null){
                curr1.next = new ListNode(0);
            }
            if(curr2.next == null && curr1.next != null){
                curr2.next = new ListNode(0);
            }
            if(curr1.next == null && curr2.next == null && carry == 1){
                curr1.next = new ListNode(0);
                curr2.next = new ListNode(0);
            }
            curr1 = curr1.next;
            curr2 = curr2.next;
            curr3 = curr3.next;
        }
        solution = solution.next;
        return solution;
    }
}
