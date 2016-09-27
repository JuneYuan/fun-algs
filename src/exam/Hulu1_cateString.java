package exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/* 拼接最长字符串
 * 给一个字符串数组，求其中一个字符串，它能由数组中另外两个串组成，且为最长
 * 输入：一行表示字符串数组，以空格分隔。如
 * test teststring string testing 
 */
public class Hulu1_cateString {	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] line = sc.nextLine().split(" ");
		List<String> strs = new ArrayList<>();
		HashSet<String> lookup = new HashSet<>();
		for (String str : line) {
			strs.add(str);
			lookup.add(str);
		}
		
		String result = "";
		for (String str : strs) {
			// the seprator, i, can be [1, Len - 1]
			for (int i = 1; i < str.length(); i++) {
				String leftHalf = str.substring(0, i);
				String rightHalf = str.substring(i);
				if (lookup.contains(leftHalf) && lookup.contains(rightHalf)) {
					result = str.length() > result.length() ? str : result;
				}
			}
		}
		
		System.out.println(result);
		
		sc.close();
	}


}
