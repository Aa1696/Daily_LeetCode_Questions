package May_Practise;
import java.util.*;
public class Positive_Integer_With_Negative {
    public int findMaxK(int[] nums) {
        Set<Integer>st = new HashSet<>();
        for(int i:nums){
            if(i<0){
                st.add(i);
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i:nums){
            if(i>0){
                if(st.contains(-i)){
                    max = Math.max(max,i);
                }
            }
        }
        return max != Integer.MIN_VALUE?max:-1;
    }
}
