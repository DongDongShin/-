package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class XY{
    int x;
    int y;
    int cnt;
    XY(int x, int y,int cnt){
        this.x=x;
        this.y=y;
        this.cnt =cnt;
    }
}

public class BOJ2598 {



    static char[][] map;
    static int[] move_x={-1,0,1,0};//세로 방향으로 이동
    static int[] move_y={0,1,0,-1};//가로 방향으로 이동
    static int N;
    static int M;
    static int answer=0;
    static boolean[][] visited;
    //BFS를 돌리고 마지막까지 탐색하는 수.. 이 수들을 계속 비교
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j]=temp.charAt(j);

            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'L') {//땅이라면 탐색을 계속함.
                    visited = new boolean[N][M];
                    answer = Math.max(answer, BFS(i, j));
                }

            }
        }
        System.out.println(answer);

    }

    public static int BFS(int x, int y) {
        Queue<XY> q = new LinkedList<>();
        q.offer(new XY(x,y,0));
        int cnt =0;
        visited[x][y]=true;
        while (!q.isEmpty()) {
            XY temp = q.poll();
            cnt = temp.cnt;
            answer = Math.max(answer, cnt);
            for (int i=0; i < 4; i++) {
                int nx = move_x[i]+temp.x;
                int ny = move_y[i]+temp.y;
                if (nx < 0 || nx >= N || ny < 0 || ny >= M||visited[nx][ny]||map[nx][ny] == 'W') {
                    continue;
                }
                else{
                    XY xy = new XY(nx, ny, temp.cnt+1);
                    visited[nx][ny]= true;
                    q.offer(xy);
                }
            }
        }
        return cnt;
    }
}
