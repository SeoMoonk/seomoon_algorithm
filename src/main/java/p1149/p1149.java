package p1149;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p1149 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        List<House> houseList = new ArrayList<>();
        String[][] resultArr = new String[N][2];

        int result = 0;

        for(int i=0; i<N; i++)
        {
            int r = sc.nextInt();
            int g = sc.nextInt();
            int b = sc.nextInt();

            House house = new House(r, g, b);

            String[] splitStr = house.getMin().split(",");

            resultArr[i][0] = splitStr[0];
            resultArr[i][1] = splitStr[1];

            houseList.add(house);
        }

        for(int i=1; i<N; i++)
        {
            //만약 앞의 거랑 내용이 같다면, 어떤것의 값이 더 작은지를 비교함
            if(i!=0)
            {
                //내 앞에 같은색으로 칠해진 집이 발견된다면
                if(resultArr[i][0].equals(resultArr[i-1][0]))
                {
                    int frontValue = Integer.parseInt(resultArr[i-1][1]);
                    int backValue = Integer.parseInt(resultArr[i][1]);

                    String[] secondMin;

                    //앞이 뒤보다 작으면, 뒤를 변경
                    if(frontValue < backValue)
                    {
                        secondMin = houseList.get(i).getSecondMin(resultArr[i][0]).split(",");

                        resultArr[i][0] = secondMin[0];
                        resultArr[i][1] = secondMin[1];
                    }
                    else
                    {
                        secondMin = houseList.get(i-1).getSecondMin(resultArr[i-1][0]).split(",");
                        resultArr[i-1][0] = secondMin[0];
                        resultArr[i-1][1] = secondMin[1];
                    }

                    i--;
                }
            }
        }

        for(int i=0; i<N; i++)
        {
            result += Integer.parseInt(resultArr[i][1]);
        }

        System.out.println(result);
    }
}

class House {

    private int r;
    private int g;
    private int b;

    public House(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public String getMin() {

        int min = Math.min(Math.min(r, g), b);

        if(min == r) {
            return "r,%d".formatted(r);
        }
        else if(min == g) {
            return "g,%d".formatted(g);
        }
        else {
            return "b,%d".formatted(b);
        }
    }

    public String getSecondMin(String firstMinRGB) {

        if(firstMinRGB.equals("r"))
        {
            //g가 더 작으면
            if(g<b)
            {
                return "g,%d".formatted(g);
            }
            else
            {
                return "b,%d".formatted(b);
            }
        }
        else if(firstMinRGB.equals("g"))
        {
            if(r<b)
            {
                return "r,%d".formatted(r);
            }
            else
            {
                return "b,%d".formatted(b);
            }
        }
        else
        {
            if(r<g)
            {
                return "r,%d".formatted(r);
            }
            else
            {
                return "g,%d".formatted(g);
            }
        }
    }
}