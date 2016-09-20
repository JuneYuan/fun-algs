package leetcode.bits;

import org.junit.Test;

public class P190 {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        long result;
        StringBuilder tcBits = new StringBuilder();  // 补码
        for (int i = 0; i < 32; i++) {
            char bit = ((n >> i) & 1) == 0 ? '0' : '1';
            tcBits.append(bit);
        }
        
        if (tcBits.charAt(0) == '0') {
        	result = Long.parseLong(tcBits.toString(), 2);
        } else {
        	StringBuilder smBits = new StringBuilder();  // 原码
        	
            for (int i = 0; i < 32; i++) {
                char bit = tcBits.charAt(i) == '0' ? '1' : '0';
                smBits.append(bit);
            }
            
            result = Long.parseLong(smBits.toString(), 2) + 1;
            result *= (-1);
        }
        
        
        return (int)result;
    }
    
    @Test 
    public void testIntegerParse() {
    	String str = "0000000";
    	str += "00000000";
    	str += "00000000";
    	str += "00000000";
    	
    	int foo = Integer.parseInt("1011", 2);
    	// int foo = Integer.parseInt(str, 2);
    	System.out.println(foo);
    	StringBuilder sb = new StringBuilder();
    	int bar = (int)Long.parseLong(str, 2);
    }

    @Test
    public void testSolution() {
    	System.out.println(reverseBits(43261596));
    }
}
