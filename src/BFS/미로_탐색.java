package BFS;

import java.io.*;

import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로_탐색 {
    static int[] move_Y = {-1, 0, 1, 0};//상,우,좌,하
    static int[] move_X = {0, 1, 0, -1};//상,우,좌,하
    static int N;
    static int M;
    static char[][] map;//갈수 있는지 없는지를 표시
    static boolean[][] visit;//방문했는지 안했는지 표시

    static class Node {
        int y;
        int x;
        int cnt;

        public Node(int y, int x,int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String answer;
        N = Integer.parseInt(st.nextToken());//세로 크기
        M = Integer.parseInt(st.nextToken());//가로 크기
        map = new char[N][M];
        visit = new boolean[N][M];//초기화
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                map[i][j]=str.charAt(j);
            }
        }
        answer = String.valueOf(BFS(0, 0));
        bw.write(answer);
        bw.flush();
        bw.close();
        br.close();

    }

    public static int BFS(int y, int x) {
        int answer = 0;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(y, x,1));
        while (!q.isEmpty()) {
            Node temp = q.poll();
            if (temp.y == N - 1 && temp.x == M - 1) {
                q.clear();
                answer= temp.cnt;
                break;
            } else {
                for (int i = 0; i < 4; i++) {
                    int ny = temp.y + move_Y[i];
                    int nx = temp.x + move_X[i];
                    if (ny >= 0 && ny < N && nx >= 0 && nx < M)  {//인덱스 검사
                        if (map[ny][nx]=='1'&&!visit[ny][nx]) {//이동가능 할떼
                            visit[ny][nx] = true;//방문처리
                            q.offer(new Node(ny, nx, temp.cnt + 1));
                        }
                    }
                }
            }

        }
        return answer;
    }
}