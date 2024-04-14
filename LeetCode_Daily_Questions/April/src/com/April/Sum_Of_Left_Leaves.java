package com.April;
import java.util.*;
/*
Given the root of a binary tree, return the sum of all left leaves.

A leaf is a node with no children. A left leaf is a leaf that is the left child of another node.
 */
/*
Intuition
Idea is to check if the left child exist for the given node or not then check if its left is leaf or not while doing bfs or dfs traversal. I have used bfs traversal

Approach
Maintain the queue and insert it with root node
Maintain while loop tille all nodes are traversed
At each level will check it has left child or not
if it has left child then will check is it null or not
if left child is null then wll add to the net sum
And, will store the left child in the queue
and , will also store the right child too inorder to traverse all the node and at each node we are checking is it having left child as leaf or not.
After traversing all the node will return the net_sum of the all left sided leaf node.
Complexity
Time complexity:
Traversing the all node
O(n)

Space complexity:
Using queu, at the given time it hold maximum node given at the given level
O(length of the given level)

 */
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val=val;
        this.left=null;
        this.right=null;
    }
}
public class Sum_Of_Left_Leaves {
    public int sumOfLeftLeaves(TreeNode root) {
        //will do level order traversing and check for every node
        //does it have left children or not if yes
        //then check it children is leaf or not.

        Queue<TreeNode>que = new LinkedList<>();
        que.add(root);
        int sum =0;
        while(!que.isEmpty()){
            TreeNode nd = que.poll();
            if(nd.left != null){
                //checking if left child of the given node is leaf or not
                //if left child exists for the given node
                if(nd.left.left==null && nd.left.right==null){
                    sum += nd.left.val;
                }
                que.add(nd.left);
            }
            if(nd.right != null){
                que.add(nd.right);
            }
        }
        return sum;
    }
}
