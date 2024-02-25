package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 계단_오르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        int[] arr = new int[size+1];
        int[] dp = new int[size + 1];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        if (size == 1) {
            System.out.println(arr[1]);
            System.exit(0);

        } else if (size == 1) {
            System.out.println(arr[1]+arr[2]);
            System.exit(0);
        }
        dp[1] = arr[1];
        dp[2] = dp[1] + arr[2];

        //조건 1 한꺼번에 두번을 넘겼을때.
        //조건 2 바로 밑에서 올라올때(바로 밑에서 두번 뛰어 넘고 넘어 왔을 때)
        for (int i = 3; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + arr[i - 1]) + arr[i];
        }
        System.out.println(dp[size]);




    }
}
