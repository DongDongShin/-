package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RGB거리 {

    static int[][] distances ;
    static int[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        distances = new int[size][size];
        dp = new int[size][size];
        for (int i = 0; i < distances.length; i++) {
            String[] temps = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                distances[i][j] = Integer.parseInt(temps[j]);//거리를 저장함
            }
        }

        dp[0][0] = distances[0][0];//red
        dp[0][1] = distances[0][1];//green
        dp[0][2] = distances[0][2];//blue

        //다음은 어떻게 탐색을 해야할 까요..?
        //현재 색깔이 빨강이면 그 전에는 초록아니면 블루
        //현재 색깔이 파랑이면 그 전에는 빨강 아니면 그린
        //현재 색깔이 그린이면 그 전에는 빨강 아니면 파랑
        // red = 0 green = 1 blue = 2;
        for (int i = 1; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(j == 0) {//red일 때.
                    dp[i][j]= Math.min(dp[i-1][1],dp[i-1][2])+distances[i][j];
                }
                else if(j == 1) {//green일 때
                    dp[i][j]= Math.min(dp[i-1][0],dp[i-1][2])+distances[i][j];
                }
                else if(j == 2) {//blue일 때.
                    dp[i][j]= Math.min(dp[i-1][0],dp[i-1][1])+distances[i][j];
                }
            }
        }
        int answer = Math.min(dp[size-1][0],dp[size-1][1]);
        answer = Math.min(answer,dp[size-1][2]);
        System.out.println(answer);


    }
}
