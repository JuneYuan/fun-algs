package interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 经纬度编码（标准二分）
 * 输入：带编码的纬度值，比如80
 * 输出：[-90, 90]之间二分搜索输入的纬度值，搜索过程中的生成编码序列，，精度6位。
 * 编码规则为，二分取左边，对应编码0；取右边，对应编码1。80对应的编码就是 111100
 */
public class Tencent1 {

	public static void main(String[] args) {
		// lb 为升序数组中大于等于目标值的最小索引
		// ub 为小于等于目标值的最大索引
		Scanner sc = new Scanner(System.in);
		StringBuilder result = new StringBuilder();
		int target = sc.nextInt();
		
		int lb = -91, ub = 91;
		while (lb + 1 < ub) {
			int mid = (lb + ub) / 2;
			if (mid < target) {
				lb = mid;
				result.append("1");
			} else {
				ub = mid;
				result.append("0");
			}
		}
		
		System.out.println(result.substring(0, 6));
		
		sc.close();
	}

}
