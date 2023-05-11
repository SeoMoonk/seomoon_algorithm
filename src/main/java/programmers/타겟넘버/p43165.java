package programmers.타겟넘버;

public class p43165 {
}

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = dfs(numbers, target, 0, 0);
        return answer;
    }


    //DFS 로 모든 경우의 수를 탐색
    public int dfs(int[] numbers, int target, int sum, int index) {

        if(index == numbers.length)
        {
            if(sum == target) {
                return 1;
            }
            else {
                return 0;
            }
        }

        int result = 0;

        result = result + dfs(numbers, target, sum + numbers[index], index + 1);
        result = result + dfs(numbers, target, sum - numbers[index], index + 1);

        return result;

    }
}