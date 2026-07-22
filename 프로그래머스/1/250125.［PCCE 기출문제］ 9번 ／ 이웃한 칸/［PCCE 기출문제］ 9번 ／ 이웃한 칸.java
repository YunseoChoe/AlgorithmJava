class Solution {
    public int solution(String[][] board, int h, int w) {
        int dx[] = {0, 0, 1, -1};
        int dy[] = {1, -1, 0, 0};
        
        int n = board.length;
        int m = board[0].length;
        int answer = 0;
        
        String color = board[h][w];
        
        // (h, w)에서 동서남북 보기
        for (int i = 0; i < 4; i++) {
            int nx = h + dx[i];
            int ny = w + dy[i];
            
            // 범위 확인
            if ((0 <= nx) && (nx < n) && (0 <= ny) && (ny < m)) {
                // 같은 색깔인지 확인
                if (board[nx][ny].equals(color)) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}