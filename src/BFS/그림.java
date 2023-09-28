package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
    int x;
    int y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

}


public class 그림 {



    static int[][] map;
    static boolean[][] visited;
    static int cnt= 0;
    static int Max = 0;
    static int[] move_x = {-1, 0, 1, 0};
    static int[] move_y = {0, 1, 0, -1};
    static  int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]&&map[i][j]==1) {//아직 탐색되지 않고 그림이 그려져 있을 때
                    BFS(i,j);
                    cnt++;//그림 갯수 ++

                }

            }
        }

        System.out.println(cnt);
        System.out.println(Max);


    }

    public static void BFS(int x, int y){ //여기 들어가면 일단 한장인 것을 의미
        int area = 1;//넓이를 구하는 친구
        visited[x][y]= true;
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));

        while (!q.isEmpty()) {
            Node temp = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = temp.x + move_x[i];
                int ny = temp.y + move_y[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny]&&map[nx][ny]==1) {
                    q.offer(new Node(nx, ny));
                    visited[nx][ny]= true;
                    area++;
                }
            }
        }
        Max = Math.max(Max, area);
    }
}
