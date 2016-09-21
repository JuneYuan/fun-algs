package exam;

import java.util.*;

import org.junit.Test;

public class YuanFuDao1_minDeltaSum {
	
	synchronized public int minDelta(int[] A) {
		int result = Integer.MAX_VALUE;
		int total = 0;
		Set<Integer> possibleSumA = new HashSet<>();
		// List<Integer> possibleSumA = new ArrayList<>();
		possibleSumA.add(0);
		
		for (int a : A) {
			total += a;
		}
				
		for (int a : A) {
			/* 这里引入又一个Set对象，暂存新得到的可能的sumA，
			 * 如果直接对possibleSumA执行迭代和add操作，会报ConcurrentModificationException异常
			 */
			Set<Integer> morePossibleSumA = new HashSet<>();
			for (int sumA : possibleSumA) {
				morePossibleSumA.add(sumA + a);
			}
			possibleSumA.addAll(morePossibleSumA);
		}		
		
		for (Integer sumA : possibleSumA) {
			int sumB = total - sumA;
			result = Math.min(result, Math.abs(sumB - sumA));
		}
		
		return result;
	}

	@Test	
	public void test() {
		int[] A = new int[]{1, 2, 5, 9, 6, 4};
		// int[] A = new int[]{1, 2, 3, 4, 5, 13};
		System.out.println(minDelta(A));
	}
}

