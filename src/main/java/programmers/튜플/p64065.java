package programmers.튜플;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class p64065 {
}

class Solution {

    public static void main(String[] args) {

        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        String s2 = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
        String s3 = "{{20,111},{111}}";

        Solution sol = new Solution();

        int[] solution = sol.solution(s);
        int[] solution1 = sol.solution(s2);
        int[] solution2 = sol.solution(s3);

    }

    public int[] solution(String s) {

        String delLBrace = s.replace("{", "");

        String[] splitRBrace = delLBrace.split("}");

        List<String> splitList = new ArrayList<>();

        for(int i=0; i<splitRBrace.length; i++)
        {
            splitList.add(splitRBrace[i].replace(",", ""));
        }

        Stream<String> stringStream = splitList.stream();

        Comparator<String> lengthComparator = Comparator.comparing(String::length);

        stringStream = stringStream.sorted(lengthComparator);

        List<String> strings = stringStream.collect(Collectors.toList());

        ArrayList<Integer> answerList = new ArrayList<>();

        for(int i=0; i<strings.size(); i++)
        {
            if(i != 0)
            {
                for(int j=0; j<i; j++)
                {
                    strings.set(i, strings.get(i).replace(strings.get(j), ""));
                }

                answerList.add(i, Integer.parseInt(strings.get(i)));
            }
            else
            {
                answerList.add(i, Integer.parseInt(strings.get(i)));
            }
        }

        int[] answer = new int[answerList.size()];

        for(int i=0; i<answerList.size(); i++)
        {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}