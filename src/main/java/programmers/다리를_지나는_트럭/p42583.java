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
        int answer = 0;
        int now_length = bridge_length;
        int time_count = 0;

        LinkedList<Integer> lengthList = new LinkedList<>();
        LinkedList<Integer> truckList = new LinkedList<>();
        LinkedList<Integer> passingList = new LinkedList<>();
        LinkedList<Integer> endList = new LinkedList<>();

        for (int i = 0; i < truck_weights.length; i++) {
            truckList.offer(truck_weights[i]);
        }

        while (!truckList.isEmpty() || !passingList.isEmpty()) {
            if (!passingList.isEmpty()) {
                for (int i = 0; i < passingList.size(); i++) {
                    int setLength = lengthList.get(i) - 1;
                    lengthList.set(i, setLength);
                }

                for (int i = 0; i < lengthList.size(); i++) {
                    if (lengthList.get(i) <= 0) {
                        weight += passingList.get(i);
                        endList.add(passingList.poll());
                        lengthList.poll();
                        i--;
                    }
                }
            }

            if (!truckList.isEmpty()) {
                boolean canLoading = weight - truckList.peek() >= 0;
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
