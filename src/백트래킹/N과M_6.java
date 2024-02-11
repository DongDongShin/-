package 백트래킹;

import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과M_6 {

    static int N;
    static int M;
    static boolean[] visited;
    static int idx = 0;
    static int[] arr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());//자연수 갯수a
        M = Integer.parseInt(st.nextToken());//수열 크기
        arr = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0;i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        bt(0,0,"");


    }

    public static void bt(int depth,int idx,String temp) {
        if (depth == M) {
            System.out.println(temp);
            return;
        }
        for (int i = idx; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                bt(depth + 1, ++idx, temp+String.valueOf(arr[i])+" ");
                visited[i]= false;
            }
        }



    }
}
