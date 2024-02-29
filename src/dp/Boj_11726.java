package dp;

import java.io.*;

public class Boj_11726 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] dp = new long[1001];
        int n = Integer.parseInt(br.readLine());

        //2xn 크기를 채울 수 있는 방법

        /**
         *    #
         *    #
         *   or
         *   ##  이렇게 있음.
         */
        dp[1]=1;
        dp[2]=2;
        for (int i = 3; i <= n; i++) {
            dp[i]= dp[i-1]+dp[i-2];
        }
        System.out.println(dp[n]%10007);



    }
}
