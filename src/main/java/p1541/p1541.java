package p1541;

import java.util.Scanner;

public class p1541 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String expression = sc.nextLine();

        System.out.println("expression = " + expression);

        String[] arr = expression.split("-");

        int result = 0;
        int plus_result = 0;
        int[] nums = new int[arr.length];

        //문제점 -> +만 주어진 식일 경우에는?
        //-> 처음부터 +로 나누기...?
        //arr.length == 1인 경우는 더하는 식만 있을 경우밖에 없다.
        if(arr.length == 1)
        {
            arr = expression.split("\\+");

            for(int i=0; i<arr.length; i++)
            {
                result += Integer.parseInt(arr[i]);
            }

            System.out.println("result = " + result);
            return;
        }

        result = Integer.parseInt(arr[0]);
        nums[0] = Integer.parseInt(arr[0]);

        for(int i=1; i<arr.length; i++)
        {
            //-로 분할했을 때 단순 수가 아닌 +가 함께있는 식이 주어진다면
            //변환이 불가능하기 때문에, +기준으로 잘라준 후 더한 값을 다시 대입해준다.
            if(arr[i].contains("+"))
            {
                String[] plus_arr = arr[i].split("\\+");
                for(int j=0; j<plus_arr.length; j++)
                {
                    plus_result += Integer.parseInt(plus_arr[j]);
                }
                nums[i] = plus_result;
                plus_result = 0;
            }
            else
            {
                nums[i] = Integer.parseInt(arr[i]);
            }
            result -= Integer.parseInt(arr[i]);
        }
        System.out.println("result = " + result);
    }
}
