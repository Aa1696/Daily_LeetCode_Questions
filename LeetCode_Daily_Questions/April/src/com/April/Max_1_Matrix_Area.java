package com.April;
import java.util.*;
/*
Intuition
Prerequisite:
Should know about the Maximum area of the histogram problem

Idea is to use prev smaller and next smaller concept that will help to find the maximum histogram area occupied by the given row which will consist of the height of the each bar.

Approach
Maintain the prev smaller and next smaller function to calculate for the current element which is the next and previous smaller so accordingly will calculate the width.
At each row will maintain the height of the each column if we encounter any cell with value of 1 then will add to the current row height with one.
And then calculate max area by using maxrea function.
At each level will maintain the max area and then will return the max area after traversing the complete row
Complexity
Time complexity:
Max_Area- O(n)
Prev_Smaller - O(n)
Next_samller - O(n)
Matrix traversal- O(nmm)

Space complexity:
prev_arr=column size
next_arr= column size
row=column size
Total - O(size of column)


 */
public class Max_1_Matrix_Area {
    private static int[] getPreviousSmaller(int[] height){
        int n = height.length;
        int[]prev=new int[n];
        Stack<Integer>stck = new Stack<>();
        prev[0] = -1;
        stck.push(0);
        for(int i=1;i<n;i++){
            while(!stck.empty() && height[stck.peek()] >= height[i]){
                stck.pop();
            }
            prev[i] = stck.empty()?-1:stck.peek();
            stck.push(i);
        }
        return prev;
    }
    //calculating next smaller from the current element
    private static int[] getNextSmaller(int[]height){
        int n = height.length;
        int[]next = new int[n];
        next[n-1] = n;
        Stack<Integer>stck = new Stack<>();
        stck.push(n-1);
        for(int i = n-2 ;i>=0 ; i--){
            while(!stck.empty() && height[stck.peek()]>=height[i]){
                stck.pop();
            }
            next[i] = stck.empty()?n:stck.peek();
            stck.push(i);
        }
        return next;
    }
    private static int getMaxArea(int[] height){
        int[] left = getPreviousSmaller(height);
        int[] right = getNextSmaller(height);
        int max = Integer.MIN_VALUE;
        for(int i=0; i<height.length;i++){
            int left_width = height[i]*(i-left[i]-1);
            int right_width = height[i]*(right[i]-i-1);
            max = Math.max(max,left_width + right_width + height[i]);
        }
        return max;
    }
    public int maximalRectangle(char[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[] row = new int[m];
        for(int i=0;i<m;i++){
            if(mat[0][i]=='1'){
                row[i] = 1;
            }
        }
        int ans = Integer.MIN_VALUE;
        //System.out.println("Row="+Arrays.toString(row));
        int val = getMaxArea(row);
        //System.out.println("Value="+val);
        ans = Math.max(ans,val);
        int val1=0;
        for(int i= 1;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]=='1'){
                    row[j] += 1;
                }
                else {
                    row[j] = 0;
                }
            }
            //System.out.println("Row="+Arrays.toString(row));
            val1 = getMaxArea(row);
            ans = Math.max(ans,val1);
            //System.out.println("Value="+val1);
        }
        return Math.max(ans,val1);
    }
}
