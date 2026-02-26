class Solution {
    static boolean[][][][] visited; // 방문 표시를 점이 아닌 선으로 해야하기 때문에 4차원 배열로.
    static int[] dx = {0, 0, 1, -1}; // R, L, D, U
    static int[] dy = {1, -1, 0, 0};
    
    public int solution(String dirs) {
        int answer = 0;
        visited = new boolean[11][11][11][11]; // 좌표 오프셋 적용
        
        int x = 5, y = 5; // (0, 0)
        for (int i = 0; i < dirs.length(); i++) {
            int dir = 0;
            char c = dirs.charAt(i);
            
            if (c == 'R') {
                dir = 0;
            }
            else if (c == 'L') {
                dir = 1;
            }
            else if (c == 'D') {
                dir = 2;
            }
            else {
                dir = 3;
            }
            
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            
            if (0 <= nx && nx < 11 && 0 <= ny && ny < 11) {
                if (!visited[x][y][nx][ny]) {
                    
                    answer++;
                }
                visited[x][y][nx][ny] = true;
                visited[nx][ny][x][y] = true;
                x = nx;
                y = ny;
            }    
        }
        return answer;
    }
}
