package com.April;
import java.util.*;
/*
Given the root of a binary tree and two integers val and depth, add a row of nodes with value val at the given depth depth.

Note that the root node is at depth 1.

The adding rule is:

Given the integer depth, for each not null tree node cur at the depth depth - 1, create two tree nodes with value val as cur's left subtree root and right subtree root.
cur's original left subtree should be the left subtree of the new left subtree root.
cur's original right subtree should be the right subtree of the new right subtree root.
If depth == 1 that means there is no depth depth - 1 at all, then create a tree node with value val as the new root of the whole original tree, and the original tree is the new root's left subtree.
 */
/*
Intuition
Will do Level Order Traversal in iterative fashion and when we reach at depth-1 , will create new node node to the current level of not null node with the new Node of the val and store the left and right of th curr node and inserting the new node to the left and right of the current node then accoringly will add the actual left and right to the current new node

Approach
Will maintain the Queue to store the element of given level
once I reach depth -1 then will store the current node left and right refrence and then create two refrence at the left and right on it.
After creating the left and right then in the new left and right will refrence with node original left and right.
After completion at the depth-1 will return root of the tree
Complexity
Time complexity:
At the worse case will traver all the levels of the node and hence it will lead to the traversal of the all nodes
O(n)

Space complexity:
We are using Queue to store the node at the given level
O(max size of the que at the given level)
 */
public class Add_Row_With_Value {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        //Will do level order traversal and at d-1
        //level will create all new node with val for the non null node
        if(depth==1){
            TreeNode tmp = new TreeNode(val);
            tmp.left = root;
            root = tmp;
            return root;
        }
        Deque<TreeNode>que = new ArrayDeque<>();
        que.add(root);
        int level =1;
        while(!que.isEmpty()){
            int sz = que.size();
            if(level == depth -1){
                for(int i=0;i<sz;i++){
                    TreeNode nd = que.poll();
                    TreeNode left = nd.left;
                    TreeNode right = nd.right;
                    nd.left = new TreeNode(val);
                    nd.right = new TreeNode(val);
                    nd.left.left = left;
                    nd.right.right = right;
                }
                return root;
            }
            else{
                for(int i=0;i<sz;i++){
                    TreeNode nd = que.poll();
                    if(nd.left != null){
                        que.add(nd.left);
                    }
                    if(nd.right != null){
                        que.add(nd.right);
                    }
                }
            }
            level++;
        }
        return root;
    }
}
