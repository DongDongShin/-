package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 이친수 {
    static class Node{
        long zero;
        long one;
        public Node(long zero, long one) {
            this.zero = zero;
            this.one = one;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Node[] dp = new Node[90+1];

        dp[1] = new Node(0, 1);
        dp[2] = new Node(1, 0);

        for (int i = 3; i <= n; i++) {
            //전에 0이면 그대로 0과 1로 분화
            //1이면 다음은 무조건 0으로 분화
            dp[i] = new Node(dp[i - 1].zero + dp[i - 1].one, dp[i - 1].zero);
        }

        System.out.println(dp[n].one+dp[n].zero);




    }
}
