package BFS;

import javax.management.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class node{
    int y;
    int x;
    int time;

    public node(int y, int x, int time) {
        this.y = y;
        this.x = x;
        this.time = time;
    }
}
public class 불 {

    static int[] move_Y = {-1, 0, 1, 0};//상,우,하,좌
    static int[] move_X = {0, 1, 0, -1};//상,우,하,좌
    static boolean[][] visitF;
    static boolean[][] visitJ;
    static int r;
    static int c;
    static char[][] map;
    static Queue<node> fq;
    static Queue<node> jq;
    static int answer =0;
    //1초마다 지훈이와 불이 동시에 전파가 됨.. 그럼 한 루프마다 현재 q에 있는 사이즈만.. 전파를 시키고 갈 수 있는지 아닌지를.. 생각하면 되겠
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        fq= new LinkedList<>();
        jq= new LinkedList<>();
        map = new char[r][c];
        visitF = new boolean[r][c];
        visitJ = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            String temp = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = temp.charAt(j);//지도를 받아오고요.
                if(temp.charAt(j)=='J'){ //지훈이가 있는 좌표
                    jq.offer(new node(i, j, 0));
                    visitJ[i][j]= true;
                }
                if(temp.charAt(j)=='F'){ //불이 시작되는 좌표
                    fq.offer(new node(i, j, 0));
                    visitF[i][j]= true;
                }
            }
        }
        if(BFS_J()){
            System.out.println(answer);
        }
        else{
            System.out.println("IMPOSSIBLE");
        }

    }

    public static boolean BFS_J(){
        while (!jq.isEmpty()) {
            start_fire();//불을 먼저 질러버리기...
            int size = jq.size();//얘도 분 간격 에서만..진행
            for (int i = 0; i < size; i++) {
                node temp = jq.poll();
                if (temp.y==0||temp.y==r-1||temp.x==0||temp.x==c-1) {//탈출한 경우를 의미함
                    answer = temp.time+1;
                    return true;
                }
                for (int d = 0; d < 4; d++) {
                    int ny = temp.y + move_Y[d];
                    int nx = temp.x + move_X[d];
                    if (!is_range(ny, nx)) {
                        continue;
                    }
                    if (map[ny][nx] =='#') {//벽일 때
                        continue;
                    }
                    if(visitF[ny][nx]||visitJ[ny][nx]){
                        continue;//불이 지나간 자리일 때.
                    }
                    jq.offer(new node(ny, nx, temp.time+1));
                    visitJ[ny][nx]=true;
                }
            }
        }
        return false;

    }
    public static void start_fire(){//1분이 지나서 전파되는 불 == 현재 q에 있는 불로만 전파 되야함.
        int size = fq.size();
        for (int i = 0; i < size; i++) {
            node temp = fq.poll();//
            for (int d = 0; d < 4; d++) {
                int ny = temp.y + move_Y[d];
                int nx = temp.x + move_X[d];
                if (!is_range(ny, nx)) {
                    continue;
                }
                if (map[ny][nx] == '#') {//벽일 때
                    continue;
                }
                if (visitF[ny][nx]) {//이미 붙여진 장소일 때.
                    continue;
                }
                fq.offer(new node(ny, nx, 0));
                visitF[ny][nx]=true;
                map[ny][nx]= 'F';//불로 변경
            }
        }
    }

    public static boolean is_range(int ny, int nx){//범위에 속하는지 검사
        if (ny < 0 || ny >= r || nx < 0 || nx >= c) {//인덱스가 벗어나감.
            return false;
        }
        return true;

    }

}


