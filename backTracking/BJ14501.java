// 퇴사 (일반적인 백트래킹)
import java.util.*;

public class BJ14501 {
    static int n;
    static int maxPrice = 0;
    static int[] time;
    static int[] price;
    static ArrayList<Integer> arr = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 입력
        n = scanner.nextInt();
        time = new int[n];
        price = new int[n];

        for (int i = 0; i < n; i++) {
            time[i] = scanner.nextInt();
            price[i] = scanner.nextInt();
        }

        // 함수 호출 (범위는 1부터 n까지, 공집합은 없음.)
        for (int range = 1; range < n + 1; range++) {
            solve(range, 1); // 1일부터.
        }

        System.out.println(maxPrice);
    }

    public static void solve(int range, int index) { // range는 범위
        // 종료 조건
        if (arr.size() == range) {
            // 합이 n을 넘지 않았다면
            int priceSum = overCheckAndFindMax(arr);
            if (priceSum != -1) {
                maxPrice = Math.max(priceSum, maxPrice); // 최댓값 갱신
            }
            return;
        }

        for (int i = index; i < n + 1; i++) {
            arr.add(i);
            solve(range, i + 1);
            arr.remove(arr.size() - 1);
        }
    }

    public static int overCheckAndFindMax(ArrayList<Integer> arr) {
        int timeSum = 0;
        int priceSum = 0;
        for (int i = 0; i < arr.size(); i++) {
            int index = arr.get(i) - 1;
            // 마지막 상담이 n일 안에 끝나는지
            if (i == arr.size() - 1) { // 마지막 인덱스에서.
                if (time[index] > (n - arr.get(i) + 1)) {
                    return -1;
                }
            }

            // 앞 상담이 끝나는 날 < 뒷 상담 시작 날
            if (i + 1 < arr.size()) {
                if (arr.get(i) + time[index] > arr.get(i + 1)) {
                    return -1;
                }
            }
            timeSum += time[index];
            priceSum += price[index];
        }

        // 시간 합이 n을 넘지 않아야 함
        if (timeSum > n) {
            return -1;
        }
        return priceSum; // 합 반환
    }
}
