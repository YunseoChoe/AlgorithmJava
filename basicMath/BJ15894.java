// 수학은 체육과목 입니다
package basicMath;
import java.util.*;
import java.io.*;

public class BJ15894 {
    static long n; // n의 범위는 10^9이므로 int가 아닌 long으로 해야 맞음.

    public static long solve() {
        return n * 4;
    }
    
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        System.out.println(solve());   
    }
}
