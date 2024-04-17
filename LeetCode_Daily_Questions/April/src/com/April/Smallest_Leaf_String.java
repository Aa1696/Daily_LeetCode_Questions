package com.April;
/*
You are given the root of a binary tree where each node has a value in the range [0, 25] representing the letters 'a' to 'z'.

Return the lexicographically smallest string that starts at a leaf of this tree and ends at the root.

As a reminder, any shorter prefix of a string is lexicographically smaller.

For example, "ab" is lexicographically smaller than "aba".
A leaf of a node is a node that has no children.
 */
/*
Intuition
Intution is to use dfs approach and maintain the string from root to the leaf node and once we reach at the leaf will reverse the string and compare with already found string to leaf if it is smaller then will replace the ans with current one

Approach
Maintain the global StringBuilder ans and current String to maintain the path from root to the leaf
At given node will check is it leaf node is null,if null will return to the parent function
If it leaf then check the curr string by reversing is it smaller than ans or not if it is smaller then replace it with current string
We are also maintainting the path by adding the char value of the corresponding node value and moving left and right to the current node
After completion of the dfs traversal will return ans by converting it into the string
Complexity
Time complexity:
O(all nodes)

Space complexity:
O(recursion call stack)
 */
public class Smallest_Leaf_String {
    StringBuilder ans;
    public String smallestFromLeaf(TreeNode root) {
        String str = "";
        ans = new StringBuilder();
        dfs(root,str);
        return ans.toString();
    }
    public void dfs(TreeNode root, String str){
        if(root==null)return;
        if(root.left == null && root.right == null){
            char ch= (char)(root.val + 'a');
            str +=ch;
            String str1=new StringBuilder(str).reverse().toString();
            if(ans.isEmpty()){
                ans = new StringBuilder(str1);
                return;
            }
            int val = str1.compareTo(ans.toString());
            if(val<0){
                ans = new StringBuilder(str1);
            }
            return;
        }
        char ch = (char)(root.val + 'a');
        str +=ch;
        dfs(root.left,str);
        dfs(root.right,str);
    }
}
