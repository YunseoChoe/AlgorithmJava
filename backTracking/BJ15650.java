import java.util.*;

public class BJ15650 {
    public static int n;
    public static int m;
    public static ArrayList<ArrayList<Integer>> result_num = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> num = new ArrayList<>();

        n = scanner.nextInt();
        m = scanner.nextInt();

        func(num);
    }

    public static void func(ArrayList<Integer> num) {
        // num의 길이가 m과 같으면
        if (num.size() == m) {
            // num 정렬
            ArrayList<Integer> sorted_num = new ArrayList<>(num);
            Collections.sort(sorted_num); 
        
            // 정렬한 num이 result_num에 없으면 
            if (!result_num.contains(sorted_num)) {
                // System.out.println("출력");
                // 출력 후 return
                for (int i = 0; i < num.size(); i++) {
                    System.out.print(num.get(i) + " ");
                }
                System.out.println();
                result_num.add(sorted_num);
                return;
            }
        }

        for (int i = 1; i < n + 1; i++) {
            // 원소가 num에 있으면
            if (num.contains(i)) {
                continue;
            }
            else {
                num.add(i);
                func(num);
                num.remove(num.size() - 1);
            }            
        }
    }
}
