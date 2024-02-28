package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 상범빌딩 {
    static class Node {
        int z;
        int y;
        int x;
        int cnt;
        public Node(int z, int y, int x,int cnt) {
            this.z = z;
            this.y = y;
            this.x = x;
            this.cnt = cnt;
        }
    }

    static char[][][] map;
    static boolean[][][] visited;

    static int l;
    static int r;
    static int c;
    static int[] moveZ ={1, -1, 0, 0, 0, 0};//위,아래,상,우,하,좌.
    static int[] moveY = {0,0,-1, 0, 1, 0};//위,아래,상,우,하,좌
    static int[] moveX = {0,0,0, 1, 0, -1};//위,아래,상,우,하,좌
    static Queue<Node> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        while (true){
            String tmp = br.readLine();
            if (tmp.equals("")) {
                tmp = br.readLine();
            }
            String[] arr = tmp.split(" ");
            l = Integer.parseInt(arr[0]);//층
            r = Integer.parseInt(arr[1]);//행
            c = Integer.parseInt(arr[2]);//높이
            if (l == 0 && r == 0 && c == 0) {//종료조건.
                break;
            }
            map = new char[l + 1][r + 1][c + 1];//map을 초기화를 합시다
            visited = new boolean[l + 1][r + 1][c + 1];//초기화를 함.
            q = new LinkedList<>();
            for (int i = 1; i <= l; i++) {
                for (int j =1; j <= r; j++) {
                    String str = br.readLine();
                    if (str.equals("")) {
                        str = br.readLine();
                    }
                    for (int k = 1; k <= c; k++) {
                        if (str.charAt(k - 1) == 'S') {
                            q.offer(new Node(i, j, k, 0));
                            visited[i][j][k]=true;
                        }
                        map[i][j][k] = str.charAt(k-1);
                    }
                }
            }
            int ans =BFS();
            if(ans!=-1)
                System.out.println("Escaped in "+ ans +" minute(s).");
            else
                System.out.println("Trapped!");
        }

    }

    public static int BFS(){
        while (!q.isEmpty()) {
            Node temp = q.poll();
            if (map[temp.z][temp.y][temp.x]=='E') {
                return temp.cnt;
            }
            int nz;
            int ny;
            int nx;
            for (int i = 0; i < 6; i++) {
                nz=moveZ[i]+ temp.z;
                ny=moveY[i]+temp.y;
                nx=moveX[i]+ temp.x;
                if (nz >= 1 && nz <= l && ny >= 1 && ny <= r && nx >= 1 && nx <= c) {
                    if (!visited[nz][ny][nx]&&map[nz][ny][nx]!='#') {//탐색을 안하였고 벽이 아니여야 함.
                        q.offer(new Node(nz,ny,nx, temp.cnt+1));
                        visited[nz][ny][nx]=true;//꺼낼때 visit을 check를 하면. 많은 중복 값들이 큐에 넣어지게 됨.
                        //그래서 방문을 할 때 visit을 체크를 해야하는 것임.

                    }
                }
            }
        }
        return -1;
    }
}
