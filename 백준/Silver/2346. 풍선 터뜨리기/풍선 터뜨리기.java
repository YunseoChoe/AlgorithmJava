import java.util.Scanner;

public class Main {
    static int n;
    static int[] paper;
    static int[] balloon;
    static int[] answer;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        n = sc.nextInt();

        balloon = new int[n];
        for (int i = 0; i < n; i++) {
            balloon[i] = i; 
        }

        paper = new int[n];
        for (int i = 0; i < n; i++) {
            paper[i] = sc.nextInt();
        }

        answer = new int[n];

        int idx = 0;
        int cnt = 0;

        while (cnt < n) {

            // 현재 풍선 터뜨리기 + 기록
            answer[cnt] = idx + 1;
            int move = paper[idx];  
            balloon[idx] = -1;      
            cnt++;

            // 마지막이면 종료
            if (cnt == n) break;

            int cnt2 = 0;

            // 이동
            while (cnt2 < Math.abs(move)) {

                if (move > 0) {
                    idx = (idx + 1) % n;
                }
                else {
                    idx = (idx - 1 + n) % n;
                }

                // 살아있는 풍선만 카운트
                if (balloon[idx] != -1) {
                    cnt2++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(answer[i] + " ");
        }
    }
}