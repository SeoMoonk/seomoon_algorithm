package p1149;

import java.util.Scanner;

public class p1149_re {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[][] houses = new int[N][3];

        for(int i=0; i<N; i++)
        {
            for(int j=0; j<3; j++)
            {
                houses[i][j] = sc.nextInt();
            }
        }

        int[] dynamic = new int[3];

        dynamic[0] = houses[0][0];
        dynamic[1] = houses[0][1];
        dynamic[2] = houses[0][2];

        for(int i=1; i<N; i++)
        {
            int frontR = dynamic[0];
            int frontG = dynamic[1];
            int frontB = dynamic[2];

            dynamic[0] = Math.min(frontG, frontB) + houses[i][0];
            dynamic[1] = Math.min(frontR, frontB) + houses[i][1];
            dynamic[2] = Math.min(frontR, frontG) + houses[i][2];
        }

        int minCost = Math.min(Math.min(dynamic[0], dynamic[1]), dynamic[2]);

        System.out.println(minCost);
    }
}