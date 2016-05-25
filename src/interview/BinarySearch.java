package interview;

public class BinarySearch {
	
	/*
	 * 二分法寻找上届
	 * 与精确查找不同之处在于，精确查找分成三类：大于，小于，等于（目标数）。而界限查找则分成了两类：大于和不大于。
	 * 如果当前找到的数大于目标数时，它可能就是我们要找的数，所以需要保留这个索引，也因此if (array[mid] > target)时 high=mid; 而没有减1。
	 */
	private static int nrBinSearchUpperBound(int[] a, int key) {
		int lo = 0, hi = a.length - 1;		
		if (hi == 0 || key >= a[hi])	return -1;  // 数组为空或最大值尚比key小

		int md = (lo + hi) / 2;
		while (lo < hi) {
			if (a[md] > key)
				hi = md;
			else
				lo = md + 1;

			md = (lo + hi) / 2;
		}
		return md;
	}

	
	/*
	 * 非递归二分查找
	 * 若找到：返回查找元素的下标；
	 * 未找到：返回合适插入位置的数组下标
	 */	
	private static int nrBinSearch(int[] a, int key) {
		int lo = 0, hi = a.length - 1;
		int md = (lo + hi) / 2;
		
		while (lo <= hi) {
			md = (lo + hi) / 2;
			if (a[md] == key)
				return md;
			else if (a[md] > key) {
				hi = md - 1;
			} else {
				lo = md + 1;
			}
		}
		return lo;
	}

	/*
	 * 递归方法实现二分查找
	 * 若找到：返回查找元素的下标；
	 * 未找到：返回合适插入位置的数组下标
	 */		
	private static int rBinSearch(int[] a, int key) {
		return rBinSearch(a, key, 0, a.length-1);
	}

	private static int rBinSearch(int[] a, int key, int lo, int hi) {
		if (lo > hi)
			return lo;	// 查找失败
		
		int md = (lo + hi) / 2;
		if (a[md] == key)
			return md;	// 查找成功
		else if (a[md] > key) {
			return rBinSearch(a, key, lo, md-1);	
		} else {
			return rBinSearch(a, key, md+1, hi);
		}
		
	}
		
	public static void main(String[] args) {
		int[] array = {1 ,4 ,5 ,8 ,15 ,33 ,48 ,77 ,96};
		//System.out.println(nrBinSearch(array, 16));
		
for (int x : array)
	System.out.println(nrBinSearch(array, x+1));

	}

}
