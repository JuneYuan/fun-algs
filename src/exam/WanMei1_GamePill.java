package exam;
import java.util.Scanner;

/* 玩家使用经验丹升级
 * 
 * 题意梳理以后就是：一个游戏，涉及玩家的经验值、等级、经验丹效力三个量。
 * 经验值决定等级，初始经验值为0级别为1，经验值达到200为2级，达到400为3级，达到600为4级，以此类推。
 * 等级决定了使用一个“经验丹”能获得的经验值增量：1级可获3点经验，2级可获6点，3级可获12点，4级可获24点，以此类推。
 * 问题：新手玩家连续使用n个经验丹后能达到多少等级？（玩家完成新手任务已经获得了75点经验）
 * 
 * 输入：经验丹个数n
 * 输出：正确的等级
 * 
 * 一个简单的数列计算问题。用程序预处理出数列每一项，然后根据输入下标返回对应项即可。
 */
public class WanMei1_GamePill {
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] map = new int[101]; // map[i]为使用i颗经验丹能达到的经验值
		process(map);
		
		while (sc.hasNext()) {
			int n = sc.nextInt();
			if (n <= 1 || n > 100) {
				System.out.println("no");
				continue;
			}
			
			System.out.println(map[n] / 200 + 1);
		}
		
		System.out.println();
		
		sc.close();
	}

	private static void process(int[] map) {
		map[0] = 75;
		
		for (int i = 1; i < map.length; i++) {
			int grade = map[i - 1] / 200 + 1;
			int deltaVal = 3 * (int) Math.pow(2, (grade - 1));
			map[i] = map[i - 1] + deltaVal;
		}
	}
}