// 일곱 난쟁이
import java.util.*;

public class BJ2309 {
    static int[] heights = new int[9]; // 9명의 키 저장 배열
    static ArrayList<Integer> arr = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 입력
        for (int i = 0; i < 9; i++) {
            heights[i] = scanner.nextInt();
        }
        make7Heights(0);
    }

    public static void make7Heights(int index) {
        // 만약 7명이 되면
        if (arr.size() == 7) {
            // 키의 합이 100이면
            int heightsSum = 0;
            for (int i = 0; i < 7; i++) {
                heightsSum += arr.get(i);
            }
            if (heightsSum == 100) {
                // 오름차순 출력 후 종료 (아무거나 출력도 포함)
                Collections.sort(arr);
                for (int i = 0; i < 7; i++) {
                    System.out.println(arr.get(i));
                }
                System.exit(0); // 종료.
                
            }
            return; // 다른 경우 더 찾아봄.
        }

        for (int i = index; i < 9; i++) {
            arr.add(heights[i]);
            make7Heights(i + 1);
            arr.remove(arr.size() - 1);
        }
    }
}
