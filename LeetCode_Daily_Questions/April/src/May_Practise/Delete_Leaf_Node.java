package May_Practise;
import javax.swing.tree.TreeNode2

;
import  java.util.*;
class TreeNode2

 {
    int val;
      TreeNode2

 left;
      TreeNode2

 right;
     TreeNode2

() {}
     TreeNode2

(int val) { this.val = val; }
     TreeNode2

(int val, TreeNode2

 left, TreeNode2

 right) {
         this.val = val;
         this.left = left;
          this.right = right;
     }
}
public class Delete_Leaf_Node {
    public TreeNode2

 removeLeafNodes(TreeNode2

 root, int target) {
        if(root == null){
            return null;
        }
        root.left = removeLeafNodes(root.left,target);
        root.right = removeLeafNodes(root.right,target);
        if(root.left == null && root.right == null && root.val == target){
            return null;
        }
        return root;
    }
}
