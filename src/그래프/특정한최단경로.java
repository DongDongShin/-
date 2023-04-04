package 그래프;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 특정한최단경로 {

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
    static final int INF = 200000000;
    static int v,e;
    static int[] dist;
    static ArrayList<Node>[] edges;
    static boolean[] visit;


    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());//정점의 갯수
        e = Integer.parseInt(st.nextToken());//간선의 갯수
        dist = new int[v+1];
        edges = new ArrayList[v+1];
        visit = new boolean[v+1];
        //이제 해야 할꺼는 무엇일까...
        for (int i = 1; i < v + 1; i++) {
            edges[i]= new ArrayList<>();//이제 저장을 하는거자나

        }

        while (e-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            Node temp = new Node(end,weight);
            edges[start].add(temp);//여기서 이제 저장이 되는 거임
            edges[end].add(new Node(start,weight));

        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());//얘네들은 꼭 가야하는 정점들임
        int v2 = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        //최단 경로들을 가져 가야함
        int ans_1=0;
        int ans_2=0;

        ans_1+=dijkstra(1,v1);
        ans_1+= dijkstra(v1,v2);
        ans_1+= dijkstra(v2,v);

        ans_2+= dijkstra(1,v2);
        ans_2+= dijkstra(v2,v1);
        ans_2+= dijkstra(v1,v);

        if (ans_1 >= INF && ans_2 >= INF) {
            sb.append(-1);
        }
        else {
            int answer = Math.min(ans_1,ans_2);
            sb.append(answer);
        }


        bw.write(sb.toString()+"\n");
        bw.flush();
        br.close();
        bw.close();


    }

    public static int dijkstra(int index,int end) {

        Arrays.fill(dist,INF);
        Arrays.fill(visit,false);
        dist[index]=0;//처음 시작 값은 0으로 초기
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

        return  dist[end];
    }
}
