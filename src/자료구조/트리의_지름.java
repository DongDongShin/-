package 자료구조;

import 구현.소수개수구하기_programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 트리의_지름 {

    static class Node{
        int edge;//자신의 번호.
        int weight;
        Node(int edge,int weight) {
            this.edge = edge;
            this.weight = weight;
        }
    }

    static int N;
    static ArrayList<ArrayList<Node>> adj = new ArrayList<>();
    static boolean[] visited;
    static int maxIdx;
    static int maxWeight=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        for (int i = 0; i < N+1; i++) {
            adj.add(new ArrayList<>());//리스트를 초기화함
        }
        for (int i = 1; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());//부모 노드의 번호
            int end = Integer.parseInt(st.nextToken());//자식 노드의 번호
            int weight = Integer.parseInt(st.nextToken());//노드의 가중치
            adj.get(start).add(new Node(end, weight));
            adj.get(end).add(new Node(start, weight));
        }

        //루트에서 탐색을 해서 루트에서 가장 먼 노드를 탐색을 함.
        visited = new boolean[N+1];
        visited[1] = true;//루트를 방문 처리를 하고,
        DFS(1, 0);
        visited = new boolean[N + 1];
        visited[maxIdx] = true;
        maxWeight = 0;
        DFS(maxIdx,0);
        System.out.println(maxWeight);


        //그 이후에 찾아진 노드로 부터 가장 먼 노드를 탐색을 하게 되면
    }

    public static void DFS(int idx,int cnt){
        if (maxWeight < cnt) {
            maxWeight = cnt;
            maxIdx = idx; // 경로의 가중치가
        }
        for (Node node : adj.get(idx)) {//연결된 노드의 리스트
            if(visited[node.edge]) continue;;
            visited[node.edge]= true;
            DFS(node.edge,cnt+node.weight);
        }
    }
}
