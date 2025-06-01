// 스타트와 링크 
import java.util.*;

public class BJ14889 {
    static int n;
    static int minGap = Integer.MAX_VALUE;
    static int[][] graph;
    static ArrayList<Integer> teamArr = new ArrayList<>();
    
    public static void main(String[] args) {
        // 입력
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }

        makeTeam(0);
        System.out.println(minGap);
    }

    public static void makeTeam(int index) {
        // 팀원이 완성되면
        if (teamArr.size() == n / 2) {
            // 전체 팀구성 (어차피 2팀밖에 없으므로 T/F 사용하였음.)
            // ex. team = [t, t, t, f, f, f]
            boolean[] team = new boolean[n]; // 기본값으로 모두 false 
            for (int i : teamArr) {
                team[i] = true; // start팀
            }

            // 능력치 구하기 
            // 2명씩 뽑아서 능력치를 구할 때, 함수 사용하지 않고 이중 for문으로 2명씩 뽑는 모든 조합을 구할 수 있음.
            int startSkill = 0;
            int linkSkill = 0;
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) { // i + 1부터 (중복x)
                    // start팀
                    if (team[i] && team[j]) {
                        startSkill += graph[i][j];
                        startSkill += graph[j][i];
                    }
                    // link팀
                    else if (!team[i] && !team[j]) {
                        linkSkill += graph[i][j];
                        linkSkill += graph[j][i];
                    }
                }
            }
            // 최솟값 갱신
            minGap = Math.min(Math.abs(startSkill - linkSkill), minGap);
            return;
        }

        for (int i = index; i < n; i++) {
            if (!teamArr.contains(i)) {
                teamArr.add(i);
                makeTeam(i + 1);
                teamArr.remove(teamArr.size() - 1);
            }
        }
    }
}
