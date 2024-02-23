package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 피보나치_함수 {

    static class Node {
        int zero;//0이 몇개냐
        int one;//1이 몇개 출력이 되냐

        public Node(int zero, int one) {
            this.zero = zero;
            this.one = one;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            int size = Integer.parseInt(br.readLine());//몇번째 피보나치수.
            if (size == 0) {
                System.out.println("1 0");
            } else if (size == 1) {
                System.out.println("0 1");

            } else {
                Node[] fibo = new Node[size + 1];
                fibo[0] = new Node(1, 0);
                fibo[1] = new Node(0, 1);
                for (int i = 2; i < fibo.length; i++) {
                    fibo[i] = new Node(fibo[i - 1].zero + fibo[i - 2].zero, fibo[i - 1].one + fibo[i - 2].one);
                }
                System.out.println(fibo[size].zero + " " + fibo[size].one);
            }


        }
    }
}
