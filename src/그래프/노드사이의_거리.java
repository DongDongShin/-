package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 노드사이의_거리 {
    static class Node{
        int edge;//연결이 되어있는 노드의 번호
        int cnt;//가중치를 저장을 함.
        Node(int edge,int cnt){
            this.edge = edge;
            this.cnt = cnt;
        }
    }
    static ArrayList<ArrayList<Node>> adj = new ArrayList<>();
    static boolean[] visited;
    static int N;//노드의 개수
    static int M;//거리를 알고 싶은 노드 쌍의 개수
    static int ans;
    static  ArrayList<Integer> answers = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];//배열을 초기화 함.
        for (int i = 0; i < N + 1; i++) {
            adj.add(new ArrayList<>());//리스트를 초기화 함.
        }
        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            adj.get(start).add(new Node(end,dist));
            adj.get(end).add(new Node(start, dist));
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            visited = new boolean[N + 1];//방문 배열의 초기화를 함.
            ans = -1;
            DFS(start, end, 0);
            answers.add(ans);
        }
        for (Integer temp : answers) {
            System.out.println(temp);
        }
    }
    public static void DFS(int start, int end,int cnt){
        if(start==end){
            ans = cnt;
            return;
        }
        visited[start]=true;
        for (int i = 0; i < adj.get(start).size(); i++) {
            int idx = adj.get(start).get(i).edge;//
            int dist = adj.get(start).get(i).cnt;
            if (!visited[idx]) {//방문이 되지 않은 노드 이면 계속 ㄱㄱ
                visited[idx]=true;
                DFS(idx, end, cnt+dist);
            }
        }
        visited[start]=false;
    }
}