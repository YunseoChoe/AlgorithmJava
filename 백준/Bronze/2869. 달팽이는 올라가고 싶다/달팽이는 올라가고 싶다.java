// 달팽이는 올라가고 싶다
import java.io.*;
import java.util.*;

public class Main {

    public static int solve(int a, int b, int v) {
        return (v - b + (a - b - 1)) / (a - b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        System.out.println(solve(a, b, v));
    }
}