package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숨바꼭질3 {


    public static class Node {
        int x;
        int time;

        public Node(int x, int time) {//생성자 초기화
            this.x = x;
            this.time = time;
        }
    }


    static boolean[] visited;
    static int x1;
    static int x2;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        x1 = Integer.parseInt(st.nextToken());//현재 수빈이의 위치
        x2 = Integer.parseInt(st.nextToken());//동생의 위치
        visited = new boolean[100001];
        if(x1 == x2) System.out.println(0);
        else {
            Bfs();
            System.out.println(min);
        }

    }

    public static void Bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x1, 0));//처음 노드를 가져가서 초기화를 시킴.
        visited[x1]=true;

        while (!q.isEmpty()) {
            Node next = q.poll();
            if(next.x==x2){//해당 지점에 도착을 했어.그러면 시간의 최솟값을 초기화 해야겠지
                min = Math.min(min, next.time);
            }
            if(next.x*2<=10000&&!visited[next.x*2]){//순간이동을 하는거임
                q.offer(new Node(next.x*2, next.time));
                visited[next.x*2]=true;
            }
            if(next.x+1<=10000&&!visited[next.x+1]){//순간이동을 하는거임
                q.offer(new Node(next.x+1, next.time+1));
                visited[next.x+1]=true;
            }
            if(next.x-1>0&&!visited[next.x-1]){//순간이동을 하는거임
                q.offer(new Node(next.x-1, next.time+1));
                visited[next.x-1]=true;
            }
        }
    }
}
