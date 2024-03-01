package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연속합 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int[] arr = new int[size + 1];
        int[] dp = new int[size + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[1]= arr[1];//처음 start는 무적권..
        //조건의 경우--> 연속되는 수 ---> 인겍스 별로
        //연속이 안되는 경우가 클 수 도 있으.ㅁ.
        //해당 인덱스에서 가장 클 수 있는 경우.
        for (int i = 2; i < arr.length; i++) {
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);



    }

}