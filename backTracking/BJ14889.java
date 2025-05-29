// 스타트와 링크 
import java.util.*;

public class BJ14889 {
    static int n;
    static int minSkill = Integer.MAX_VALUE; // 최댓값으로 설정.
    static int[][] graph;
    static ArrayList<Integer> teamA = new ArrayList<>();
    static ArrayList<Integer> teamIndex = new ArrayList<>();
    
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
        System.out.println(minSkill);
    }

    public static void makeTeam(int index) {
        
        // 팀원이 완성되면
        if (teamA.size() == n / 2) {
            // 나머지 팀 구성
            ArrayList<Integer> teamB = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (!teamA.contains(i)) {
                    teamB.add(i);
                }
            }

            /* ------------- 인덱스 조합하기 ------------ */
            // 팀 A
            ArrayList<int[]> returnIndex = new ArrayList<>();
            makeTeamIndex(teamA, 0, returnIndex);
    
            // 팀 B
            ArrayList<int[]> returnIndexB = new ArrayList<>();
            makeTeamIndex(teamB, 0, returnIndexB);

            /* ------------- 능력치 구하기 ------------ */
            // team A
            int teamASkill = 0;
            for (int i = 0; i < returnIndex.size(); i++) {
                int skill = 0; // 초기화
                teamASkill += graph[returnIndex.get(i)[0]][returnIndex.get(i)[1]];
                teamASkill += graph[returnIndex.get(i)[1]][returnIndex.get(i)[0]];
                teamASkill += skill;
            }

            // Team B
            int teamBSkill = 0;
            for (int i = 0; i < returnIndexB.size(); i++) {
                int skill = 0;
                teamBSkill += graph[returnIndexB.get(i)[0]][returnIndexB.get(i)[1]];
                teamBSkill += graph[returnIndexB.get(i)[1]][returnIndexB.get(i)[0]];
                teamBSkill += skill;
            }

            // 능력치 차이 구하기
            int skillGap = Math.abs(teamASkill - teamBSkill);
            minSkill = Math.min(minSkill, skillGap);
        }

        for (int i = index; i < n; i++) {
            // 만약 teamA에 없다면
            if (!teamA.contains(i)) {
                teamA.add(i);
                makeTeam(i + 1);
                teamA.remove(teamA.size() - 1);
            }
        }
    }
     
    // 팀원 조합
    public static void makeTeamIndex(ArrayList<Integer> arr, int index, ArrayList<int[]> returnIndex) {
        if (teamIndex.size() == 2) {
            int[] addValue = {teamIndex.get(0), teamIndex.get(1)}; 
            returnIndex.add(addValue); // 깊은 복사로 넣기.
            return;
        }
        for (int i = index; i < arr.size(); i++) {
                teamIndex.add(arr.get(i));
                makeTeamIndex(arr, i + 1, returnIndex);
                teamIndex.remove(teamIndex.size() - 1);
        }
    }
}
