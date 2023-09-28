package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

public class 꽃길 {

    static int[][] map;
    static boolean[][] visited;
    static int size;
    static int MIN = Integer.MAX_VALUE;
    static int[] move_x = {-1,0,1,0}; //세로 방향
    static int[] move_y = {0,1,0,-1};//가로 방향.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        StringTokenizer st;
        map = new int[size][size];
        visited = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < size; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bt(0, 0);
        System.out.println(MIN);

    }

    public static void bt(int cnt, int sum) {
        if (cnt == 3) {
            MIN = Math.min(MIN, sum);
        }
        else{
            for (int i = 1; i <= size - 1; i++) { //외각은 제외를 시키면서 계산
                for (int j = 1; j <= size - 1; j++) {
                    if(!visited[i][j]){ //일단 해당 범위가 칠해지지 않았으면
                        if (verify(i, j)) {
                            bt(cnt +1, sum+bloomFlower(i,j));//재귀를 할때 파라미터에 넘기는 값에 유의.. +=를 한다면 결국에는 sum의 값도 변질이 되기때문에 안되잉
                            witherFlower(i,j);
                        }
                    }
                }
            }
        }

    }

    //꽃을 지게 하는 함수
    public static void witherFlower(int x, int y){
        visited[x][y]=false;
        for (int i = 0; i < 4; i++) {
            visited[x+move_x[i]][y+move_y[i]]= false;
        }

    }
    //꽃을 피게 하는 함수

    public static int bloomFlower(int x, int y) {
        int cnt =0;

        visited[x][y]=true;
        cnt+=map[x][y];
        for (int i = 0; i < 4; i++) {
            visited[x+move_x[i]][y+move_y[i]]= true;
            cnt+=map[x+move_x[i]][y+move_y[i]];
        }
        return  cnt;
    }
    //조건을 검사해야함. 벽에 부딫히거나 다른 꽃에 겹치면 안됨
    public static boolean verify(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x+ move_x[i];
            int ny = y+ move_y[i];
            if(nx<0||nx>size-1||ny<0||ny>size-1||visited[nx][ny]){//범위에 맞거나 꽃이 겹치지 않았음을 의미
                return false;
            }
        }
        return true;


    }
}
