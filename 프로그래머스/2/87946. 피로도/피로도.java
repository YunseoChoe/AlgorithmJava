class Solution {

    static boolean[] visited;
    static int answer;
    static int count;
    static int n;

    public static void backTrack(int fatigue, int count, int[][] dungeons) {
        answer = Math.max(answer, count);
        
        // 종료 조건
        if (count == n) {
            return;
        }

        for (int i = 0; i < n; i++) {
            // 아직 방문 안 했고, 현재 피로도로 입장 가능하면
            if (!visited[i] && fatigue >= dungeons[i][0]) {
                visited[i] = true;
                backTrack(fatigue - dungeons[i][1], count + 1, dungeons);
                visited[i] = false;
            }
        }
    }

    public int solution(int k, int[][] dungeons) {
        n = dungeons.length;
        visited = new boolean[n];
        answer = 0;

        backTrack(k, 0, dungeons);
        return answer;
    }
}