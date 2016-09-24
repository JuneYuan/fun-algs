package basis.datastruct;

import java.util.ArrayList;

// 啥时候swim？啥时候sink？
public class MaxHeap {
	ArrayList<Integer> heap;
	
	public MaxHeap(ArrayList<Integer> A) {
		if (A == null || A.size() == 0) {
			heap = new ArrayList<>();
		} else {
			heap = maxHeapify(A);
		}
	}
	
	public void push(int x) {
		heap.add(x);
		swim(heap, heap.size() - 1);
	}

	public Integer pop() {
		swap(heap, 0, heap.size() - 1);
		Integer x = heap.get(0);
		heap = (ArrayList) heap.subList(1, heap.size());
		return x;
	}
	
	private ArrayList<Integer> maxHeapify(ArrayList<Integer> A) {
		for (int i = A.size(); i >= 0; i--) {
			sink(A, i);
		}
		return A;
	}

	// move the node down the tree
	private void sink(ArrayList<Integer> A, int i) {
		int L = 2 * i + 1, R = L + 1;
		int mxIdx = i;
		
		if (L < A.size() && A.get(L) > A.get(mxIdx)) {
			mxIdx = L;
		}
		if (R < A.size() && A.get(R) > A.get(mxIdx)) {
			mxIdx = R;
		}
		
		if (mxIdx != i) {
			swap(A, i, mxIdx);
			sink(A, mxIdx);
		}
	}

	private void swim(ArrayList<Integer> A, int i) {
		if (i == 0)	 return;
		int father = (i - 1) / 2;
		if (A.get(father) < A.get(i)) {
			swap(A, i, father);
			swim(A, father);
		}
	}

	private void swap(ArrayList<Integer> A, int a, int b) {
		int t = a;
		A.set(a, b);
		A.set(b, t);
	}
}
