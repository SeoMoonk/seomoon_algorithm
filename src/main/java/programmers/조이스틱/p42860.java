package programmers.조이스틱;

import java.util.Arrays;
import java.util.Scanner;

public class p42860 {

    public static void main(String[] args) {

        /*
        1. 입력될 NAME 이 몇 글자의 길이를 갖는가?
        2. 키를 누를 때마다 알파벳이 변하는가? (일단 한 단어 만이라도) (ASCII = 65 ~ 90)
            2-1. 알파벳이 변할 때, A(65)에서 내려가면 Z(90), Z(90)에서 올라가면 A(65)가 되야 한다.
        3. 우측, 좌측으로 이동할 때 선택되는 문자가 달라지는가?
            3-1. 맨 왼쪽(0)에서 왼쪽으로 이동하면 오른쪽 끝으로(length-1), 맨 오른쪽(length-1)에서 오른쪽으로 이동하면 왼쪽 끝(0)으로 이동
        4. (Greedy) 최소한의 이동 횟수를 값으로 얻어낼 수 있는가?
            4-1. ex) A에서 Z가 되려면 최소 몇번의 이동이 필요한가? (중간값(M)을 알아내고, 그보다 큰지 작은지)
            4-2. 좌측, 우측으로 이동할 때, 중간에 A같은 이동이 필요없는 친구가 껴있다면 어떤 쪽이 더 횟수가 적은가?
                 ex) JAZ 라고 한다면, J를 설정하고 우측 두번보다 좌측 한번이 더 빠르다.
        */

        Scanner sc = new Scanner(System.in);

        String name = sc.nextLine();

        int name_length = name.length();

        String[] name_arr = new String[name_length];
        Arrays.fill(name_arr,"A");

        String command;
        Character currentChar;
        int current = 0;
        int codeValue;
        int count = 0;

        while(true)
        {
            command = sc.nextLine();
            currentChar = name_arr[current].charAt(0);

            if(command.equals("up"))
            {
                codeValue = currentChar.hashCode();

                if(codeValue == 90)
                {
                    currentChar = 'A';
                }
                else
                {
                    currentChar++;
                }

                name_arr[current] = currentChar.toString();
                count++;
            }
            else if(command.equals("down"))
            {
                codeValue = currentChar.hashCode();

                if(codeValue == 65)
                {
                    currentChar = 'Z';
                }
                else
                {
                    currentChar--;
                }

                name_arr[current] = currentChar.toString();
                count++;
            }
            else if(command.equals("left"))
            {
                if(current == 0)
                {
                    current = name_length-1;
                }
                else
                {
                    current--;
                }
                count++;
            }
            else if(command.equals("right"))
            {
                if(current == name_length-1)
                {
                    current = 0;
                }
                else
                {
                    current++;
                }
                count++;
            }
            else if(command.equals("exit"))
            {
                for(int i=0; i<name_length; i++)
                {
                    System.out.print(name_arr[i]);
                }
                System.out.println("\ncount : " + count );
                return;
            }
        }
    }
}

class Solution {
    public int solution(String name) {
        int answer = 0;
        int name_length = name.length();
        int minMove = name_length - 1;       //좌우 이동을 최소화한 경우의 이동 횟수

        for(int i=0; i< name_length; i++)
        {
            int nextChar = name.charAt(i) - 'A';    //다음에 선택할 문자의 알파벳의 순서값
            int moveUpDown = Math.min(nextChar, 26 - nextChar); //상하 이동중 최단 거리 (중간(m)을 기준으로 위로 쭉 가는게 빠른가? 아래로 쭉 가는게 빠른가?)

            answer += moveUpDown;

            int next = i + 1; //다음에 선택할 문자의 인덱스

            //A가 연속해서 나오는 경우 다음 문자로 건너뛰기
            while(next < name_length && name.charAt(next) == 'A')
            {
                next++;
            }

            // ★★★ 좌우 이동을 최소화한 경우의 이동 횟수 갱신 ★★★
            minMove = Math.min(minMove,  //모든 인덱스에 A가 없다면, minMove(name_length-1)만큼 전부 움직임이 필요함.
                    i + name_length - next +        //현재 문자를 A로 조작하기 위한 이동횟수 + 다음 조작할 문자까지 가기 위한 이동 횟수
                            Math.min(i, name_length - next)
                    //현재 문자에서 이동할 방향이 왼쪽인 경우, 왼쪽 끝에서 오른쪽으로 이동하는 경우도 고려
            );
        }
        answer += minMove;

        return answer;
    }
}


