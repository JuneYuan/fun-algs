package mioj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MiOJ75 {
	private static String solution(String line) {
	    // 在此处理单行数据
		String[] inputs = line.split(",");
		int[] arr = new int[inputs.length];
		for (int i = 0; i < inputs.length; i++) {
			arr[i] = Integer.parseInt(inputs[i].trim());
		}
		Arrays.sort(arr);
	
		if (arr == null || arr.length == 0) {
			return "0";
		}
		
		if (arr.length == 1) {
			return "1";
		}
		
		int sum = 0;
		List<Integer> subArr1 = new ArrayList<>();
		List<Integer> subArr2 = new ArrayList<>();
		for (int i = 0; i < arr.length;) {
			int cur = arr[i];
			subArr1.add(cur);
			
			while (++i < arr.length && arr[i] == cur) {
				subArr1.add(cur);
			}

			if (i < arr.length) {
				cur = arr[i];
				subArr2.add(cur);
			}
			
			while (++i < arr.length && arr[i] == cur) {
				subArr2.add(cur);
			}
/*			subArr1.add(arr[i]);
			if (i + 1 < arr.length) {
				subArr2.add(arr[i + 1]);
			}*/
		}
		
		sum += solve(subArr1);
		sum += solve(subArr2);
		int sz1 = subArr1.size(), sz2 = subArr2.size();
		if (sz1 == sz2 && subArr1.get(sz1 - 1) != subArr2.get(sz2 - 1)) {
			sum += 1;
		}
		
	    // 返回处理后的结果
	    return Integer.toString(sum);
	}
	
	private static int solve(List<Integer> arr) {
		int result = 0;
		int cursor = 0;
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i) < 1) {
				continue;
			}
			
			if (i == 0 || arr.get(i) > arr.get(i - 1)) {
				cursor++;
			}
			result += cursor;
		}
		return result;
	}
	
	public static void main(String[] args) {
		String line1 = "96";
		String line2 = "19,9,35,74,22";
		String line3 = "52,82,16,29,54,14,17,98,45,24,37,6,10,87,59,19,94,72,91,76,3,99,56,60,66,2,86,0,56,20,73,10,46,16,29,3,74,49,23,9,51,18,56,55,25,23,89,71,74,82,67,57,69,9,98,34,18,33,26,48,3,63";
		System.out.println(solution(line3));
		System.out.println(solution(line3));
		System.out.println(solution(line3));
	}
}
