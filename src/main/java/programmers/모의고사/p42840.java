package programmers.모의고사;

import java.util.ArrayList;
import java.util.Arrays;

public class p42840 {
}

class Solution {

    public ArrayList<Integer> solution(int[] answers) {

        int index1;
        int index2;
        int index3;

        int[] s1 = {1, 2, 3, 4, 5};
        int[] s2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] s3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] count = new int[3];

        ArrayList<Integer> answer = new ArrayList<>();

        for(int i=0; i<answers.length; i++)
        {
            index1 = i%s1.length;
            index2 = i%s2.length;
            index3 = i%s3.length;

            if(answers[i] == s1[index1])
            {
                count[0]++;
            }

            if(answers[i] == s2[index2])
            {
                count[1]++;
            }

            if(answers[i] == s3[index3])
            {
                count[2]++;
            }
        }

        //현재 count 배열에서 최대값이 뭔가?
        int max = Arrays.stream(count).max().getAsInt();

        for(int i=0; i<count.length; i++)
        {
            //최대값이 같은 친구들(최대로 정답수가 같은 친구들)을 정답 배열에 넣음.
            if(max == count[i])
            {
                answer.add(i+1);
            }
        }

        return answer;
    }
}
