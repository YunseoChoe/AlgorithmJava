// 수학은 비대면강의입니다
import java.util.*;

public class BJ19532 {
    static int a, b, c, d, e, f;
    static ArrayList<Integer> arr = new ArrayList<>(); // 정수로 이루어진 arr 리스트 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        a = scanner.nextInt();
        b = scanner.nextInt();
        c = scanner.nextInt();
        d = scanner.nextInt();
        e = scanner.nextInt();
        f = scanner.nextInt();
        makeArr();
    }   

    public static void makeArr() {
        // 2개 순열 완성되면
        if (arr.size() == 2) {
            int x = arr.get(0);
            int y = arr.get(1);
    
            // 식이 성립하면
            if ((a * x + b * y == c) && (d * x + e * y == f)) {
                // x, y 출력 후 종료 (?)
                System.out.print(x + " ");
                System.out.println(y);
                System.exit(0); // 종료. (이거 안 넣어도 왜 맞지? -> 어차피 x, y는 1개만 존재하기 때문)
            }
            return;
        }

        for (int i = -999; i <= 999; i++) {
            arr.add(i);
            for (int j = -999; j <= 999; j++) {
                // 순열 (순서 중요, 중복 허용)
                arr.add(j);
                makeArr();
                arr.remove(arr.size() - 1);
                // 만약 j가 범위 마지막 값이라면 remove 한 번 더
                if (j == 999) {
                    arr.remove(arr.size() - 1);
                }
            }
        }
    }
}
