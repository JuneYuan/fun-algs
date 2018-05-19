package interview.sort;

import java.util.Arrays;
public class Test {

    public static void arrange1(Integer[] a) {
        int N = a.length;    
        
        int i = 0, j = N-1;
        while (true) {
            while (a[i] < 0) {
            	i++;
                if (i >= N)    break;
            }
               
            while (a[j] >= 0) {
            	j--;
                if (j <= 0)    break;
            }
                
            if (i > j)
                break;
                
            exch(a, i, j);
//System.out.println(Arrays.toString(a));            
        }
    }
    
    public static void arrange2(Integer[] a) {
        int N = a.length;    
        
        int i = 0, j = N-1;
        while (true) {
            while (a[i] <= 0) {	// 从左往右，碰到一个正数才能停下
            	i++;
                if (i >= N)    break;
            }
               
            while (a[j] != 0) {	// 从右往左，碰到零才能停下
            	j--;
                if (j <= 0)    break;
            }
                
            if (i > j)
                break;
                
            exch(a, i, j);
//System.out.println(Arrays.toString(a));            
        }
    }

    
    
    private static void exch(Integer[] a, int i, int j) {
        int t = a[i];  
        a[i] = a[j];
        a[j] = t;
    }


    public static void main(String[] args) {
        Integer[] arr = {-5, 0, 1, 9, 0, -7, -3, 0, 2, 0, 8, 0, 6};
        arrange1(arr);
        arrange2(arr);
        System.out.println(Arrays.toString(arr));
    }
}