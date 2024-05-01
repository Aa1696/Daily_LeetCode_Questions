package May_Practise;
class Node{
    char data;
    Node next;
    Node(char ch){
        this.data = ch;
    }
}
public class Arrange_Consonants_And_Vowels {
    public Node arrangeCV(Node head){
        //write code here and return the head of changed linked list
        Node dum = new Node('#'), tmp = dum, prev = null, curr = head, con = null;
        while(curr != null) {
            char c = curr.data;
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                tmp.next = curr;
                tmp = tmp.next;
                if(prev == null) {
                    Node p = curr.next;
                    curr.next = null;
                    curr = p;
                } else {
                    prev.next = curr.next;
                    curr.next = null;
                    curr = prev.next;
                }
            } else {
                if(con == null)
                    con = curr;
                prev = curr;
                curr = curr.next;
            }
        }
        tmp.next = con;
        return dum.next;
    }
}
