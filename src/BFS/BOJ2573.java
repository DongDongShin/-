package BFS;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class  IceBerg{
    int x;
    int y;
    int height;

    IceBerg(int x,int y,int height){
        this.x =x;
        this.y=y;
        this.height= height;

    }
}
public class BOJ2573 {

    static int N;//행
    static int M;//열
    static int[] move_y = {-1, 0, 1, 0};
    static int[] move_x = {0, -1, 0, 1};
    static  IceBerg[][] iceBergs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int ans=0;
        int cnt=0;
        iceBergs = new IceBerg[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                iceBergs[i][j] = new IceBerg(i, j, Integer.parseInt(st.nextToken()));
            }
        }

        while ( (cnt= counting_IceBergs()) < 2) {
            if (cnt == 0) { //빙산이 다 녹았음을 의미
                ans=0;
                break;
            }
            melt();
            ans++;
        }

        System.out.println(ans);

    }

    public static void melt() {
        boolean[][] isIceBerg = new boolean[N][M]; //일단 초기화
        Queue<IceBerg> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (iceBergs[i][j].height != 0) {
                    isIceBerg[i][j]=true; //얘는 빙산이라는 것을 의미
                    q.offer(iceBergs[i][j]);//q에 넣어줌.
                }
            }
        }
        //이제 새롭게 녹여줘야 합니다.
        while (!q.isEmpty()) {
            IceBerg temp = q.poll();
            int sea_cnt=0;
            int next_x=0;
            int next_y=0;
            for (int i = 0; i < 4; i++) {
                next_x = move_x[i]+temp.x;
                next_y = move_y[i]+temp.y;
                if (next_x < 0 || next_x >=N || next_y < 0 || next_y >=M) {
                    continue;
                }
                if (!isIceBerg[next_x][next_y]) {
                    sea_cnt++;
                }
            }

            if (sea_cnt != 0) {
                if (temp.height - sea_cnt < 0) {
                    iceBergs[temp.x][temp.y].height=0;
                }
                else{
                    iceBergs[temp.x][temp.y].height= temp.height-sea_cnt;
                }
            }
        }
    }

    public static int counting_IceBergs(){
        int cnt =0;
        boolean[][] visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (iceBergs[i][j].height != 0 && !visited[i][j]) {
                    DFS(i, j, visited);
                    cnt++;
                }
            }
        }
        return  cnt;

    }

    public static void DFS(int x, int y, boolean[][] visited) {
        visited[x][y]=true;
        for (int i = 0; i < 4; i++) {
            int next_x = x + move_x[i];
            int next_y = y + move_y[i];
            if (next_x < 0 || next_x >=N || next_y < 0 || next_y >=M) {
                continue;
            }
            if (!visited[next_x][next_y]&&iceBergs[next_x][next_y].height!=0) {
                DFS(next_x,next_y,visited);
            }
        }
        return;
    }
}
