import java.util.*;

class Solution {
    static boolean[] visited;
    static int[][] computers;
    
    public static void dfs(int vertex, int n) {
        visited[vertex] = true;
        
        for (int i = 0; i < n; i++) {
            // 자기 자신이 아니면서 방문하지 않았고, 연결되어 있으면
            if (!visited[i] && computers[vertex][i] == 1) {
                dfs(i, n);
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        Solution.computers = computers; // 매개변수 computers을 전역변수로 설정.
        int answer = 0;
        
        for (int i = 0; i < n; i++) {
            // 방문하지 않았으면
            if (!visited[i]) {
                dfs(i, n);
                answer++;
            }
        }
        return answer;
    }
}