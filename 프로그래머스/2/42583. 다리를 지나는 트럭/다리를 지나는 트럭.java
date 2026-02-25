import java.util.*;

class Solution {

    public boolean canEnterBridge(int totalWeight, int nextTruckWeight, int maxWeight) {
        return totalWeight + nextTruckWeight <= maxWeight;
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int idx = 0;
        int totalWeight = 0;
    
        Queue<Integer> bridge = new LinkedList<>();

        // 다리 초기화
        for (int i = 0; i < bridge_length; i++) {
            bridge.add(0);
        }

        // 첫 번째 트럭 설정
        bridge.poll();                   
        bridge.add(truck_weights[idx]); 
        totalWeight += truck_weights[idx];
        idx++;
        time++;

        // 모든 트럭이 다리를 건널 때 까지 반복
        while (true) {
            time++;

            // 매 초마다 트럭 제거
            int outTruck = bridge.poll();
            totalWeight -= outTruck;

            // 모든 트럭이 다리를 다 건넜다면 종료
            if (idx == truck_weights.length && totalWeight == 0) {
                return time;
            }

            // 현재 트럭을 다리에 올릴 수 있다면
            if (idx < truck_weights.length && canEnterBridge(totalWeight, truck_weights[idx], weight)) {
                bridge.add(truck_weights[idx]);
                totalWeight += truck_weights[idx];
                idx++;
            }

            // 트럭을 올릴 수 없다면
            else {
                bridge.add(0); // 시간만 흐름.
            }
        }
    }
}
