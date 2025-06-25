// 구슬 탈출 2
package graphSearh;
import java.util.*;

public class BJ13460 {
    static int rsx, rsy, bsx, bsy;

    public static void main(String[] args) {
        int result = solve();
        System.out.println(result);
    }

    public static int solve() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { rsx, rsy, bsx, bsy, 0 });
        visited[rsx][rsy][bsx][bsy] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            // 10번 초과됐으면. (다른 queue도 봐야 하므로 종료하면 안 됨.)
            if (cur[4] > 10) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int[] rinfo = move(cur[0], cur[1]);
                int[] binfo = move(cur[2], cur[3]);
                // 파란색 구슬이 구멍에 들어갔는지 먼저 보기 (파란색이 구슬이 구멍에 들어가면 안 되기 때문)
                boolean bHole = isHole(binfo[0], binfo[1]);
                if (bHole) {
                    continue;
                }
                // 그 후, 빨간색 구슬이 구멍에 들어갔는지 확인 하기
                boolean rHole = isHole(rinfo[0], rinfo[1]);
                if (rHole) {
                    return cur[4];
                }
                // 둘 다 구멍에 빠지지 않은 경우
                // 빨간색, 파란색 구슬이 같은 위치에 있다면,
                if () {

                }
                // 옮겨진 해당 위치가 처음 방문하는 거라면, queue에다가 넣어준다.0부터

                if () {

                }
            }

        }
        return -1;
    }

    // 구슬을 이동시키는 함수
    public static int[] move(int x, int y) {
        return new int[] { 0, 0, 0 };
    }

    // 구멍에 빠졌는지 확인하는 함수
    public static boolean isHole(int x, int y) {
        boolean false;
    }
}