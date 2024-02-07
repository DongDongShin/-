package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과M_5 {
    static int[] arr ;
    static boolean[] visited;
    static int n;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n];

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);//일단 정렬을 해야겠죠
        dfs(0,"");
    }

    public static void dfs(int depth,String temp){
        StringBuilder sb = new StringBuilder(temp);
        if (depth == m) {
            System.out.println(temp);
            return;
        }
        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                visited[i]= true;
                dfs(depth+1, temp+String.valueOf(arr[i])+" ");
                visited[i]= false;
            }
        }



    }
}
