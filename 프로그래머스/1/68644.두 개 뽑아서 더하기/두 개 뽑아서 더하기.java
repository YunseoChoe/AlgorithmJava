import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> set = new TreeSet<>();
        
        // 이중 for문 완전 탐색.
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {                
                set.add(numbers[i] + numbers[j]);
            }
        }
        
        // set -> int
        int[] answer = set.stream()
                        .mapToInt(Integer::intValue)
                        .toArray();
        
        return answer;
    }
}