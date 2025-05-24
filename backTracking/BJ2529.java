// 부등호
import java.util.*;

public class BJ2529 {
    static int k;
    static char[] signs;
    static long min = Long.MAX_VALUE; // 2,147,483,647을 초과할 수도 있으므로 long으로 
    static long max = 0; 
    static ArrayList<Integer> arr = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 입력
        k = scanner.nextInt();
        signs = new char[k];

        for (int i = 0; i < k; i++) {
            signs[i] = scanner.next().charAt(0); // 한 문자씩 저장.
        }

        func(); 
        System.out.println(String.format("%0" + (k + 1) + "d", max)); // 자릿수 맞춰서 출력
        System.out.println(String.format("%0" + (k + 1) + "d", min)); 
    }

    public static void func() {
        // 종료 조건
        if (arr.size() == k + 1) {
            // 숫자 리스트 -> 정수로 변환
            long value = 0; // int 말고 Long으로
            for (int a : arr) {
                value = value * 10 + a;
            }
            min = Math.min(min, value);
            max = Math.max(max, value);
            return;
        }

        // 0~9까지 arr에 숫자 넣기 (단, 조건 있음.)
        for (int i = 0; i < 10; i++) {
            // arr가 비어있으면
            if (arr.size() == 0) {
                // 그냥 add
                arr.add(i);
                func();
                arr.remove(arr.size() - 1);
            }
            // arr가 비어있지 않다면
            else {
                // arr에 없는 값만 넣기 (중복 금지)
                if (!arr.contains(i)) {
                    // 부등호 조건을 만족하면
                    char sign = signs[arr.size() - 1]; 
                    if (compare(arr.get(arr.size() - 1), sign, i)) {
                        arr.add(i);
                        func();
                        arr.remove(arr.size() - 1);
                    }
                }
                
            }
            // arr.remove(arr.size() - 1); // add하지 않았는데도 remove하게 되므로 이 곳에 두면 안 됨
        }
    }

    // (a ㅁ b)의 결과가 true인지 false인지를 반환
    public static boolean compare(int a, char sign, int b) { // String vs char vs Character ?
        // <
        if (sign == '<') {
            if (a < b) {
                return true;
            }
        }
        // >
        else if (sign == '>') {
            if (a > b) {
                return true;
            }
        }
        return false;
    } 
}
