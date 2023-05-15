package programmers.다리를_지나는_트럭;

import java.util.LinkedList;

public class p42583 {

    public static void main(String[] args) {

        Solution sol1 = new Solution();

        int bridge_length1 = 2;
        int weight1 = 10;
        int[] truck_weight1 = {7, 4, 5, 6};

        int bridge_length2 = 100;
        int weight2 = 100;
        int[] truck_weight2 = {10};

        int solution1 = sol1.solution(bridge_length1, weight1, truck_weight1);

        System.out.println("solution1 = " + solution1);

        int solution2 = sol1.solution(bridge_length2, weight2, truck_weight2);

        System.out.println("solution2 = " + solution2);

    }

}

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {

        // bridge_length = 다리에 올라갈 수 있는 차량의 수 이면서, 다리의 길이
        // weight = 다리가 버틸 수 있는 최대 무게
        // truck_weights = 트럭들의 무게 배열

        int answer = 0;
        int now_length = bridge_length;
        int time_count = 0;         // = answer

        // 얼마나 더 가야하는가? (feat. now_length)
        LinkedList<Integer> lengthList = new LinkedList<>();

        LinkedList<Integer> truckList = new LinkedList<>();      // 대기 트럭
        LinkedList<Integer> passingList = new LinkedList<>();    // 다리를 건너고 있는 트럭
        LinkedList<Integer> endList = new LinkedList<>();        // 다리를 다 지난 트럭

        // 배열을 큐로 만듦.
        for (int i = 0; i < truck_weights.length; i++) {
            truckList.offer(truck_weights[i]);
        }

        while (!truckList.isEmpty() || !passingList.isEmpty()) {

            // 지나고 있는 트럭이 있을 때
            if (!passingList.isEmpty())
            {
                // passingList 내의 모든 내용들
                for (int i = 0; i < passingList.size(); i++) {
                    // 길이 감소
                    int setLength = lengthList.get(i) - 1;
                    lengthList.set(i, setLength);
                }

                for (int i = 0; i < lengthList.size(); i++) {
                    // 다 지나갔다면
                    if (lengthList.get(i) <= 0) {
                        weight += passingList.get(i);

                        // 지나고 있는 리스트에서 제외, 끝난 리스트에 추가
                        endList.add(passingList.poll());

                        lengthList.poll();

                        i--;
                    }
                }
            }

            if (!truckList.isEmpty()) {
                // 현재 남은 길이에 트럭의 적재가 가능한가?
                boolean canLoading = weight - truckList.peek() >= 0;

                // 적재하기
                if (canLoading) {
                    weight -= truckList.peek();
                    lengthList.offer(bridge_length);
                    passingList.offer(truckList.poll());
                }
            }

            time_count++;
        }

        answer = time_count;

        return answer;
    }
}
