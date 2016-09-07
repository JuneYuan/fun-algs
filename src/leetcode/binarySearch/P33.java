package leetcode.binarySearch;

import org.junit.Test;

public class P33 {
	// 直接解法：比较target与A[mid]，并分析各种情况进行讨论
	public int search_straight(int[] A, int target) {
		if (A == null || A.length == 0)		return -1;
		
		int lb = 0, ub = A.length - 1;
		while (lb <= ub) {
			int mid = (lb + ub) / 2;
			if (A[mid] == target) {
				return mid;
			}
			
			if (target < A[mid]) {
				if (A[mid] < A[lb]) {	// mid在断点右侧
					ub = mid - 1;
				} else {
					if (target < A[lb]) {
						lb = mid + 1;
					} else {
						ub = mid - 1;
					}
				}
			} else {
				if (A[mid] < A[lb]) {	// mid在断点右侧
					if (target < A[lb]) {
						lb = mid + 1;
					} else {
						ub = mid - 1;
					}
				} else {
					lb = mid + 1;
				}
			}
		}
		
		return -1;
	}

	// 更巧妙的解法：通过比较A[lb]与A[mid]，来找出局部有序数组
    public int search_smart(int[] A, int target) {
    	if (A == null || A.length == 0)		return -1;
    	
    	int lb = 0, ub = A.length - 1;
    	while (lb <= ub) {
    		int mid = (lb + ub) / 2;
    		if (A[mid] == target) {
    			return mid;
    		}
    		
    		if (A[mid] < A[lb]) {
    			// case1: numbers between mid and ub are sorted
    			if (A[mid] < target && target <= A[ub]) {
    				lb = mid + 1;
    			} else {
    				ub = mid - 1;
    			}
    		} else {
    			// case2: numbers between A[lb] and A[mid] are sorted
    			if (A[lb] <= target && target < A[mid]) {
    				ub = mid - 1;
    			} else {
    				lb = mid + 1;
    			}
    		}
    	}
    	    	
    	return -1;
    }

    @Test
    public void test() {
    	int[] C = {1, 3, 5};
    	int[] B = {3, 1};
    	int[] A = {4, 5, 6, 7, 0, 1, 2};
    	int target = 0;
    	System.out.println(search_straight(C, 1));
    }
}
