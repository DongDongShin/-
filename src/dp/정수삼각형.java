package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정수삼각형 {


    static int n;
    static int[][] triangle;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        dp = new int[n][n];
        triangle = new int[n][n];
        int ans =-1;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i + 1; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = triangle[0][0];

        for (int i = 1; i < n; i++) {
            //맨 왼쪽에 있으면 우, 상의 삼각형 값과 자기 자신의 값을 dp에 넣고 index=0
            //맨 오른족에 있으면 좌, 상의 삼각형과 자기 자신의 값을 더한다 index=i
            dp[i][0]= triangle[i][0]+dp[i-1][0];
            dp[i][i]= triangle[i][i]+dp[i-1][i-1];
            for (int j = 1; j <= i -1 ; j++) {
                dp[i][j] = Math.max(dp[i-1][j-1],dp[i-1][j])+triangle[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            ans= Math.max(ans,dp[n-1][i]);
        }

        System.out.println(ans);





    }
}
