import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for (String[] c : clothes) {
            String name = c[0];
            String type = c[1];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }
        
        int answer = 1;
        for (int cnt : map.values()) {
            answer *= (cnt + 1); // 안 입는 경우 포함
        }
        
        return answer - 1; // 아무것도 입지 않는 경우 제외
    }
}