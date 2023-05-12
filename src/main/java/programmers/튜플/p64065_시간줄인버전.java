package programmers.튜플;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class p64065_시간줄인버전 {
}


class Solution2 {
    public int[] solution(String s) {
        String[] splitRBrace = s.substring(2, s.length() - 2).split("},\\{");

        List<String> splitList = Arrays.asList(splitRBrace);
        Comparator<String> lengthComparator = Comparator.comparing(String::length);
        List<String> strings = splitList.stream()
                .sorted(lengthComparator)
                .collect(Collectors.toList());

        ArrayList<Integer> answerList = new ArrayList<>();
        for(int i=0; i<strings.size(); i++) {
            String[] splitComma = strings.get(i).split(",");
            for(int j=0; j<splitComma.length; j++) {
                int num = Integer.parseInt(splitComma[j]);
                if(!answerList.contains(num)) {
                    answerList.add(num);
                    break;
                }
            }
        }

        int[] answer = answerList.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}

