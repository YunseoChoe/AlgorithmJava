import java.util.*;

public class MatrixBacktrack {
    static ArrayList<Integer> arr2 = new ArrayList<Integer>();
    static ArrayList<Integer> arr4 = new ArrayList<Integer>();

    // 순서 고려하지 않고 3개 뽑아서  출력하는 거
    static int[] arr = {1, 3, 4, 7, 9, 12};
    
    // 2차원 행렬에서 순서 고려하지 않고 2개 뽑아서 출력하는 거
    // static int[][] arr3 = {{1, 3, 4}, {5, 7, 8}, {10, 11, 14}};
    static int[][] arr3 = {{1, 2}, {3, 4}};
    
    // 메인 함수
    public static void main(String[] args) {
        func(0); // 0번 인덱스부터
        System.out.println();
        func2(0, 0);
    }

    // 1번 함수
    public static void func(int index) {
        // arr2의 길이가 3이 되면
        if (arr2.size() == 3) {
            // 출력 후 return
            for (int i = 0; i < 3; i++) {
                System.out.print(arr2.get(i) + " ");
            }
            System.out.println();
            return;  
        }
        for (int i = index; i < arr.length; i++) { // index부터 시작 
            arr2.add(arr[i]);
            func(i + 1); // 현재 index보다 뒤에 값들부터 탐색하므로 중복 x
            arr2.remove(arr2.size() - 1);
        }
    }

    // 2번 함수
    public static void func2(int rowIdx, int colIdx) { // row: 행, col: 열
        // 멈추는 조건 코드
        if (arr4.size() == 2) {
            // 출력 후 return
            for (int i = 0; i < arr4.size(); i++) {
                System.out.print(arr4.get(i) + " ");
            }
            System.out.println();
            return;
        }

        // 마지막 행이라면
        if (rowIdx == arr3.length) {
            return;
        }

        // 마지막 열이라면
        if (colIdx == arr3[0].length) {
            colIdx = 0;
            rowIdx += 1;
        }
         
        for (int i = rowIdx; i < arr3.length; i++) {
            for (int j = (i == arr3.length - 1) ? 0 : colIdx; j < arr3[0].length; j++) {  // 마지막 행일 때 열은 0부터.
                // arr4에 arr3[i][j]값이 없으면 add하기
                if (!arr4.contains(arr3[i][j])) {
                    arr4.add(arr3[i][j]);
                    func2(i, j + 1);
                    arr4.remove(arr4.size() - 1);
                } 
            }
        }
    } 
}
