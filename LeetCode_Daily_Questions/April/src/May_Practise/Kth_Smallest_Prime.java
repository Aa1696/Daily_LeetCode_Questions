package May_Practise;
import java.util.*;
public class Kth_Smallest_Prime {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<int[]>pq = new PriorityQueue<>(Comparator.comparingDouble(a -> (double)a[0]/a[1]));
        int n = arr.length;
        for(int i=0;i<n;i++){
            for(int j = i+1;j<n;j++){
                pq.add(new int[]{arr[i],arr[j]});
            }
        }
        int[]ans = null;
        for(int i=0;i<k;i++){
            ans = pq.poll();
        }
        return ans;
    }
}
