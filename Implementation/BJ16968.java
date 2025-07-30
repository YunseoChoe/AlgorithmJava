// 차량 번호판 1
package Implementation;
import java.util.*;
import java.io.*;

public class BJ16968 {
    static String str;
    static int sum = 1; // sum만 전역변수.

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        str = sc.next();

        for (int i = 0; i < str.length(); i++) {
            int numCase = 10;
            int charCase = 26;
            char ch = str.charAt(i); 

            // 첫번째 예외처리
            if (i == 0) {
                // 숫자
                if (ch == 'd') {
                    sum *= numCase;
                }
                // 문자
                else {
                    sum *= charCase;
                }
            }

            // 첫번째 제외 
            else {
                char beforeCh = str.charAt(i - 1);
                // 숫자
                if (ch == 'd') {
                    // 이전 값도 숫자
                    if (beforeCh == 'd') {
                        numCase -= 1;
                    }
                    sum *= numCase;
                }

                // 문자
                else {
                    // 이전 값도 문자
                    if (beforeCh == 'c') {
                        charCase -= 1;
                    }
                    sum *= charCase;
                }
            }
        }

        System.out.println(sum);
    }
}
