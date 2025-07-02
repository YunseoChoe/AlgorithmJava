package graphSearh;
import java.util.*;

public class BJ13460 {
    static int n, m;
    static int[] dx = {0, 0, 1, -1}; 
    static int[] dy = {1, -1, 0, 0}; 
    static char[][] board;
    static boolean[][][][] visited; // 4차원 행렬 (4개의 위치가 하나의 상태)
    static int rsx, rsy, bsx, bsy; 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine(); 

        board = new char[n][m];
        visited = new boolean[n][m][n][m]; 

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = line.charAt(j);
                if (board[i][j] == 'R') {
                    rsx = i;
                    rsy = j;
                } else if (board[i][j] == 'B') {
                    bsx = i;
                    bsy = j;
                }
            }
        }

        int result = solve();
        System.out.println(result);
        sc.close();
    }

    public static int solve() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { rsx, rsy, bsx, bsy, 0 }); 
        visited[rsx][rsy][bsx][bsy] = true; 

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int rcx = cur[0];
            int rcy = cur[1];
            int bcx = cur[2];
            int bcy = cur[3];
            int count = cur[4]; 

            // 이동 횟수가 10번을 초과하면 더 이상 탐색할 필요 없음 
            if (count >= 10) { 
                break; 
            }

            for (int i = 0; i < 4; i++) { 
                int[] rinfo = move(rcx, rcy, i); 
                int[] binfo = move(bcx, bcy, i);

                int rnx = rinfo[0]; 
                int rny = rinfo[1]; 
                int bnx = binfo[0]; 
                int bny = binfo[1]; 
                
                boolean bHole = isHole(bnx, bny);

                // 파란색 공이 구멍에 들어가지 않았다면
                if (!bHole) { 
                    boolean rHole = isHole(rnx, rny);

                    // 빨간색 공이 구멍에 들어갔다면
                    if (rHole) {
                        return count + 1; 
                    }

                    // 아무 공도 구멍에 들어가지 않았다면
                    // 서로 같은 위치라면 위치 조정
                    if (rnx == bnx && rny == bny) {
                        if (rinfo[2] > binfo[2]) { 
                            rnx -= dx[i]; 
                            rny -= dy[i];
                        } else { 
                            bnx -= dx[i]; 
                            bny -= dy[i];
                        }
                    }
                    
                    // 처음 방문하는 곳이라면
                    if (!visited[rnx][rny][bnx][bny]) {
                        visited[rnx][rny][bnx][bny] = true;
                        queue.add(new int[] {rnx, rny, bnx, bny, count + 1}); 
                    }
                } 
            }
        }
        // 파란색 공이 구멍에 들어갔거나, 10번 초과됐을 경우.
        return -1;
    }

    public static int[] move(int x, int y, int dir) {
        int nx = x;
        int ny = y;
        int cnt = 0; 

        while (true) {
            int nextX = nx + dx[dir]; 
            int nextY = ny + dy[dir]; 

            // 벽을 만났으면 바로 종료
            if (board[nextX][nextY] == '#') {
                break;
            }
            // 구멍을 만났으면 이동 후 종료
            if (board[nextX][nextY] == 'O') {
                nx = nextX;
                ny = nextY;
                cnt++; 
                break;
            }
            // 아무것도 만나지 않았다면 이동
            nx = nextX;
            ny = nextY;
            cnt++; 
        }
        return new int[] { nx, ny, cnt }; 
    }

    public static boolean isHole(int x, int y) {
        if (board[x][y] == 'O') {
            return true;
        }   
        return false;
    }
}
