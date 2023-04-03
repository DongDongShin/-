package 조합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 다리놓기 {


    static int cnt;
    static int M, N;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        dp = new int[31][31];
        dp[0][0] = dp[1][0] = dp[1][1] = 1;
        for(int i=1;i<31;i++){
            dp[i][0] =0;
            dp[i][1] =i;
            for (int j = 2; j < 31; j++) {
                dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
            }
        }


        int n = Integer.parseInt(st.nextToken());
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());//서쪽
            N = Integer.parseInt(st.nextToken());//동쪽
            System.out.println(dp[N][M]);
        }

    }


}
