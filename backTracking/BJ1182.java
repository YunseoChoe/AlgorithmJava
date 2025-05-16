// 부분수열의 합 (소프티어 기출) 
import java.util.*;

public class BJ1182 {
    static int n, s;
    static int cnt = 0; // 조건을 만족하는 부분 수열의 개수 
    static int[] num = {}; // 입력 받은 리스트
    static ArrayList<Integer> arr = new ArrayList<Integer>(); // 부분수열 저장 리스트

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 입력
        n = scanner.nextInt();
        s = scanner.nextInt();

        num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = scanner.nextInt();
        }

        makeSequence(0);
        System.out.println(cnt);
    }
    
    public static void makeSequence(int index) {
        // 합 구하기
        int sum = 0;
        for (int i = 0; i < arr.size(); i++) {
            sum += arr.get(i);
        }

        // 빈 배열이 아니면서 합이 s이면
        if (arr.size() != 0 && sum == s) {
            cnt += 1;
        }

        // 범위 체크
        if (index == num.length) {
            return;
        }
        for (int i = index; i < num.length; i++) {
            arr.add(num[i]);
            makeSequence(i + 1);
            arr.remove(arr.size() - 1); 
        }

    }
}
