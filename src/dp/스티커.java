package dp;

import java.io.*;
import java.util.StringTokenizer;

public class 스티커 {

    static int[][]arr;
    static int[][]dp;
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        while (n-- > 0) {
            int size = Integer.parseInt(br.readLine());
            arr= new int[2][size];
            dp = new int[2][size+1];
            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < size; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            dp[0][0]=0;
            dp[0][1]=0;
            dp[0][1]=arr[0][0];//으악
            dp[1][1]=arr[1][0];

            //스티커가 때이면 그 상하 좌우가 다 뜯기기 때문에 다음 대각선 또는 그다음 대각선으로 이동을 한다.
            for (int i = 2; i <= size; i++) {
                dp[0][i]=Math.max(dp[1][i-1],dp[1][i-2])+arr[0][i-1];//최대의 값...을 가죠 가는 건ㄷ데
                dp[1][i]=Math.max(dp[0][i-1],dp[0][i-2])+arr[1][i-1];

            }
            int answer = Math.max(dp[0][size], dp[1][size]);
            sb.append(answer+"\n");


        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();

    }
}
