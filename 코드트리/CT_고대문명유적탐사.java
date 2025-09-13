// 고대 문명 유적 탐사
import java.io.*;
import java.util.*;

public class CT_고대문명유적탐사 {
    static int k, m;
    static int bestCnt = 0;
    static int[][] board = new int[5][5];
    static int[] wall;
    static int wallIdx = 0;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        String[] line = br.readLine().split(" ");
        k = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);

        // board 입력
        for (int i = 0; i < 5; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(input[j]);
            }
        }

        // 벽 입력
        wall = new int[m];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            wall[i] = Integer.parseInt(input[i]);
        }

        // k번 반복
        for (int i = 0; i < k; i++) {
            
            // 최적의 회전 찾기
            int[][] bestBoard = chooseRotation(board);
    
            // 획득한 유물이 없다면 즉시 종료
            if (bestCnt == 0) {
                break;
            }

            // 획득한 유물이 있다면
            else {
                // 연쇄 유물 획득
                int gainCnt = processGainCnt(board, wall, wallIdx);

                // 획득한 유물 출력
                System.out.print(gainCnt + " ");
            }
        }
    }

    public static int[][] rot90(int[][] board) {
        /*
         * 3x3행렬 시계방향 90도 회전
         * 반환값: 회전한 5x5 전체 행렬
         */

        int[][] returnBoard = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                returnBoard[j][2 - i] = board[i][j];
            }
        }
        
        return returnBoard;
    }

    public static int[][] rot3x3(int[][] board, int sr, int sc, int deg) {
        /*
         * 3x3 회전 행렬
         */

        int[][] returnBoard = new int[5][5];
        
        // 3x3 자르기
        int[][] subMat = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                subMat[i][j] = board[sr + i][sc + j];
            }
        }

        // 회전
        int[][] rotatedBoard = new int[3][3];
        if (deg == 90) {
            rotatedBoard = rot90(subMat);
        }
        else if (deg == 180) {
            rotatedBoard = rot90(rot90(subMat));
        }
        else if (deg == 270) {
            rotatedBoard = rot90(rot90(rot90(subMat)));
        }
        
        // 다시 5x5로 합치기
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                returnBoard[sr + i][sc + j] = rotatedBoard[i][j];
            }
        }

        return returnBoard;
    }

    public static int[][] chooseRotation(int[][] board) {
        /*
         * 모든 경우의 3x3 회전 후, 우선 순위에 따라 가장 최적의 회전 결과를 반환
         * 반환값: 5x5 board
         */

        int[][] bestBoard = null;
        int[] bestInfo = null; // 우선순위: {-cnt, deg, sc, sr}

        for (int sr = 0; sr < 3; sr++) {
            for (int sc = 0; sc < 3; sc++) {
                for (int deg = 90; deg <= 270; deg += 90) { // 90, 180, 270
                    int[][] rotatedBoard = rot3x3(board, sr, sc, deg); // 3x3 회전된 5x5 행렬

                    // 유물 개수 구하기 (우선 순위 계산용, 보드 변경 x)
                    bestCnt = calculateGain(rotatedBoard);

                    // 우선 순위 계산
                    int[] info = new int[] {-bestCnt, deg, sr, sc}; // cnt값 제외, 모든 값이 작을수록 우선 순위는 높음.

                    // 최적 후보 갱신 (현재 값 vs bestInfo)
                    if (bestInfo == null || isBetter(info, bestInfo)) {
                        bestInfo = info;
                        bestBoard = rotatedBoard;
                    }
                }
            }
        }

        return bestBoard;
    }

    public static boolean isBetter(int[] info1, int[] info2) {
        /*
         * info1이 info2보다 우선순위가 높으면 true 반환
         * 반환값: t/f
         */
        
        for (int i = 0; i < info1.length; i++) {
            if (info1[i] != info2[i]) {
                // 값이 더 작을수록 우선순위 높음
                return info1[i] < info2[i];
            }
        }

        // 완전히 같아서 비교할 수 없으면 false 반환.
        return false;
    }

    public static int calculateGain(int[][] boardAfterRotation) {
        /*
         * 회전 직후, 점수를 계산 (보드 변경 x)
         * 반환값: 획득한 연쇄 유물 개수
         */

        int total = 0;
        ArrayList<ArrayList<int[]>> groups = findGroups(boardAfterRotation);
        
        for (ArrayList<int[]> g : groups) {
            total += g.size();
        }
        return total;
    }

    public static int processGainCnt(int[][] board, int[] wall, int wallIdx) {
        /*
         * 획득한 유물이 없을 때까지 유물 획득, 지우기, 채우기 반복
         * 반환값: 획득한 전체 유물 개수
         */

        int total = 0;

        while (true) {
            // 유물 연쇄 획득
            ArrayList<ArrayList<int[]>> groups = findGroups(board);

            // 획득한 유물이 없다면 즉시 종료
            if (groups.size() == 0) {
                break;
            }

            // 획득한 유물이 있다면
            else {
                // 유물 지우기
                erase(board, groups);

                // 지운 유물 개수 누적
                for (ArrayList<int[]> g : groups) {
                    total += g.size();
                }

                // 유물 채우기
                fill(board, wall, wallIdx);
            }
        }

        return total;
    }

    public static ArrayList<ArrayList<int[]>> findGroups(int[][] board) {
        /*
         * board에서 같은 숫자(>0)로 연결된 그룹 중 크기가 >= 3인 것들을 탐색 (bfs)
         * 반환값: int[][] groups
         */

        ArrayList<ArrayList<int[]>> groups = new ArrayList<>();
        boolean[][] visited = new boolean[5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                // 0이 아니고, 방문하지 않았다면
                if (board[i][j] > 0 && !(visited[i][j])) {
                    // 탐색 시작
                    ArrayList<int[]> group = bfs(i, j, board, visited);

                    // 3개 이상 연속되어 있다면
                    if (group.size() >= 3) {
                        groups.add(group);
                    }
                }
            }
        }

        return groups;
    }

    public static ArrayList<int[]> bfs(int x, int y, int[][] board, boolean[][] visited) {
        int target = board[x][y];
        Queue<int[]> queue = new LinkedList<>();
        ArrayList<int[]> group = new ArrayList<>();
        queue.add(new int[] {x, y});
        visited[x][y] = true;
        group.add(new int[] {x, y});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];
            // 동서남북
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                // 범위와 방문하지 않았고, target과 같은< 값이면
                if (0 <= nx && nx < 5 && 0 <= ny && ny < 5) {
                    if (!visited[nx][ny] && target == board[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.add(new int[] {nx, ny});
                        group.add(new int[] {nx, ny});
                    }
                }
            }
        }
        return group;  
    }

    public static void erase(int[][] board, ArrayList<ArrayList<int[]>> groups) {
        /*
         * 해당 좌표를 모두 0으로 만들기
         */

        for (ArrayList<int[]> group : groups) {
            for (int[] coord : group) {
                board[coord[0]][coord[1]] = 0;
            }
        }
    }

    public static void fill(int[][] board, int[] wall, int wallIdx) {
        /*
         * 열 - 오름차순
         * 행 - 내림차순
         */

        // board의 빈 곳 저장
        ArrayList<int[]> emptyCells = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (board[i][j] == 0) {
                    emptyCells.add(new int[] {i, j});
                }
            }
        }

        // 우선 순위 기준 정렬
        for (int i = 0; i < emptyCells.size(); i++) {
            for (int j = i + 1; j < emptyCells.size(); j++) {
                int c1 = emptyCells.get(i)[0];
                int r1 = emptyCells.get(i)[1];
                int c2 = emptyCells.get(j)[0];
                int r2 = emptyCells.get(j)[1];
            
                // 열이 더 작거나, 열이 같을 때 행이 더 크면
                if ((c1 > c2) || (c1 == c2 && r1 < r2)) {
                    // swap
                    int[] temp = emptyCells.get(i);
                    emptyCells.set(i, emptyCells.get(j));
                    emptyCells.set(j, temp);
                }
            }
        }

        // 우선 순위대로 빈 곳 채우기
        for (int[] emptyCell : emptyCells) {
            // 아직 벽의 유물이 남아있다면
            if (wallIdx < wall.length) {
                board[emptyCell[0]][emptyCell[1]] = wall[wallIdx];
                wallIdx += 1;
            }

            // 남아있지 않다면
            else {
                break;
            }
        }
    }
}
