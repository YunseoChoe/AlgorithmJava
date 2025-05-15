// 단어 수학 (-> 백트래킹 방법)
import java.util.*;

public class BJ1339 {
    public static int n;
    public static ArrayList<String> wordList = new ArrayList<>(); // 한글자씩 저장.
    public static ArrayList<Integer> arr = new ArrayList<>();
    public static List<Character> alphabetList = new ArrayList<>();// 중복없는 알파벳 리스트
    public static int maxSum = 0; // 최댓값 저장 변수

    public static void main(String[] args) {
        // 입력
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt(); // 단어의 개수

        for (int i = 0; i < n; i++) {
            String word = scanner.next(); 
            wordList.add(word); // wordList = [abc, def]
        }

        // 알파벳 리스트 
        for (int i = 0; i < wordList.size(); i++) {
            // alphabetList에 없으면 append()
            for (int j = 0; j < wordList.get(i).length(); j++) {
                if (!alphabetList.contains(wordList.get(i).charAt(j))) {
                    alphabetList.add(wordList.get(i).charAt(j));
                }
            }
        }

        // 함수 호출
        func();
        System.out.println(maxSum);

    }

    public static void func() {
        // arr길이가 alphabetList길이와 같으면
        if (arr.size() == alphabetList.size()) {
            // 최댓값 갱신 후 return
            int sum = returnSum(arr, alphabetList, wordList);
            maxSum = Math.max(maxSum, sum);
            return;
        }

        // 0~9까지 조합
        for (int i = 0; i < 10; i++) {
            // arr에 없으면 add -> 중복 조합
            if (!arr.contains(i)) {
                arr.add(i);
                func();
                arr.remove(arr.size() - 1);
            }
        }
    }

    // arr 넘겨주면 알파벳 매칭시켜서 sum 반환하는 함수
    public static int returnSum(ArrayList<Integer> arr, List<Character> alphabetList, ArrayList<String> wordList) {
        Map<Character, Integer> alphabetDict = new HashMap<>(); // 딕셔너리 
        for (int i = 0; i < alphabetList.size(); i++) {
            alphabetDict.put(alphabetList.get(i), arr.get(i));
        }

        // 합 구하기
        int sum = 0;
        for (int i = 0; i < wordList.size(); i++) {
            int partSum = 0;
            int j = wordList.get(i).length() - 1;
            int mulNum = 1;
            while (j != -1) {
                partSum += alphabetDict.get(wordList.get(i).charAt(j)) * mulNum;
                mulNum *= 10;
                j -= 1;
            }
            sum += partSum;
        }
        return sum;
    }
}
