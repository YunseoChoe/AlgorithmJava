// 인구 이동 (bfs, dfs 사용 x)
package Implementation;
import java.util.*;
import java.io.*;

public class BJ16234 {
    static int n, l, r, cnt = 0;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        l = sc.nextInt();
        r = sc.nextInt();

        graph = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        solve();

        System.out.println(cnt);
    }   

    public static void solve() {
        while (true) {
            boolean opened = false;
        
            // visited 초기화
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    visited[i][j] = false;
                }
            }

            // 국경 뚫기
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // 동서남북
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        // 범위 && 방문 x
                        if (0 <= nx && nx < n && 0 <= ny && ny < n && !visited[nx][ny]) {
                            // 차이
                            int gap = Math.abs(graph[i][j] - graph[nx][ny]);

                            // l, r 범위 
                            if (l <= gap && gap <= r) { 
                                visited[i][j] = true; // 국경 뚫기
                                visited[nx][ny] = true; 
                                opened = true;
                            }    
                        }
                    }    
                }
            }

            // 국경을 한 번도 열지 못했다면 while문 종료.
            if (!opened) {
                break;
            }

            cnt += 1; // 인구 이동 횟수 +1

            // 연합 수 구하기 (연합의 총 인구 수 / 연합 칸의 개수)
            int unionSize = 0;
            int unionCnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i][j]) {
                        unionSize += 1;
                        unionCnt += graph[i][j];
                    }
                }
            }

            // 각 칸의 인구수
            int people = unionCnt / unionSize;

            // 배열 재정의
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // 연합에 속한 나라만
                    if (visited[i][j]) {
                        graph[i][j] = people;
                    }
                }
            }

            // 출력
            // for (int i =0;i < n; i++) {
            //     for (int j = 0; j < n; j++) {
            //         System.out.print(visited[i][j] + " ");
            //     }
            //     System.out.println();
            // }
            // for (int i =0;i < n; i++) {
            //     for (int j = 0; j < n; j++) {
            //         System.out.print(graph[i][j] + " ");
            //     }
            //     System.out.println();
            // }
        }
    }
}
