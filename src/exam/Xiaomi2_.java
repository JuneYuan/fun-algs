package exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/* 手机号码替身
 * 映射规则：f(x) = （(x + 8) % 10）的英文大写单词，其中x为手机号码的某一位
 * 输入：若干个f(x)的组成的字符串f(x1)f(x2)...，比如ZEROTWOONE
 * 输出：上述x所能形成的最小数值
 */
public class Xiaomi2_ {
	static int[] vis = new int[200];
	static List<Integer> vc = new ArrayList<>();
	static String[] zm = {
	    "ZERO","ONE","TWO","THREE",
	    "FOUR","FIVE","SIX","SEVEN",
	    "EIGHT","NINE"
	};
	
	static class Order {
		public int a;
		public char c;
		
		public Order(int a, char c) { 
			this.a = a;
			this.c = c;
		}
	}
	static Order[] od = new Order[]{
			new Order(0, 'Z'), new Order(6, 'X'), new Order(7, 'S'), new Order(4, 'U'),
			new Order(5, 'F'), new Order(8, 'G'), new Order(3, 'H'), new Order(9, 'I'),
			new Order(2, 'T'), new Order(1, 'O')
	};
	
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        in.nextLine();
        
        for (int t = 0; t < T; t++) {
        	String line = in.nextLine();        	
        	Arrays.fill(vis, 0);

        	for (int i = 0; i < line.length(); ++i) {
        		vis[(int) line.charAt(i)]++;
        	}
        	
            vc.clear();
            
            for (int i = 0; i < 10; ++i) {
            	int a = od[i].a;
            	char c = od[i].c;
            	for (int j = 0; j < vis[(int)c]; ++j) {
            		vc.add(hs(a));
            	}
            	
            	gao(a, vis[(int) c]);
            }
            
            Collections.sort(vc);
            for (int i = 0; i < vc.size(); ++i) {
            	System.out.printf("%d", vc.get(i));
            }
            System.out.println();
        }

        in.close();
    }
    
    
    private static int hs(int n) {
    	return (n + 2) % 10;
    }

    private static void gao(int i, int j) {
    	for (int k = 0; k < zm[i].length(); ++k) {
    		char ch = zm[i].charAt(k);
    		vis[(int) ch] -= j;
    	}
    }
}

/*
4
EIGHT
ZEROTWOONE
OHWETENRTEO
OHEWTIEGTHENRTEO

*/