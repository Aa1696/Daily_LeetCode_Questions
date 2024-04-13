/*
Intuition
At the given indx , will try to maximise the trap by finding the left mmaximum from the given indx and farthest maximum and minimum of it will hold the water.

Approach
will intialize the low and high and maintain the left and right max from the extreme
at given indx will find the left and right extreme max then which one will be minimum based on that will incerease low and dcrease high
will add he net trap water to the water
at last return toal_net_water
Complexity
Time complexity:
O(n)

Space complexity:
O(1)
 */
package com.April;

public class Rain_Water_Trapped {
    public static int trap(int[] height) {
        int n = height.length;
        int low = 0;
        int high = n-1;
        int left_max = 0;
        int right_max = 0;
        int water = 0;
        while(low < high){
            left_max = Math.max(height[low],left_max);
            right_max = Math.max(height[high],right_max);
            water += left_max<right_max?left_max-height[low++]: right_max-height[high--];
        }
        return water;
    }

    public static void main(String[] args) {
        int[]height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }
}
