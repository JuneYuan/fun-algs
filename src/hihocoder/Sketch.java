package hihocoder;

public class Sketch {
	
	private static int[] delete(int[] a, int key) {
		int[] b = new int[a.length-1];
		boolean done = false;
		int i = 0;
		for (int k : a) {
			if (k == key && !done)
				done = true;
			else
				b[i++] = k;
		}
		return b;
	}

	private static int[] add(int[] a, int key) {
		int N = a.length;
		int[] b  = new int[N+1];
		System.arraycopy(a, 0, b, 0, N);
		b[N] = key;
		return b;
	}
	
	public static void main(String[] args) {
		int[] a = {1, 2, 3, 4, 5};
		a = add(a, 6);
		//a = delete(a, 4);
	}

}
