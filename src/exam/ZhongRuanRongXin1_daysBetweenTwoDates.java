package exam;

import java.util.GregorianCalendar;
import java.util.Scanner;

/*
求两个日期之间相差多少天
 */
public class ZhongRuanRongXin1_daysBetweenTwoDates {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		String s1 = in.nextLine();
		String s2 = in.nextLine();
		GregorianCalendar date1 = getDate(s1);
		GregorianCalendar date2 = getDate(s2);
		
        int days = (int) ((date2.getTimeInMillis() - date1.getTimeInMillis()) / (1000*3600*24));
        days = Math.abs(days);
        System.out.println(days);
        
        in.close();
	}
	
	private static GregorianCalendar getDate(String s) {
		String[] nums = s.split("-");
		int year = Integer.parseInt(nums[0]);
		int month = Integer.parseInt(nums[1]);
		int day = Integer.parseInt(nums[2]);
		return new GregorianCalendar(year, month, day);
	}
}
