// 암호 만들기
import java.util.*;

public class BJ1759 {
    public static int l;
    public static int c;
    public static String ch;
    public static ArrayList<Character> chList = new ArrayList<>(); 
    public static ArrayList<String> chNum = new ArrayList<>(); 
    public static ArrayList<String> answerList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        l = scanner.nextInt();
        c = scanner.nextInt();
        scanner.nextLine(); // 개행문자 제거

        ch = scanner.nextLine(); // 한 줄 입력 받기. ("a t c i s w")
        // 공백 없애기 
        for (int i = 0; i < ch.length(); i++) {
            if (ch.charAt(i) != ' ') {
                chList.add(ch.charAt(i)); // chList = [a, t, c, i, s, w]
            }
        }
        
        Collections.sort(chList); // chList 정렬
        func(0, chNum);
    }

    public static void func(int index, ArrayList<String> chNum) {
        // 길이가 l이면
        if (chNum.size() == l) {
            // 자음, 모음 체크
            if (check(chNum)) {
                for (int i = 0; i < chNum.size(); i++) {
                    System.out.print(chNum.get(i));
                }
                System.out.println();
            }
            return;
        }

        for (int i = index; i < chList.size(); i++){
            // chNum에 없으면
            if (!chNum.contains(String.valueOf(chList.get(i)))){
                // 문자 -> 문자열 (형변환)
                chNum.add(String.valueOf(chList.get(i)));
                func(i + 1, chNum);
                chNum.remove(chNum.size() - 1);
            }
        }
    }

    // 최소 한 개의 모음 + 두 개의 자음 check
    public static boolean check(ArrayList<String> chNum) {
        String[] Vowels = {"a", "e", "i", "o", "u"};
        String[] Consonant = {"b", "c", "d", "f", "g", "h", "j", "k", "l", "m", "n", "p", "q", "r", "s", "t", "v", "w", "x", "y", "z"};
        int isVowels = 0;
        int isConsonant = 0;

        for (int i = 0; i < chNum.size(); i++) {
            // 모음
            for (String vowel : Vowels) {
                if (vowel.equals(chNum.get(i))) {
                    isVowels += 1;
                }
            }
            // 자음
            for (String consonamt : Consonant) {
                if (consonamt.equals(chNum.get(i))) {
                    isConsonant += 1;
                }
            }

            if (isVowels >= 1 && isConsonant >= 2) {
                return true;
            }
        }
        return false;
    }
}
