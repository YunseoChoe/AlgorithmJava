import java.util.*;

public class Main {
    static int n, k, cnt = 0;
    static int[] monies;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        monies = new int[n];
        for (int i = 0; i < n; i++) {
            monies[i] = sc.nextInt();
        }

        // values 오름차순 정렬 후 뒤집기
        Arrays.sort(monies);

        int[] reversedMonies = new int[n];
        for (int i = 0; i < monies.length; i++) {
            reversedMonies[i] = monies[n - (i + 1)];
        }

        for (int money : reversedMonies) {
            cnt += k / money;
            k %= money;
        }

        System.out.println(cnt);
    }
}
