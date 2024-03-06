package 브루드포스;

import java.util.*;

public class 전력망둘로나누기_programmers {


    static ArrayList<ArrayList<Integer>> list;
    static boolean[] visited;
    static boolean[][] adj;

    public static void main(String[] args) {

        solution(9, new int[][]{{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}});
    }

    public static int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;//가장 작은 값을 return 해야함.
        ArrayList<Integer> ans = new ArrayList<>();
        adj = new boolean[n+1][n+1];
        for (int i = 0; i < wires.length; i++) {
            int idx1 = wires[i][0];
            int idx2 = wires[i][1];
            adj[idx1][idx2]= true;
            adj[idx2][idx1]= true;
        }
        for (int i = 1; i <= wires.length; i++) {
            int cutIdx1 = wires[i - 1][0];
            int cutIdx2 = wires[i - 1][1];
            visited = new boolean[n + 1];
            adj[cutIdx1][cutIdx2]= false;
            adj[cutIdx2][cutIdx1]=false;
            int isTree = BFS(1);//연결된 애들의 갯수
            answer = Math.min(answer, Math.abs(isTree - (n - isTree)));
            adj[cutIdx1][cutIdx2]= true;
            adj[cutIdx2][cutIdx1]=true;


        }

        System.out.println(answer);
        return answer;
    }

    public static int BFS(int idx) {
        int cnt = 1;
        Queue<Integer> q = new LinkedList<>();
        q.offer(idx);
        visited[idx] = true;
        while (!q.isEmpty()) {
            int temp = q.poll();
            for (int i = 1; i < adj[0].length;i++) {
                if (adj[temp][i] && !visited[i]) {
                    q.offer(i);
                    visited[i]= true;
                    cnt++;
                }
            }

        }


        return cnt;
    }


}
