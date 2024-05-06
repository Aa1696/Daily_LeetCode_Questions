package May_Practise;
import java.util.*;
public class Delete_Nodes {
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> stck = new Stack<>();
        ListNode tmp = head;
        while (tmp != null) {
            while (!stck.empty() && stck.peek().val < tmp.val) {
                stck.pop();
            }
            stck.push(tmp);
            tmp = tmp.next;
        }
        ListNode prev = null;
        while (!stck.empty()) {
            ListNode tmp1 = stck.pop();
            tmp = tmp1;
            tmp.next = prev;
            prev = tmp;
        }
        return tmp;
    }
}
