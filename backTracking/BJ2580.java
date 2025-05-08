// 스도쿠
import java.util.*;

public class BJ2580 {
    public static int[][] arr = new int[9][9]; // 9*9 행렬
    
    public static void main(String[] args) {
        // 입력
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        
        sudoku(0, 0);
    }

    public static void sudoku(int row, int col) {
        // 종료 조건 
        if (row >= 8 && col == 9) { // 마지막 행, 마지막 열일 때
            // 스도쿠 출력 후 종료.
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
            System.exit(0); // 코드 종료
        }

        // 마지막 행x, 마지막 열이라면
        if (col == 9) {
            row += 1;
            col = 0;
        }

        // 빈 칸이라면
        if (arr[row][col] == 0) {
            // 1~9 중 놓을 숫자 탐색
            for (int k = 1; k <= 9; k++) {
                // k를 놓을 수 있으면   
                if (isPossible(k, row, col)) {
                    arr[row][col] = k;
                    sudoku(row, col + 1); // col + 1부터 다시 탐색.
                    arr[row][col] = 0; // 백트래킹
                }
            }  
        }
        // 빈 칸이 아니라면
        else {
            sudoku(row, col + 1);
        }
    }

    // 값을 놓을 수 있는 지 체크하는 함수
    public static boolean isPossible(int num, int row, int col) {
        // 행
        for (int i = 0; i < 9; i++) {
            if (arr[row][i] == num) {
                return false;
            }
        }
        // 열
        for (int i = 0; i < 9; i++) {
            if (arr[i][col] == num) {
                return false;
            }
        }
        // 3*3
        int startCol = (col / 3) * 3;
        int startRow = (row / 3) * 3;

        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (arr[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }
}
