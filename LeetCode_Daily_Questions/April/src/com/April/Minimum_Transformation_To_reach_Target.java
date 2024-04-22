package com.April;
import java.util.*;
/*
You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'. Each move consists of turning one wheel one slot.

The lock initially starts at '0000', a string representing the state of the 4 wheels.

You are given a list of deadends dead ends, meaning if the lock displays any of these codes, the wheels of the lock will stop turning and you will be unable to open it.

Given a target representing the value of the wheels that will unlock the lock, return the minimum total number of turns required to open the lock, or -1 if it is impossible.
 */
/*
Intuition
It is almost same as the Word Ladder problem 1, so will be using level order BFS approach to reach the destination. At the given level all the valid transformation new_string level will be curr_string level +1 and so at any given level given word is equal to the target then will return the given level.

Approach
Will maintain the set of the deadwords and check the "0000" exist in the set or not , if "0000" exists then will return -1 as we can not do any transforamtion on the very starting string.
Will maintain the visited set of the transformed word so after tranformation of the given word will check it does not exist in visited and in deadwords too.
will maintain the que to store the word at the geiven level and transformation will be done at all the character of the given level word.
Tranformation will be done by subtracting 1 and adding 1 to the given character by adding 10 and then modolu the whole number by 10 in order to maintain the 0-9 characters in the word.
If it is valid then will mark it visited and then store it in the que with 1 increased level from the current level along with word.
Complexity
Time complexity:
At each level we are doing following transformations:
loop of 4 length
and for each character we will move left and right
for each left and right operation cumalitive time complexity is :O(4)
O(level*4)

Space complexity:
visited - O(total valid transforemd words)
deadwords set- O(size of dead words)
 */
class Pair{
    String str;
    int val;
    Pair(String str, int val){
        this.str = str;
        this.val =val;
    }
}
public class Minimum_Transformation_To_reach_Target {
    public int openLock(String[] deadends, String target) {
        //Will maintain the set for all the non-visited string
        Set<String>st = new HashSet<>(Arrays.asList(deadends));
        if(st.contains("0000")){
            return -1;
        }
        Deque<Pair>que = new ArrayDeque<>();
        que.add(new Pair("0000",0));
        Set<String>visited = new HashSet<>();
        visited.add("0000");
        while(!que.isEmpty()){
            Pair p = que.poll();
            String str = p.str;
            int level = p.val;
            if(target.equals(str)) return level;
            for(int i=0;i<4;i++){
                for(int dgt:new int[]{-1,1}){
                    int curr_digit = (str.charAt(i)-'0' + dgt + 10)%10;
                    String new_str = str.substring(0,i) + curr_digit + str.substring(i+1);
                    if(!visited.contains(new_str) && !st.contains(new_str)){
                        visited.add(new_str);
                        que.add(new Pair(new_str,level+1));
                    }
                }
            }
        }
        return -1;
    }
}
