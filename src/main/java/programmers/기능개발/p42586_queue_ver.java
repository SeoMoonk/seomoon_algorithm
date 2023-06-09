package programmers.기능개발;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class p42586_queue_ver {

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        int[] result = solution2.solution(progresses, speeds);
        IntStream.of(result).forEach(System.out::println);
    }

}

class Solution2 {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = IntStream
                .range(0, progresses.length)
                .mapToObj(i -> (int) Math.ceil((100.0 - progresses[i]) / speeds[i]))
                .collect(Collectors.toCollection(LinkedList::new));

        List<Integer> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            int remains = queue.poll();
            int count = 1;

            while (!queue.isEmpty() && remains >= queue.peek()) {
                queue.poll();
                count++;
            }

            result.add(count);
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}