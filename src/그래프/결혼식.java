package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 결혼식 {

    static class Node{
        int idx;
        int depth;
        Node(int idx, int depth){
            this.idx = idx;
            this.depth = depth;
        }
    }
    static int n;//친구의 갯수
    static int m;//친구관계의 수
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    static boolean[] visited;
    static int answer = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];
        for (int i = 0; i < n + 1; i++) {
            adj.add(new ArrayList<>());//리스트의
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            adj.get(start).add(end);
            adj.get(end).add(start);
        }
        //DFS(1, 0);
        System.out.println(BFS(1));
    }

    public static int BFS(int idx){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(idx,0));
        int cnt =0;
        while (!q.isEmpty()) {
            Node temp = q.poll();
            if(temp.depth==3) break;//탐색을 종료함.
            if(temp.idx!=1&&temp.depth<=2)  cnt++;

            for (Integer i: adj.get(temp.idx)) {
                if(!visited[i]) {
                    visited[i] = true;
                    q.offer(new Node(i,temp.depth+1));
                }
            }
        }

        return cnt;

    }



    /*
      상근이의 친구의 친구까지만 가능함 즉 노드의 깊이가 2까지만 가능함!.
     */
//    public static  void DFS(int idx,int depth){
//        visited[idx]=true;
//        if (depth <= 3&&idx!=1) {//노드 1을 탐색할 때도 카운팅이 되기 때문에.
//            answer++;
//        }
//
//
//        for (Integer temp : adj.get(idx)) {
//            if(!visited[temp]) DFS(temp,depth+1);
//        }
//    }



}
