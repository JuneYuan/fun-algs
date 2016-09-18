package leetcode.datastruct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P401 {
    public List<String> readBinaryWatch(int n) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> timeNumMap = new HashMap<>();
        
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                String time = String.format("%d:%02d", i, j);
                int num = bitCount(i) + bitCount(j);
                timeNumMap.put(time, num);
            }
        }
        
        for (Map.Entry<String, Integer> entry : timeNumMap.entrySet()) {
            int num = entry.getValue();
            if (num == n) {
                result.add(entry.getKey());
            }
        }
        
        return result;
    }

    private int bitCount(int d) {
        int cnt = 0;
        while (d > 0) {
            cnt++;
            d &= (d - 1);
        }
        
        return cnt;
    }
    
}
