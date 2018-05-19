package leetcode1st.string;

public class P38 {
	/*
	 * Clear and self-commenting:
	 * 1. $num stores result step by step
	 * 2. $start and $end delimiting each unit 
	 */
    public String countAndSay(int n) {
        if (n == 1) return "1";
        
        String num = "1";
        while (n > 1) {
            StringBuilder sb = new StringBuilder();
            for (int start = 0, end = 1; end <= num.length(); ) {
                if (end < num.length() && num.charAt(end) == num.charAt(start)) {
                    end++;
                    continue;
                } 
                sb.append("" + (end - start) + num.charAt(start));
                start = end;
                end = start + 1;
            }
            
            num = sb.toString();
            n--;
        }
        
        return num;     
    }
}
