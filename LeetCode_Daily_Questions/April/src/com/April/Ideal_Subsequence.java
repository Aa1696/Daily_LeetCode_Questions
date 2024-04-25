package com.April;
/*
You are given a string s consisting of lowercase letters and an integer k. We call a string t ideal if the following conditions are satisfied:

t is a subsequence of the string s.
The absolute difference in the alphabet order of every two adjacent letters in t is less than or equal to k.
Return the length of the longest ideal string.

A subsequence is a string that can be derived from another string by deleting some or no characters without changing the order of the remaining characters.

Note that the alphabet order is not cyclic. For example, the absolute difference in the alphabet order of 'a' and 'z' is 25, not 1.
 */
public class Ideal_Subsequence {
    public int longestIdealString(String s, int k) {
        //Longest Increasing Subsequence
        int n = s.length();
        int[]dp = new int[27];
        for(int i = n-1 ;i>=0;i--){
            char ch = s.charAt(i);
            int indx = ch -'a';
            int left = Math.max(indx-k,0);
            int right = Math.min(indx+k,26);
            int max = Integer.MIN_VALUE;
            for(int j= left;j<=right;j++){
                max = Math.max(max,dp[j]);
            }
            dp[indx] = max+1;
        }
        int max = Integer.MIN_VALUE;
        for(int ele :dp){
            max = Math.max(ele,max);
        }
        return max;
    }
}
