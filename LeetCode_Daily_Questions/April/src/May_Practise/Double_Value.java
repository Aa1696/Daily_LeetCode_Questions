package May_Practise;
import java.util.*;
class ListNode1 {
      int val;
      ListNode1 next;
      ListNode1() {}
      ListNode1(int val) { this.val = val; }
      ListNode1(int val, ListNode1 next) { this.val = val; this.next = next; }
  }
public class Double_Value {
    public ListNode1 doubleIt(ListNode1 head) {
        Stack<Integer> stck = new Stack<>();
        ListNode1 curr = head;
        while (curr != null) {
            stck.push(curr.val);
            curr = curr.next;
        }
        int val = 0;
        ListNode1 tail = null;
        while (!stck.empty() || val != 0) {
            tail = new ListNode1(0, tail);
            if (!stck.empty()) {
                val += stck.pop() * 2;
            }
            tail.val = val % 10;
            val = val / 10;
        }
        return tail;
    }

}
