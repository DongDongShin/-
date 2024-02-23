package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 돌게임 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n+1];
        if (n == 1) {
            System.out.println("SK");
            System.exit(1);
        }
        if (n == 2) {
            System.out.println("CY");
            System.exit(1);
        }

        //상근이가 처음 그 다음이 창영이가 함
        //돌이 하나 남으면 상근이가 이김
        //돌이 두개 남으면 창영이가 이김
        //돌이 세개 남으면 상근이가 이김
        //돌이 네개 남으면 무조건 창영이가 이김..

        //# 1= 상근 승 2 = 창여잉 승
        arr[1]=1;
        arr[2]=2;
        arr[3]=1;
        for (int i = 4; i < arr.length; i++) {
            //하나 가져가나 세개 가져가나 생각을 해야함
            //그 전의 해로 지금의 상황을 유추함.
            //모든 경우의 수는 처음에 하나 가져가는지 세개 가져가는지에 따라 달라짐.
            if (arr[i - 1] ==1 && arr[i - 3] == 1) { // 상근이가 이겼으면
                arr[i]=2;//해당은 창영이가 이김
            }
            else
                arr[i]=1;
        }
        if (arr[n] == 1) {
            System.out.println("SK");
        }
        else
            System.out.println("CY");



    }
}
