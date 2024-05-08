package May_Practise;
import java.util.*;
public class Relative_Rank {
    static ArrayList<ArrayList<Integer>>ans;
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        // code here
        ans = new ArrayList<>();
        helper(root,new ArrayList<Integer>());
        return ans;
    }
    public static void helper(Node root, ArrayList<Integer>curr){
        if(root == null) return;
        curr.add(root.data);
        if(root.left == null && root.right == null){
            ans.add(new ArrayList<>(curr));
            curr.remove(curr.size()-1);
            return;
        }
        helper(root.left,curr);
        helper(root.right,curr);
        curr.remove(curr.size()-1);
    }
}
