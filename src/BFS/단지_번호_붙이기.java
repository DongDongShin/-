package BFS;

import java.io.*;
import java.util.*;

public class 단지_번호_붙이기 {


    static int[] move_Y = {-1, 0, 1, 0};//상,우,좌,하
    static int[] move_X = {0, 1, 0, -1};//상,우,좌,하
    static boolean[][] visit;//방문했는지 안했는지 표시
    static char[][] map;
    static int N;

    static class Node {
        int y;
        int x;

        public Node(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        N = Integer.parseInt(st.nextToken());//세로 크기
        map = new char[N][N];
        visit = new boolean[N][N];//초기화
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                map[i][j] = str.charAt(j);
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visit[i][j]&&map[i][j]=='1') {
                    list.add(BFS(i, j));
                }
            }
        }

        Collections.sort(list);
        bw.append(String.valueOf(list.size())+'\n');

        for (Integer temp : list) {
            bw.append(String.valueOf(temp));
            bw.append('\n');
        }
        bw.flush();
        bw.close();
        br.close();



    }

    public static int BFS(int y, int x) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(y, x));
        visit[y][x]=true;
        int cnt = 0;
        while (!q.isEmpty()) {
            Node temp = q.poll();
            cnt++;
            for (int i = 0; i < 4; i++) {
                int ny = temp.y + move_Y[i];
                int nx = temp.x + move_X[i];
                if (ny >= 0 && ny < N && nx >= 0 && nx < N) {//인덱스 검사
                    if (map[ny][nx] == '1' && !visit[ny][nx]) {//이동가능 할떼
                        visit[ny][nx] = true;//방문처리
                        q.offer(new Node(ny, nx));
                    }
                }
            }
        }
        return cnt;

    }
}
