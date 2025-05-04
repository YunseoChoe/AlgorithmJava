// N과 M(1)
import java.util.ArrayList;
import java.util.Scanner;

public class BJ15649 {
    public static int n;
    public static int m;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // scanner 생성

        ArrayList<Integer> num = new ArrayList<>();

        // 입력
        n = scanner.nextInt(); 
        m = scanner.nextInt(); 

        // 함수 호출
        func(num);
    }

    // 재귀함수
    public static void func(ArrayList<Integer> num) {
        // num의 길이가 m과 같으면
        if (num.size() == m) {
            // 출력 후 return
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
