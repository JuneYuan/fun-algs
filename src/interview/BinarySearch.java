package interview;

public class BinarySearch {
	
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
		return hi;
	}

	
	private static int rBinSearch(int[] a, int key) {
		return rBinSearch(a, key, 0, a.length-1);
	}

	private static int rBinSearch(int[] a, int key, int lo, int hi) {
		if (lo > hi)
			return hi;
		
		int md = (lo + hi) / 2;
		if (a[md] == key)
			return md;
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
