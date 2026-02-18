import java.util.*;

class Solution {
    static int answer = 0;
    
    public void dfs(int[] numbers, int depth, int sum, int target)  {
        if (depth == numbers.length) {
            // 연산 결과 == target
            if (sum == target) {
                answer++;
            }
            return;
        }
        
        // +
        dfs(numbers, depth + 1, sum + numbers[depth], target);
        
        // -
        dfs(numbers, depth + 1, sum - numbers[depth], target);
    }
    
    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, 0, target);
        
        return answer;
    }
}