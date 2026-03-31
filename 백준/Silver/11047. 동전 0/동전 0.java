import java.util.*;

public class Main {
    static int n, k, cnt = 0;
    static int[] values;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = sc.nextInt();
        }

        // values 오름차순 정렬 후 뒤집기
        Arrays.sort(values);

        int[] reversesValues = new int[n];
        for (int i = 0; i < values.length; i++) {
            reversesValues[i] = values[n - (i + 1)];
        }

        for (int value : reversesValues) {
            cnt += k / value;
            k %= value;
        }

        System.out.println(cnt);
    }
}
