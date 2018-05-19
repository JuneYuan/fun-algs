package exam;

import java.util.*;

/* 
输入N，输出0～N之间每个数的二进制中1的个数
 */
public class YiDian1_bitCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
        	int cnt = bitCount(i);
        	result.add(cnt);
        }
        
        String s = result.toString();
        s = s.replaceAll(" ", "");
        System.out.println(s);
        
        sc.close();
    }
	
	
    private static int bitCount(int d) {
        int cnt = 0;
        while (d > 0) {
            cnt++;
            d &= (d - 1);
        }
        
        return cnt;
    }

}
