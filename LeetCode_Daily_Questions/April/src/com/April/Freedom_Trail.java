package com.April;
import java.util.*;
/*
In the video game Fallout 4, the quest "Road to Freedom" requires players to reach a metal dial called the "Freedom Trail Ring" and use the dial to spell a specific keyword to open the door.

Given a string ring that represents the code engraved on the outer ring and another string key that represents the keyword that needs to be spelled, return the minimum number of steps to spell all the characters in the keyword.

Initially, the first character of the ring is aligned at the "12:00" direction. You should spell all the characters in key one by one by rotating ring clockwise or anticlockwise to make each character of the string key aligned at the "12:00" direction and then by pressing the center button.

At the stage of rotating the ring to spell the key character key[i]:

You can rotate the ring clockwise or anticlockwise by one place, which counts as one step. The final purpose of the rotation is to align one of ring's characters at the "12:00" direction, where this character must equal key[i].
If the character key[i] has been aligned at the "12:00" direction, press the center button to spell, which also counts as one step. After the pressing, you could begin to spell the next character in the key (next stage). Otherwise, you have finished all the spelling.

 */
public class Freedom_Trail {
        public int findRotateSteps(String ring, String key) {
            ArrayList<Integer>[]adj = new ArrayList[26];
            for(int i=0;i<ring.length();i++){
                int indx = ring.charAt(i) - 'a';
                if(adj[indx] == null){
                    adj[indx] = new ArrayList<>();
                }
                adj[indx].add(i);
            }
            int[][]dp = new int[key.length()][ring.length()];
            return helper(0,0,adj,key,ring,dp);
        }
        public int helper(int indx,int pos,ArrayList<Integer>[]adj,String key, String ring , int[][]dp){
            if(indx==key.length()){
                return 0;
            }
            if(dp[indx][pos] != 0) return dp[indx][pos];
            char ch = key.charAt(indx);
            int min = Integer.MAX_VALUE;
            for(int v:adj[ch-'a']){
                int steps = Math.min(Math.abs(v-pos), ring.length()-Math.abs(v-pos));
                int tot = steps + helper(indx+1,v,adj,key,ring,dp);
                min = Math.min(min,tot);
            }
            return dp[indx][pos] = min+1;
        }
}
