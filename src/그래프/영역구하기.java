package 그래프;

import javax.management.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 영역구하기 {




    static  boolean[][] arr;


    //u r d l로 이동
    static  int[] move_y ={-1,0,1,0};
    static  int[] move_x ={0,1,0,-1};
    static ArrayList<Integer> list;
    static int M;
    static int N;

    static class xys {
        int x;
        int y;

        public xys(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        list = new ArrayList<>();
        M = Integer.parseInt(st.nextToken());//세로
        N = Integer.parseInt(st.nextToken());//가로
        int K = Integer.parseInt(st.nextToken());
        arr = new boolean[M][N];


        for (int i = 0; i < K; i++) {//좌표값을 저장.
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int x2 =Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for (int j = y; j < y2; j++) {
                for (int k = x; k < x2; k++) {
                    arr[j][k]=true;
                }
            }
        }



        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(!arr[i][j]){//빈칸이라면
                   list.add(Bfs(i,j));
                }
            }
        }

        Collections.sort(list);
        System.out.println(list.size());
        for (Integer cnt : list) {
            System.out.print(cnt+" ");
        }
    }

    public static int Bfs(int y, int x){
        int cnt =0;
        Queue<xys> q = new LinkedList<>();
        arr[y][x]= true;
        q.add(new xys(x,y));
        while (!q.isEmpty()){
            xys temp = q.poll();
            for (int i = 0; i < 4; i++) {
                int next_x = temp.x+move_x[i];
                int next_y = temp.y+move_y[i];
                if ((next_x >= 0 && next_x < N)&& (next_y >= 0 && next_y < M)) {//이동가능한 범위
                    if (!arr[next_y][next_x]) {
                        q.offer(new xys(next_x, next_y));
                        arr[next_y][next_x]= true;
                        cnt++;
                    }
                }
            }
        }
        return cnt+1;
    }
}
