// 1 ~ n까지 모든 순열 구하는 코드 (중복 x)
import java.util.*;
import java.io.*;

public class Permutation {
    static int n;
    static ArrayList<Integer> arr = new ArrayList<>();
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        func(arr);
    }

    public static void func(ArrayList<Integer> num) {
        // num의 길이가 n과 같으면
        if (num.size() == n) {
            // 출력 
            for (int i = 0; i < num.size(); i++) {
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
                func(num);
                num.remove(num.size() - 1);
            }
        }
    }    
}
