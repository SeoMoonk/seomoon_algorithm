package programmers.체육복;

import java.util.Scanner;

public class p42862 {
}

/*
        n = 전체 학생 수
        lost = 체육복을 도난당한 학생들
        reserve = 여벌의 체육복이 있는 학생들
        answer(return) = 체육 수업을 들을 수 있는 학생의 최댓값

        여벌 체육복을 가져온 학생이 체육복을 도난당했을 경우도 있다.
        이 때, 이 학생은 체육복을 하나만 도난당했다고 가정하며,
        남은 체육복이 하나이기에 다른 학생에게는 체육복을 빌려줄 수 없다.

        1. 여벌 체육복을 가져온 학생들 중에, 도난 당했을 경우(빌려주지 못하고 혼자만 참여 가능)를 생각
        2. 여벌 체육복이 있는 학생들 중 앞, 뒤 친구에게 빌려줄 수 있는 경우를 생각
*/

class Solution {
    public int solution(int n, int[] lost, int[] reserve)
    {
        int answer = n - lost.length; //(전체 학생에서 일단 도난당했다는 학생들만 조사한 것.)


        //1. 여벌이 있었지만 한 벌을 도난당한 경우의 처리
        for(int i=0; i<lost.length; i++)
        {
            for(int j=0; j<reserve.length; j++)
            {
                if(lost[i] == reserve[j])   //잃어버린사람 명단에 있을 경우
                {
                    lost[i] = 0;       //잃어버림 -> 참여 가능함
                    reserve[j] = 0;    //여벌이 있었음 -> 더이상 빌려줄 수 없음
                    answer++;          //잃어버린 사람 명단에서 한명이 빠졌네? -> 인원추가.

                    break;
                }
            }
        }

        //2. 여벌 체육복이 있는 학생들 중 앞, 뒤 친구에게 빌려줄 수 있는 경우를 생각
        for(int i=0; i<lost.length; i++)
        {
            if(lost[i] != 0)           //잃어버린 친구인가?
            {
                for(int j=0; j<reserve.length; j++)
                {
                    if(reserve[j] != 0) //여벌이 있는가?
                    {
                        int prevStudent = reserve[j]-1;
                        int nextStudent = reserve[j]+1;

                        //잊어버린 친구의 번호가 여벌이 있는 친구의 앞 or 뒷 사람인가?
                        if( (lost[i] == prevStudent) || (lost[i] == nextStudent) )
                        {
                            reserve[j] = 0;
                            answer++;

                            break;
                        }
                    }
                }
            }
        }
        return answer;
    }
}
