/*
 * [1, 2, 3] 배열 중에서 모든 부분 집합 구하기 (백트래킹 사용 x, 순서 x)
 * ex. [1], [2], ..., [1, 2, 3]
 */
package bruteForce;
import java.util.*;

public class SubsetGenerator {
    static int[] list = {1, 2, 3};
    static ArrayList<Integer> arr = new ArrayList<>();

    public static void main(String[] args) {
        func(0); // 인덱스 0부터 시작
    }

    public static void func(int idx) {
        // 종료 조건: 배열 끝까지 도달하면 부분 수열 출력
        if (idx == list.length) {
            System.out.println(arr);
            return;
        }

        // 현재 원소를 선택하는 경우
        arr.add(list[idx]);
        func(idx + 1);

        // 현재 원소를 선택하지 않는 경우
        arr.remove(arr.size() - 1);
        func(idx + 1);
    }
}
