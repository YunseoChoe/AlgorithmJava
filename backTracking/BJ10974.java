// 모든 순열
import java.io.*;
import java.util.*;

public class BJ10974 {
    static int n;
    static ArrayList<Integer> num = new ArrayList<>();
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        solve(num);
    }

    public static void solve(ArrayList<Integer> num) {
        if (num.size() == n) {
            for (int i = 0; i < n; i++) {
                System.out.print(num.get(i) + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i < n + 1; i++) {
            // 원소가 num에 있다면 
            if (num.contains(i)) {
                continue;
            }
            else {
                num.add(i);
                solve(num);
                num.remove(num.size() - 1);
            }
        }
    }
}
