package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 벽부수고이동하기2 {


    static int N;//행의 개수
    static int M;//열의 개수
    static int K;//벽을 부숴 버릴 수 있는 개수를 지정을 해줌.
    static int[] moveY = {-1, 0, 1, 0};//상,우,하,좌
    static int[] moveX = {0, 1, 0, -1};//상,우,하,좌
    static boolean[][][] visited;
    static char[][] maps;

    static class Node {
        int y;
        int x;
        int dist;
        int wall;

        public Node(int y, int x, int dist, int wall) {
            this.y = y;
            this.x = x;
            this.dist = dist;
            this.wall = wall;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());//행의 개수
        M = Integer.parseInt(st.nextToken());//열의 개수
        K = Integer.parseInt(st.nextToken());
        maps = new char[N][M];
        visited = new boolean[N][M][K + 1];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                maps[i][j] = input.charAt(j);//해당 영역의 값을 저장해줌.
            }
        }

        System.out.println(move());
    }

    public static int move() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0, 1, 0));//시작점도 횟수를 세야하기 때문에 1로 초기화를 함.
        while (!q.isEmpty()) {
            Node temp = q.poll();
            if (temp.y == N - 1 && temp.x == M - 1) {
                return temp.dist;// 지금까지의 누적된 거리를 반환해줌.
            }
            for (int i = 0; i < 4; i++) {
                int ny = temp.y + moveY[i];
                int nx = temp.x + moveX[i];
                //벽일 때랑 벽이 아닐때를 또 검사를 해줘야 함.
                if (!isRange(ny, nx)) continue;

                if (maps[ny][nx] == '0' && !visited[ny][nx][temp.wall]) {//현재 위치가 '0'이고 아직 탐색이 안됐을때
                    visited[ny][nx][temp.wall] = true;
                    q.offer(new Node(ny, nx, temp.dist + 1, temp.wall));
                } else if ((temp.wall + 1 <= K) && maps[ny][nx] == '1' && !visited[ny][nx][temp.wall + 1]) {//벽이고 아직 탐색이 되지 않고
                    visited[ny][nx][temp.wall + 1] = true;//해당 벽을 탐색을 완료 하였음
                    q.offer(new Node(ny, nx, temp.dist + 1, temp.wall + 1));
                }
            }
        }
        return -1;
    }


    public static boolean isRange(int y, int x) {
        if (y < 0 || x < 0 || y >= N || x >= M) {//인덱스의 범위가 넘어가는 것을 의미함
            return false;
        } else return true;
    }
}
