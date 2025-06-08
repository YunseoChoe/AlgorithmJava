// 리모컨
package bruteForce;

import java.util.*;

public class BJ1107 {
    static int n;
    static int m;
    static int start = 100;
    static int minValue;
    static int minOrMaxChannel;
    static int[] brokens;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 입력
        n = scanner.nextInt();
        m = scanner.nextInt();
        brokens = new int[m];
        for (int i = 0; i < m; i++) {
            brokens[i] = scanner.nextInt();
        }

        // 100이면 바로 종료.
        if (n == 100) {
            System.out.println(0);
            System.exit(0); 
        }

        int minChannel = -1;
        int maxChannel = -1;

        // 고장난 버튼이 없다면 이동할 채널이 기준
        if (m == 0) {
            minChannel = n;
            maxChannel = n;
        }

        // 고장난 버튼이 있다면
        else {
            // 고장난 버튼 제외한 번호 중 가장 가까운 최솟값 찾기
            for (int i = n - 1; i >= 0; i--) {
                boolean isNotInclude = false;
                for (int j = 0; j < m; j++) {
                    if (String.valueOf(i).contains(String.valueOf(brokens[j]))) {
                        isNotInclude = true; // true로 변경.
                    }
                }
                // 고장난 번호가 없다면
                if (!isNotInclude) {
                    minChannel = i;
                    break;
                }
            }

            // 최댓값 찾기
            for (int i = n + 1; i <= 999999; i++) { // 최대 몇으로 해야 함?
                boolean isNotInclude = false;
                for (int j = 0; j < m; j++) { 
                    if (String.valueOf(i).contains(String.valueOf(brokens[j]))) {
                        isNotInclude = true;
                    }    
                }
                // 고장난 번호가 없다면
                if (!isNotInclude) {
                    maxChannel = i;
                    break;
                }
            }

            // 최소 채널이 없으면
            if (minChannel == -1) {
                
            }
            // 최대 채널이 없으면
            else if (maxChannel == -1) {
                
            }
        }

        System.out.println("minChannel= " + minChannel);
        System.out.println("maxChannel= " + maxChannel);
        
        // 100에서 min으로 가는 최소 경우의 수 구하기
        int minMinValue;
        // 최소 채널이 있는 경우만
        if (minChannel != -1) {
            // +, - 으로 이동
            int startMinChannelDiff = Math.abs(start - minChannel);
            // 채널 번호 직접 누르기
            int minChannelLength = String.valueOf(minChannel).length(); // 최종 자료형은 int.
            minMinValue = Math.min(startMinChannelDiff, minChannelLength);
        } 
        else {
            minMinValue = Integer.MAX_VALUE; // 완전 큰 수로 대체
        }
        
        // 100에서 max으로 가는 최소 경우의 수 구하기
        int maxMinValue;
        // 최대 채널이 있는 경우만
        if (maxChannel != -1) {
            int startMaxChannelDiff = Math.abs(start - maxChannel);
            int maxChannelLength = String.valueOf(maxChannel).length();
            maxMinValue = Math.min(startMaxChannelDiff, maxChannelLength);
        }
        else {
            maxMinValue = Integer.MAX_VALUE;
        }

        System.out.println("minMinValue= " + minMinValue);
        System.out.println("maxMinValue= " + maxMinValue);

          
        // 최소 채널, 최대 채널 중 더 최솟값 구하기
        if (minMinValue < maxMinValue) {
            minValue = minMinValue;
            minOrMaxChannel = minChannel;
        }
        else if (minMinValue > maxMinValue) {
            minValue = maxMinValue;
            minOrMaxChannel = maxChannel;
        }
        // 똑같을 경우
        else {
            minValue = maxMinValue;
            minOrMaxChannel = maxChannel;
        }
      
        // System.out.println("100에서 최소 채널로 가는 경우의 수= " + minValue);
        // System.out.println(minOrMaxChannel);
        // 100에서 최소 채널로 이동 + 최소 채널에서 n까지 이동
        System.out.println(minValue + Math.abs(n - minOrMaxChannel));
    }

}
