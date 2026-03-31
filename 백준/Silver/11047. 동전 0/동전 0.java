import java.util.*;

public class Main {
    static int n, k, cnt = 0;
    static int[] moneys;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        moneys = new int[n];
        for (int i = 0; i < n; i++) {
            moneys[i] = sc.nextInt();
        }

        // values 오름차순 정렬 후 뒤집기
        Arrays.sort(moneys);

        int[] reversedMoneys = new int[n];
        for (int i = 0; i < moneys.length; i++) {
            reversedMoneys[i] = moneys[n - (i + 1)];
        }

        for (int value : reversedMoneys) {
            cnt += k / value;
            k %= value;
        }

        System.out.println(cnt);
    }
}
