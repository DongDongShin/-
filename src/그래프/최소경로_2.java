package 그래프;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최소경로_2 {

    static class Node implements Comparable<Node>{

        int index;
        int weight;

        public Node(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight -o.weight;
        }
    }
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final int INF = 100_000_000;
    static int v,e,start;
    static int[] dist;
    static ArrayList<Node>[] edges;
    static boolean[] visit;


    public static void main(String[] args) throws IOException {

       StringTokenizer st = new StringTokenizer(br.readLine());
       v = Integer.parseInt(st.nextToken());
       e = Integer.parseInt(st.nextToken());
       start = Integer.parseInt(br.readLine());
       dist = new int[v+1];
       visit = new boolean[v+1];
       edges = new ArrayList[v+1];

        Arrays.fill(dist,INF);
       //이제 해야 할꺼는 무엇일까...
        for (int i = 1; i < v + 1; i++) {
            edges[i]= new ArrayList<>();//이제 저장을 하는거자나

        }
        dist[start]=0;//처음 시작 점은 0으로 초기화

        while (e-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            Node temp = new Node(end,weight);
            edges[start].add(temp);//여기서 이제 저장이 되는 거임
        }
        StringBuilder sb = new StringBuilder();
        dijkstra(start);

        for (int i = 1; i < edges.length; i++) {
            if(dist[i]==INF)
                sb.append("INF\n");
            else
                sb.append(dist[i]+"\n");

        }
        bw.write(sb.toString());

        br.close();
        bw.close();


    }

    public static void dijkstra(int index) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Node start  = new Node(index,0);
        pq.offer(start);
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int curr_index = current.index; //현재 인덱스
            if (visit[curr_index]) {
                continue;
            }
            visit[curr_index]= true;
            for (Node node : edges[curr_index]) {
                if (dist[node.index] > dist[curr_index] + node.weight) {
                    dist[node.index] = dist[curr_index] + node.weight;
                    pq.offer(new Node(node.index,dist[node.index]));
                }
            }


        }
    }
}
