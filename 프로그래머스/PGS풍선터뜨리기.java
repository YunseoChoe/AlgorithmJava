package 프로그래머스;
import java.util.Scanner;

public class PGS풍선터뜨리기 {
    static int n;
    static int[] paper;
    static int[] balloon;
    static int[] answer;
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        // n -> 1
        n = sc.nextInt();
        balloon = new int[n];
        for (int i = 0; i < n; i++) {
            balloon[i] = i;
        }

        paper = new int[n];
        for (int i = 0; i < n; i++) {
            paper[i] = sc.nextInt();
        }

        int idx = 0;
        int cnt = 0;
        
        answer = new int[n];

        while (cnt != n) {
            // 터뜨릴 풍선 번호 저장
            answer[idx] = idx + 1;

            // 종이 확인하고 인덱스 재조정
            int cnt2 = 0;
            while (cnt2 != paper[idx]) {
                // 양수라면
                if (paper[idx] > 0) {
                    // 이미 터졌다면 && 범위
                    if (balloon[idx + 1] == -1) {
                        idx += 1;
                    }
                    // 안 터졌다면
                    else {
                        idx += 1;
                        cnt2 += 1;
                    }
                }
                // 음수라면
                else if (paper[idx] < 0) {
                    // 이미 티졌다면 && 범위
                    if (balloon[idx - 1] == -1) {
                        idx -= 1;
                    }
                    // 안 터졌다면
                    else {
                        idx -=1;
                        cnt2 += 1;
                    }
                }
                
            }
                        
            // 터뜨리기
            balloon[idx] = -1;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(answer[i] + " ");
        }
    }
}

