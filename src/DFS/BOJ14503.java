package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14503 {

    static int[][] map;

    //북쪽일경우 (0,1)
    //동쪽일 경우 (-1,0)
    //남쪽일 경우 (0,-1)
    //서쪽일경우 (1,0)
    static int[] movey = {-1, 0, 1, 0}; //상하
    static int[] movex = {0, 1, 0, -1}; //좌우
    static int cnt =1;
    // 0 북 1 동 2 남 3서
    static int r;
    static int c;
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken()); //세로방향
        M = Integer.parseInt(st.nextToken()); //가로방향
        int direction;
        map = new int[N][M];


        st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken()); //세로 방향
        c = Integer.parseInt(st.nextToken()); //가로 방향
        direction = Integer.parseInt(st.nextToken()); //바라보는 방향.


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()); //0이면 청소가 안된거고 1이면 벽이라는 거임..
            }
        }

        dfs(r,c,direction);
        System.out.println(cnt);


    }

    public static void dfs(int r,int c,int direction) {
        map[r][c]=-1;//현재 자리를 청소를 하였음.

        for (int i = 0; i < 4; i++) { //이제 탐색을 할거임
            direction = (direction+3)%4;//반시계 방향으로 90도회전을 하였음. 이제 이걸 가지고 탐색을 해야됨
            int ny = r + movey[direction];
            int nx = c + movex[direction];

            if(ny>=0&&ny<N&&nx>=0&&nx<M){
                if(map[ny][nx]==0){//청소가 가능한 지역으로 이동
                    cnt++;
                    dfs(ny,nx,direction);//다음 방향으로 수정 후 다시 1번 과정으로 이동
                    return;
                }
            }
        } //여기에 해당이 안되는 경우 방ㅎ향을 유지한 채로 한칸 후진을 해야 함.

        //북쪽일경우 (0,1)
        //동쪽일 경우 (-1,0)
        //남쪽일 경우 (0,-1)
        //서쪽일경우 (1,0)
        int back = (direction+2)%4; //지금 현재 dir
        int ny = r+movey[back];
        int nx = c+movex[back];
        if(ny>=0&&ny<N&&nx>=0&&nx<M&&map[ny][nx]!=1){ //후진 가능한 것을 의미함
            dfs(ny,nx,direction);
        }
    }
}
