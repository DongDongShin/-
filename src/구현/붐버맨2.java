package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 붐버맨2 {
    static class Bomb{
        int y;
        int x;

        public Bomb(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static char[][] map;
    static int r;
    static int c;
    static int sec;
    static int[][]bombs;
    static int[] move_y={-1,0,1,0};//세로 방향으로 이동
    static int[] move_x={0,1,0,-1};//가로 방향으로 이동

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r= Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());//가로길이
        sec = Integer.parseInt(st.nextToken());
        map = new char[r + 1][c + 1];
        bombs = new int[r + 1][c + 1];

        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                bombs[i][j]=-1;//일단 -1로 초기화를 때림.
            }
        }
        for (int i = 1; i <= r; i++) {
            String temp = br.readLine();
            for (int j = 1; j <= c; j++) {
                char temp2 = temp.charAt(j-1);
                if (temp2 == 'O') {
                    bombs[i][j]=0;// 폭탄이 설치 된것을 의미함.
                }
                map[i][j] = temp.charAt(j - 1);
            }
        }
        int cnt=0;
        while (++cnt <= sec) {
            addTime();//현재 큐에 있는 폭탄의 시간을 더해주기
            activateBomb();//터질 폭탄이 있으면 터트리기.
            if (cnt % 2 == 0) {//남아있는 자리에 폭탄을 추가해주기
                addBomb();
            }
        }
        for (int i = 1; i < r+1; i++) {
            for (int j = 1; j < c+1; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    public static void addTime() {
        for (int i = 1; i < r+1; i++) {
            for (int j = 1; j < c+1; j++) {
                if (map[i][j] != -1) {//해당 지역이 .이라면 폭탄을 추가해
                    bombs[i][j]++;
                }
            }
        }
    }


    public static void addBomb() {//폭탄을 더해주고 지도에 표시를 해주기
        for (int i = 1; i < r+1; i++) {
            for (int j = 1; j < c+1; j++) {
                if (map[i][j] == '.') {//해당 지역이 .이라면 폭탄을 추가해줌
                    map[i][j] = 'O';
                    bombs[i][j]=0;//폭탄이 설치 되었음.
                }
            }
        }
    }
    public static void activateBomb() {//현재 q안에 있는 폭탄들을 검사해서 터트리기
        ArrayList<Bomb> list = new ArrayList<>();
        for (int i = 0; i < r + 1; i++) {
            for (int j = 0; j < c + 1; j++) {
                if (bombs[i][j] == 3) {//터짐.
                    bombs[i][j]=-1;//폭탄이 터진거임. -1을 해주고
                    map[i][j] = '.';
                    list.add(new Bomb(i, j));

                }
            }
        }
        for (Bomb bomb : list) {
            for (int k = 0; k < 4; k++) {
                int ny = bomb.y + move_y[k];
                int nx = bomb.x + move_x[k];
                //이 범위에 있는 폭탄도 제거를 해줘야함.
                if (ny >= 1 && nx >= 1 && ny < r+1 && nx < c+1) {
                    map[ny][nx] = '.';//초기 상태로 돌아가게 함.
                    bombs[ny][nx]=-1;//터졌으니깐 다시 초기화

                }
            }

        }


    }
}
