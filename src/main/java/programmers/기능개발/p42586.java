package programmers.기능개발;

import java.util.ArrayList;
import java.util.Stack;

public class p42586 {

    public static void main(String[] args) {

        Solution sol = new Solution();

        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        sol.solution(progresses, speeds);
    }
}

class Solution {
    public ArrayList<Integer> solution(int[] progresses, int[] speeds) {

        Stack<Integer> result = new Stack<>();

        for(int i=1; i<progresses.length+1; i++)
        {
            result.add(i);
        }

        int j = 0;
        int prev_j = 0;
        ArrayList<Integer> answer = new ArrayList<>();

        do
        {
            //매 회차, 배포되지 않은 프로그램들의 개발이 한 단계씩 수행된다.
            for(int i=j; i<progresses.length; i++)
            {
                progresses[i] += speeds[i];

                //이번 개발로 인해 개발이 완료 되었는가?
                if(progresses[j] >= 100)
                {
                    j++;
                    result.pop();
                }
            }

            //이번 for 루프를 돌 동안에는 j가 얼마나 증가했는가?
            answer.add(j - prev_j);

            //이미 answer 에 넣었으므로 이번에 완료된 작업들에 대해서는 더이상 신경 x
            prev_j = j;

        }while(!result.isEmpty());      //스택(작업)이 빌때까지 수행한다.

        //위의 이번 for 루플를 돌 동안에는 j가 얼마나 증가했는가?
        // => 증가하지 않은 경우들을 전부 제거
        answer.removeIf(n -> (n == 0));

        return answer;

    }
}