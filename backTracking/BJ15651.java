import java.util.*; 

public class BJ15651 {
    public static int n;
    public static int m;
    
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력
        n = scanner.nextInt();
        m = scanner.nextInt();

        ArrayList<Integer> num = new ArrayList<>();

        // 함수 호출
        func(num);
        System.out.print(sb); 
    }

    public static void func(ArrayList<Integer> num) {
        // num 길이가 m과 같으면
        if (num.size() == m) {
            // 출력 후 return
            for (int i = 0; i < num.size(); i++) {
                sb.append(num.get(i)).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i < n + 1; i++) {
            num.add(i);
            func(num);
            num.remove(num.size() - 1);
        }
    }
}
