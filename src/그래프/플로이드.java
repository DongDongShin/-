package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class 플로이드 {

    static int Infinite =  987654321;
    static int arr[][];
    static int v;
    static int e;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());//vertex의 갯수
        st = new StringTokenizer(br.readLine());
        e = Integer.parseInt(st.nextToken());
        arr = new int[v + 1][v + 1];//인접행렬 초기화
        for (int i = 1; i <= v; i++) {
            for (int j = 1; j <= v; j++) {
                if (i == j) {
                    arr[i][j]=0;
                }
                arr[i][j] = Infinite;

            }
        }//처음에는 다 모두 무한대로 초기화
        System.out.println(Infinite);
        while (e-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            arr[start][end] = Math.min(weight, arr[start][end]);
        }


        Floyd();
        for (int i = 1; i <= v; i++) {
            for (int j = 1; j <= v; j++) {
                if (arr[i][j] == Infinite) {
                    arr[i][j] = 0;
                }
            }
        }
        for (int i = 1; i <= v; i++) {
            for (int j = 1; j <= v; j++) {
                System.out.print(arr[i][j] + " ");
            }

            ///
            System.out.println();
        }

    }

    public static void Floyd() {
        for (int k = 1; k <= v; k++) {
            for (int i = 1; i <= v; i++) {
                for (int j = 1; j <= v; j++) {
                    if (i == j||i==k) continue;
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }
    }
}
