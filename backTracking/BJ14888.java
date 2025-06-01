// 연산자 끼워넣기
import java.util.*;

public class BJ14888 {
    static int n; 
    static int minValue = Integer.MAX_VALUE;
    static int maxValue = Integer.MIN_VALUE;
    static int[] operand;
    static int[] symbol = new int[4]; 
    static List<Character> operator = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 입력
        n = scanner.nextInt();
        operand = new int[n];
        for (int i = 0; i < n; i++) {
            operand[i] = scanner.nextInt();
        }
        for (int i = 0; i < 4; i++) {
            symbol[i] = scanner.nextInt();
        }

        solve();
        // 최댓값, 최솟값 출력
        System.out.println(maxValue);
        System.out.println(minValue);
    }

    // 연산자 조합
    public static void solve() {
        // 길이가 n - 1이 되면
        if (operator.size() == n - 1) {
            int result = calculate(operator); // 한 번만 호출.
            maxValue = Math.max(maxValue, result); // 최댓값 갱신
            minValue = Math.min(minValue, result); // 최솟값 갱신
            return;
        }

        for (int i = 0; i < 4; i++) {
            // '+'' 이고, 아직 남았을 경우
            if (i == 0 && symbol[i] > 0) {
                operator.add('+');
                symbol[i] -= 1;
                solve();
                operator.remove(operator.size() - 1);
                symbol[i] += 1;
            }
            // -
            else if (i == 1 && symbol[i] > 0) {
                operator.add('-');
                symbol[i] -= 1;
                solve();
                operator.remove(operator.size() - 1);
                symbol[i] += 1;
            }
            // *
            else if (i == 2 && symbol[i] > 0) {
                operator.add('*');
                symbol[i] -= 1;
                solve();
                operator.remove(operator.size() - 1);
                symbol[i] += 1;
            }
            // /
            else if (i == 3 && symbol[i] > 0) {
                operator.add('/');
                symbol[i] -= 1;
                solve();
                operator.remove(operator.size() - 1);
                symbol[i] += 1;
            }
        }
    }

    // 계산 (우선순위 없이 차례대로 계산)
    public static int calculate(List<Character> operator) {
        int sum = operand[0];
        for (int i = 0; i < n - 1; i++) {
            // +
            if (operator.get(i) == '+') {
                sum += operand[i + 1];
            }

            // -
            else if (operator.get(i) == '-') {
                sum -= operand[i + 1];
            } 

            // *
            else if (operator.get(i) == '*') {
                sum *= operand[i + 1];
            } 

            // /
            else if (operator.get(i) == '/') {
                sum /= operand[i + 1];
            }      
       }
       return sum;
    }
}
