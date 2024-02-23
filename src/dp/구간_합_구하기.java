package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class 구간_합_구하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[size+1];
        int[] dp = new int[size + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken()); //저장을 합니다.
        }
        dp[1]= arr[1];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] + arr[i];
        }
        for (int i = 0; i < n; i++) {//출력문을 만들어 봅시다.
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int diff = end -start;
            if (diff == 0) {//
                System.out.println(arr[end]);
            }
            else {
                System.out.println(dp[end] - dp[start-1]);
            }



        }


    }
}
