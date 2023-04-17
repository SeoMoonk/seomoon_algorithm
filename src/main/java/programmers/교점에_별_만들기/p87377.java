package programmers.교점에_별_만들기;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    public Point intersection(int[] line1, int[] line2) {


        // Ax + By + E = 0
        double A = line1[0];
        double B = line1[1];
        double E = line1[2];

        // Cx + Dy + F = 0
        double C = line2[0];
        double D = line2[1];
        double F = line2[2];

        double divisor = (A * D) - (B * C);

        //평행한 경우(무수히 많은 교점이 발생하는 경우)는 예외로 한다.
        if(divisor == 0) return null;

        double x = ((B * F) - (E * D)) / divisor;
        double y = ((E * C) - (A * F)) / divisor;

        //정수가 아닌 좌표는 구하지 않음.
        if(x != (long) x ) return null;
        if(y != (long) y ) return null;

        return Point.of(x, y);
    }

    public List<Point> intersections(int[][] line) {
        List<Point> points = new ArrayList<>();

        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                int[] line1 = line[i];
                int[] line2 = line[j];

                Point point = intersection(line1, line2);

                if (point != null) points.add(point);
            }
        }

        return points;
    }
}

class Point {


    public final long x;
    public final long y;

    private Point(long x, long y) {
        this.x = x;
        this.y = y;
    }

    // 정수(long)로 세팅하는 용도
    public static Point of(long x, long y) {
        return new Point(x, y);
    }

    // 실수(double)로 세팅하는 용도
    public static Point of(double x, double y) {
        return of((long) x, (long) y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point point)) return false;

        if (x != point.x) return false;
        return y == point.y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
