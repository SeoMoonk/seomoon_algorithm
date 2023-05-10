package programmers.순위검색;

import java.util.ArrayList;

public class p72412 {
}

class Solution {

    public static void main(String[] args) {

        String[] info = new String[3];

        info[0] = "java backend junior pizza 300";
        info[1] = "python frontend senior chicken 300";
        info[2] = "python frontend senior chicken 200";

        String[] query = new String[3];

        query[0] = "java and backend and junior and pizza 100";
        query[1] = "python and frontend and senior and chicken 200";
        query[2] = "cpp and - and senior and - 250";

        Solution sol = new Solution();

        sol.solution(info, query);

    }
    public ArrayList<Integer> solution(String[] info, String[] query) {

        ArrayList<Integer> answer = new ArrayList<>();

        //info(지원자 정보) => 사용 언어 / 백 or 프론트 / 주니어 or 시니어 / 치킨 or 피자 / 코딩테스트 점수
        // => ex) java backend junior chicken 80

        //query(문의 조건) => java / backend / 경력 상관 X / chicken / 70점 이상
        // => ex) java and backend and - and chicken and 70

        int infoLength = info.length;
        String[][] infoArr = new String[infoLength][5];

        for(int i=0; i<infoLength; i++)
        {
            infoArr[i] = info[i].split(" ");
        }

        int queryLength = query.length;
        String[][] queryArr = new String[queryLength][5];
        String[][] querySplit = new String[queryLength][5];
        String[] foodSplit = new String[2];

        ArrayList<Integer> indexList = new ArrayList<>();

        for(int i=0; i<queryLength; i++)
        {
            querySplit[i] = query[i].split(" and ");

            foodSplit = querySplit[i][3].split(" ");

            for(int j=0; j<querySplit.length; j++)
            {
                queryArr[i][j] = querySplit[i][j];
            }

            queryArr[i][3] = foodSplit[0];
            queryArr[i][4] = foodSplit[1];
        }

        String[] tmpArr = new String[5];
        ArrayList<Integer> intArr = new ArrayList<>();

        for(int i=0; i<infoLength-1; i++)
        {
            int front = Integer.parseInt(infoArr[i][4]);
            int back = Integer.parseInt(infoArr[i+1][4]);

            if(front > back)
            {
                tmpArr = infoArr[i];
                infoArr[i] = infoArr[i+1];
                infoArr[i+1] = tmpArr;
            }

            int afterInt = Integer.parseInt(infoArr[i][4]);

            intArr.add(i, afterInt);
        }

        intArr.add(infoLength-1, Integer.parseInt(infoArr[infoLength-1][4]));

        for(int i=0; i<queryLength; i++)
        {
            answer.add(i, 0);
            int target = Integer.parseInt(queryArr[i][4]);

            // "index" 이상으로만 조건 검색하면 된다고 알게 되었음.
            int index = binarySearch(intArr, target);

            for(int j=index; j<infoLength; j++)
            {
                if(!queryArr[i][0].equals("-") && !queryArr[i][0].equals(infoArr[j][0]))
                {
                    break;
                }

                if(!queryArr[i][1].equals("-") && !queryArr[i][1].equals(infoArr[j][1]))
                {
                    break;
                }

                if(!queryArr[i][2].equals("-") && !queryArr[i][2].equals(infoArr[j][2]))
                {
                    break;
                }

                if(!queryArr[i][3].equals("-") && !queryArr[i][3].equals(infoArr[j][3]))
                {
                    break;
                }

                answer.add(i, answer.get(i)+1);
            }
        }

        System.out.println("answer = " + answer);

        return answer;
    }

    int binarySearch(ArrayList<Integer> intArr, int target)
    {
        int left = 0;
        int right = intArr.size() - 1;

        while(left <= right)
        {
            int mid = (left + right) / 2;

            if(intArr.get(mid) < target)
            {
                left = mid + 1;
            }
            else
            {
                right = mid - 1;
            }
        }

        return left;
    }
}