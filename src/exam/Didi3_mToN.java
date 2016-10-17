package exam;

import java.util.Scanner;

// 十进制数M转换为N进制数
public class Didi3_mToN {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int M = in.nextInt();
        int N = in.nextInt();
        
        if (M < 0) {
        	String result = decimalToX(-M, N);
        	System.out.println("-" + result);
        } else {
	        String result = decimalToX(M, N);
	        System.out.println(result);
        }
        in.close();
    }

    private static String decimalToX(int decimal, int m) {
    	StringBuilder sb = new StringBuilder();
    	
    	String[] map = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
    			"A", "B", "C", "D", "E", "F"};
    	
    	while (decimal > 0) {
    		int i = decimal % m;
    		String temp = map[i];
    		sb.append(temp);
    		decimal /= m;
    	}
    	    	
    	return sb.reverse().toString();
    }
}
