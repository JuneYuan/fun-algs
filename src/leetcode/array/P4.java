package leetcode.array;

public class P4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length+nums2.length;
        int[] aux = new int[len/2 + 1];
        int i = 0, j = 0;
        double ret = 0;
        
        for (int k = 0; k < aux.length; k++) {
            if (i >= nums1.length)          aux[k] = nums2[j++];
            else if (j >= nums2.length)     aux[k] = nums1[i++];
            else if (nums1[i] < nums2[j])   aux[k] = nums1[i++];
            else    aux[k] = nums2[j++];
        }
        
        ret = aux[aux.length-1];
        if (len % 2 == 0)
            ret = (ret + aux[aux.length-2]) / 2;
        return ret;
    }

}
