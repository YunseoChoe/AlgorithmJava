// 4연산
package graphSearh;
import java.io.*;
import java.util.*;

public class BJ14395 {
    static int s, t;
    // static char[] operator = {'*', '+', '-', '/'};
    static Set<Integer> visited = new HashSet<>();
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        s = Integer.parseInt(line[0]);
        t = Integer.parseInt(line[1]);

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
            int num = Integer.parseInt(cur[0]);
            String path = cur[1];

            // t와 같다면
            if (num == t) {
                // 경로 출력 
                System.out.println(path);
                System.exit(0); // 바로 종료 
            }

            // 모든 연산
            for (int i = 0; i < 4; i++) {
                int newNum = 0; 
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

                // 범위 && 방문하지 않음 
                if (0 <= newNum && newNum <= t && visited.add(newNum)) { 
                    queue.add(new String[]{String.valueOf(newNum), path + op});
                }
            }
        }

        // while문을 다 돌았는데도 s와 t가 같은 경우가 없다면 -1.
        return -1;
    }
}
