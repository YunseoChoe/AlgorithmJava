// 이모티콘
package graphSearh;
import java.io.*;
import java.util.*;

public class BJ14226 {
    static int s;
    static boolean[][] visited = new boolean[1001][1001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s = sc.nextInt();

        solve(); 
    }

    public static void solve() { // bfs
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {1, 0, 0}); // 전체 이모티콘 개수, 시간, 복사 이모티콘 개수
        visited[1][0] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int screen = cur[0]; 
            int time = cur[1];
            int clip = cur[2];

            // 종료 조건
            if (screen == s) {
                System.out.println(time);
                break;
            }

            // 1. 복사
            if (!visited[screen][screen]) {
                visited[screen][screen] = true;
                queue.add(new int[]{screen, time + 1, screen});
            }

            // 2. 붙여넣기
            if (clip > 0 && screen + clip <= 1000 && !visited[screen + clip][clip]) {
                visited[screen + clip][clip] = true;
                queue.add(new int[]{screen + clip, time + 1, clip});
            }

            // 3. 삭제
            if (screen > 0 && !visited[screen - 1][clip]) {
                visited[screen - 1][clip] = true;
                queue.add(new int[]{screen - 1, time + 1, clip});
            }
        }
    }
}