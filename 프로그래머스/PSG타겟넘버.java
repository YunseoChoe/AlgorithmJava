package 프로그래머스;

// 알고리즘 - DFS (완전탐색을 위한 재귀)

public class PSG타겟넘버 {
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
