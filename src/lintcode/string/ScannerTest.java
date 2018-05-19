package lintcode.string;

import java.util.Scanner;

public class ScannerTest {
	public static void main(String[] args) {
		String s1,s2;
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("请输入第一个字符串："); 
		s1=scanner.next();
		s2=scanner.nextLine();
		System.out.println("请输入第二个字符串：");
		
		s2=scanner.nextLine();	// 无法执行 直接退出了
		System.out.println("输入的字符串是："+s1+s2);
	}
}
