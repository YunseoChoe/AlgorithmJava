// 리모컨


import java.util.*;

public class Main {
    static int n;
    static int m;
    static int start = 100;
    static int[] brokens;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 입력
        n = scanner.nextInt();
        m = scanner.nextInt();
        brokens = new int[m];
        for (int i = 0; i < m; i++) {
            brokens[i] = scanner.nextInt();
        }

        // 100이면 바로 종료
        if (n == 100) {
            System.out.println(0);
            System.exit(0);
        }

        int minChannel = -1;
        int maxChannel = -1;

        // 고장난 버튼이 없는 경우 → 숫자 입력만으로 이동 가능
        if (m == 0) {
            minChannel = n;
            maxChannel = n;
        } else {
            // 최솟값: 숫자 버튼으로 만들 수 있는 가장 가까운 수 중 n 이하
            for (int i = n; i >= 0; i--) {
                if (isAvailable(i)) {
                    minChannel = i;
                    break;
                }
            }

            // 최댓값: n 이상에서 만들 수 있는 가장 가까운 수
            // Integer.MAX_VALUE → 999999로 변경 (6자리까지만 확인)
            for (int i = n; i <= 999999; i++) {
                if (isAvailable(i)) {
                    maxChannel = i;
                    break;
                }
            }

            // 모든 숫자 버튼이 고장난 경우 대비
            if (minChannel == -1 && maxChannel == -1) {
                System.out.println(Math.abs(n - start));
                return;
            }
        }

        // 1. + / - 만으로 이동하는 경우
        int pressOnlyByPlusMinus = Math.abs(n - start);

        // 2. 숫자 버튼으로 입력 가능한 채널 → 자릿수 + 차이 계산
        int minValueFromMin = (minChannel == -1) ? Integer.MAX_VALUE
                : String.valueOf(minChannel).length() + Math.abs(n - minChannel);
        int minValueFromMax = (maxChannel == -1) ? Integer.MAX_VALUE
                : String.valueOf(maxChannel).length() + Math.abs(n - maxChannel);

        // 3. 최소값 출력
        int answer = Math.min(pressOnlyByPlusMinus, Math.min(minValueFromMin, minValueFromMax));
        System.out.println(answer);
    }

    // 숫자 버튼으로 만들 수 있는 숫자인지 확인하는 함수
    public static boolean isAvailable(int number) {
        if (number == 0) {
            for (int b : brokens) {
                if (b == 0) return false;
            }
            return true;
        }

        while (number > 0) {
            int digit = number % 10;
            for (int b : brokens) {
                if (b == digit) return false;
            }
            number /= 10;
        }
        return true;
    }
}
