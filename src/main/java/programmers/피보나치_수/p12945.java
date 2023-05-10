package programmers.피보나치_수;

public class p12945 {
}

class Solution {
    public int solution(int n) {
        int answer = fibo(n);
        return answer;
    }

    public int fibo(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibo(n - 1) + fibo(n - 2);
        }
    }
}



