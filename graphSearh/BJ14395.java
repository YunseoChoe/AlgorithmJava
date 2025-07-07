// 4연산
package graphSearh;
import java.io.*;
import java.util.*;

public class BJ14395 {
    static long s, t;
    static Set<Long> visited = new HashSet<>();
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        s = Long.parseLong(line[0]);
        t = Long.parseLong(line[1]);

        // s와 t가 같다면
        if (s == t) {
            System.out.println(0);
            System.exit(0);
        }
      
        System.out.println(solve());
    }

    public static int solve() { 
        Queue<String[]> queue = new LinkedList<>();
        queue.add(new String[]{String.valueOf(s), ""}); // [0]: 숫자, [1]: 경로
        visited.add(s);

        while (!queue.isEmpty()) {
            String[] cur = queue.poll();
            long num = Long.parseLong(cur[0]);
            String path = cur[1];

            // t와 같다면
            if (num == t) {
                System.out.println(path);
                System.exit(0);
            }

            // 모든 연산
            for (int i = 0; i < 4; i++) {
                long newNum = 0; 
                String op= ""; 
                if (i == 0) {
                    newNum = (num * num);
                    op = "*";
                    
                }
                else if (i == 1) {
                    newNum = (num + num);
                    op = "+";
                }
                else if (i == 2) {
                    newNum = (num - num);
                    op = "-";
                }
                else if (i == 3 && num != 0) {
                    newNum = (num / num);
                    op = "/";
                }

                // 방문하지 않았으면
                if (visited.add(newNum)) { 
                    queue.add(new String[]{String.valueOf(newNum), path + op});
                }
            }
        }

        // while문을 다 돌았는데도 s와 t가 같은 경우가 없다면 -1.
        return -1;
    }
}
