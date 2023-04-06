package 수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 행렬곱셈 {

    static int[][] arr1;
    static int[][] arr2;
    static int[][] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr1= new int[n][m];


        for (int i = 0; i < n; i++) {
            st= new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr1[i][j]= Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        int n2 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());
        arr2 = new int[n2][m2];
        ans= new int[n][m2];

        for (int i = 0; i < n2; i++) {
            st= new StringTokenizer(br.readLine());
            for (int j = 0; j < m2; j++) {
                arr2[i][j]= Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m2; j++) {// 두번째 행렬의 열의 수.
                int sum = 0;
                for (int k = 0; k < m; k++) {//첫번째 행렬의 열의수 첫 번째 행렬의 열 = 두번째 행렬의 행
                sum += arr1[i][k]*arr2[k][j];
                }
                ans[i][j]= sum;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m2; j++) {
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }




    }
}
