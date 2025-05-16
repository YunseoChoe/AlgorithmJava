# 자바 기초 문법 

### ✏️ 문제 풀면서 정리한 자바 문법들 
### 1. 입력

```java
import java.util.Scanner;

public class InputBasic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* 기본 자료형 
        int num = scanner.nextInt();        // 정수 입력
        double d = scanner.nextDouble();    // 실수 입력
        String s = scanner.next();          // 문자열 입력 (공백 기준)
        char ch = scanner.next().charAt(0); // 문자 하나 입력 -> 자바 Scanner은 String타입으로만 입력을 받기 때문에 char타입을 입력받는 기능이 없음. 따라서 charAt(0) 사용.

        /* 배열 (정적) */
        // 정수 배열 입력
        /* 입력 예시
         * 1
         * 2
         * 3
         * or
         * 1 2 3
         */
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {           
            arr[i] = scanner.nextInt(); 
        }
        System.out.println(arr);       // [I@54bedef2 (주소 출력)
        System.out.println(arr[0]);    // 1
        
        // 문자열 배열 입력
        /* 입력 예시
         * a
         * b
         * c
         * or 
         * a b c 
         */   
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = scanner.next();
        }
        System.out.println(words);         // [Ljava.lang.String;@2ff4acd0
        System.out.println(words[0]);      // 'a'
        

        /* 리스트 (동적) */
        // 정수 리스트 입력
        /* 입력 예시
         * 1
         * 2
         * 3
         * or
         * 1 2 3
         */
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }
        System.out.println(list);           // [1, 2, 3]
        System.out.println(list.get(0));    // 1

        // 문자열 리스트 입력
        /* 입력 예시
         * a
         * b
         * c
         * or 
         * a b c 
         */  
        ArrayList<String> strList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            strList.add(scanner.next());
        }
        System.out.println(strList);         // ['a', 'b', 'c']
        System.out.println(strList.get(0));  // 'a'
    }
}
```

### 2. 길이 구하기
| 종류    | 내용                            | 예시                           |
|---------|-------------------------------|--------------------------------|
| length   | 배열의 길이를 구할 때             | `int[] arr = new int[5]; arr.length` |
| length() | 문자열의 길이를 구할 때           | `String s = "hello"; s.length()` |
| size()   | List, Set 등의 크기 구할 때 | `ArrayList<Integer> list; list.size()` |
