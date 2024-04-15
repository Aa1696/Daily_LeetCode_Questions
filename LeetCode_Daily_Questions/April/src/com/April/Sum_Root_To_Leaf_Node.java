package com.April;
import java.util.*;
/*
You are given the root of a binary tree containing digits from 0 to 9 only.

Each root-to-leaf path in the tree represents a number.

For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.

A leaf node is a node with no children.
 */

/*
Intuition
Purpose is to traverse from root to the leaf node and maintain the number through out its path and once we reach the leaf node then add into the container and maintain the recursion till all the leaf node is visited from root.

Approach
Maintain the ArrayList to contain the number from root to the leaf node.
At each node we are refactor the num by multiplying curr*10+root.val and if the node is leaf then will and then add the num to the arraylist.
If the node is not leaf node then we can move to its left and right and then check from the left or right can we reach to the leaf node or not
after completion of recursion stack , will run the the for loop into the container and maintain the sum and return the sum
Complexity
Time complexity:
O(size of the tree)

Space complexity:
Recursion call stack
O(size of the binary tree)
 */
public class Sum_Root_To_Leaf_Node {
    ArrayList<Integer>lst;
    public int sumNumbers(TreeNode root) {
        lst = new ArrayList<>();
        helper(root,0);
        int sum =0;
        for(int i:lst){
            sum +=i;
        }
        return sum;
    }
    private void helper(TreeNode root, int ans){
        if(root==null) return;
        ans = ans *10 +root.val;
        if(root.left==null && root.right == null){
            lst.add(ans);
            return;
        }
        helper(root.left,ans);
        helper(root.right,ans);
    }

}
