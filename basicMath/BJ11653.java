// 소인수분해
package basicMath;
import java.util.*;
import java.io.*;

public class BJ11653 {
    static int n;
    static ArrayList<Integer> arr = new ArrayList<>();

    public static void solve() {
        int i = 2;
        while (n > 1) {
            if (n % i == 0) {
                arr.add(i);
                n /= i;
            }
            else {
                i++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        solve();
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
