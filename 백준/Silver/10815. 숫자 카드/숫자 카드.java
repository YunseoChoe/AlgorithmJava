import java.util.*;

public class Main {
    static int n, m;
    static int[] cards;
    static int[] nums;
    static int[] ans;

    public static void solve() {
        Set<Integer> cardSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            cardSet.add(cards[i]);
        }

        for (int i = 0; i < m; i++) {
            if (cardSet.contains(nums[i])) {
                ans[i] = 1;
            } else {
                ans[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        cards = new int[n];

        for (int i = 0; i < n; i++) {
            cards[i] = sc.nextInt();
        }

        m = sc.nextInt();
        nums = new int[m];
        ans = new int[m];

        for (int i = 0; i < m; i++) {
            nums[i] = sc.nextInt();
        }

        solve();

        for (int i = 0; i < m; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
