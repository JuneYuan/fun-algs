
public class MiOJ73 {
	private static String solution(String line) {
	    // 在此处理单行数据
		String[] inputs = line.split(",");
		int[] nums = new int[inputs.length];
		for (int i = 0; i < inputs.length; i++) {
			nums[i] = Integer.parseInt(inputs[i].trim());
		}
		
		int single = 0;
		final int INT_BITS = 32;
		for (int i = 0; i < INT_BITS; i++) {
			int bitSum = 0;
			for (int num : nums) {
				bitSum += ((num >> i) & 1);
			}
			
			single |= ((bitSum % 3) << i);
		}
	    // 返回处理后的结果
	    return Integer.toString(single);
	}
	
	public static void main(String[] args) {
		String line1 = "2,3,2,2";
		String line2 = "5,1,4,5,4,5,4";
		System.out.println(solution(line1));
		System.out.println(solution(line2));
	}
}
