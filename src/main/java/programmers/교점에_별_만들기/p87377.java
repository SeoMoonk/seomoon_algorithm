package programmers.교점에_별_만들기;

public class p87377 {

    public static void main(String[] args) {



    }
}

class Solution {
    public String[] solution(int[][] line) {
        String[] answer = {};
        return answer;
    }

    //두 직선의 교점 구하기
    public long[] intersection(int[] line1, int[] line2) {


        // Ax + By + E = 0
        long A = line1[0];
        long B = line1[1];
        long E = line1[2];

        // Cx + Dy + F = 0
        long C = line2[0];
        long D = line2[1];
        long F = line2[2];

        if( A * D - B * C == 0) return null;

        double x = (double) ((B * F) - (E * D)) / ((A * D) - (B * C));
        double y = (double) ((E * C) - (A * F)) / ((A * D) - (B * C));

        if(x != (long) x ) return null;
        if(y != (long) y ) return null;

        return new long[]{(long) x, (long) y};


    }
}
