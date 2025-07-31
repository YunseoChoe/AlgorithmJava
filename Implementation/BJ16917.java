// 양념 반 후라이드 반
package Implementation;
import java.util.*;
import java.io.*;

public class BJ16917 {
    static int a, b, c, x, y;
    static int seasoningCnt = 0;
    static int friedCnt = 0;
    static int halfCnt = 0;
    static int minPrice = Integer.MAX_VALUE;

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        x = sc.nextInt();
        y = sc.nextInt();

        solve();
        System.out.println(minPrice);
    }

    public static void solve() {
        while (true) {
            if (halfCnt / 2 > Math.max(x, y)) {
                break;
            }

            if (x - (halfCnt / 2) >= 0 && y - (halfCnt / 2) >= 0) {
                int price = (c * halfCnt) + ((x - (halfCnt / 2)) * a) + ((y - (halfCnt / 2)) * b);
                if (price < minPrice) {
                    minPrice = price;
                }
            }
            halfCnt += 2;
        }
    }
}


