//package programmers.하노이의_탑;
//
//import java.util.ArrayList;
//import java.util.Scanner;
//import java.util.Stack;
//
//// 가장 큰 것부터 3번에 순서대로 쌓여야 한다.
//// 원판의 개수가 늘어날 때마다 사이즈 또한 1씩 줄어든다고 가정 해보도록 하자.
//// 3번에 순서대로 쌓여야 하는 것은 맞지만, 2번과 마찬가지로 3번을 tmp로 사용할 수 있도록 하자.
//// 주의할 점은, 예를 들어 5번 원판을 2번 막대에 넣었다면 4번 원판은 2번 막대에 넣을 수 없다.
//// -> 5번 원판이 4번 원판보다 작기 때문에, 5번 위에 4번을 얹을 수 없음.
//
//public class p12946 {
//
//    static Stack<Circle>[] tower = new Stack[3];
//    static int n;
//
//    public static void main(String[] args) {
//
//        Scanner sc = new Scanner(System.in);
//
//        n = sc.nextInt();
//
//        setting(n); //수행 배경 생성
//
//        System.out.println("tower = " + tower.length);
//
////        for(int i=0; i<tower.length; i++)
////        {
////            for(int j=0; j<n; j++)
////            {
////                System.out.print(tower[i].get(j).circle_size);
////            }
////            System.out.println(" ");
////        }
//        hanoi(tower);//실제 동작
//
//
//    }
//
//
//    public static void setting(int n) {
//
//        tower[0] = new Stack<Circle>();
//        tower[1] = new Stack<Circle>();
//        tower[2] = new Stack<Circle>();
//
//        for (int j = n; j > 0; j--) {
//            tower[0].push(new Circle(j));
//        }
//    }
//
//    public static void hanoi(Stack<Circle>[] tower) {
//
//        Circle tmp;
//
//        //1인 경우만 예외처리
//        if (n == 1)
//        {
//            tmp = tower[0].get(0);
//            tower[0].pop();
//            tower[2].push(tmp);
//        }
//        else
//        {
//            //재귀
//            //from, sub, to
//            if(tower[0].lastElement().circle_size == n && tower[2].lastElement() == null)
//            {
//                if(tower[2].lastElement() == null)
//                {
//                    tmp = tower[0].get(0);
//                    tower[0].pop();
//                    tower[2].push(tmp);
//                }
//            }
//            else
//            {
//
//            }
//        }
//    }
//}
//
//class Circle {
//
//    int circle_size;
//
//    public Circle(int circle_size) {
//        this.circle_size = circle_size;
//    }
//}
//
//
//
//
