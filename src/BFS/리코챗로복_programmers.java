package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class 리코챗로복_programmers {

    static char[][] maps;
    static boolean[][] visited;



    static int[] moveY = {-1,0,1,0};

    static int[] moveX = {0,1,0,-1};


    public static void main(String[] args) {
        System.out.println(solution(new String[]{".D.R", "....", ".G..", "...D"}));

    }
    static class Node{
        int x;
        int y;
        int cnt;

        Node(int y,int x, int cnt) {
            this.y = y;
            this.x = x;

            this.cnt = cnt;
        }
    }

    public static int solution(String[] board) {
        int size = board.length;//문자열의 개수.
        int y = 0;
        int x = 0;
        maps = new char[size][board[0].length()];//초기화
        visited = new boolean[size][board[0].length()];
        for (int i = 0; i < size; i++) {
            String temp = board[i];
            for (int j = 0; j < board[0].length(); j++) {
                char ctemp = temp.charAt(j);
                if(ctemp == 'R') {
                    y = i; x = j;
                }
                maps[i][j] = ctemp;
            }
        }

        return BFS(y, x);
    }

    public static int BFS(int y,int x){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(y, x, 0));
        visited[y][x]=true;//방문처리를 하는 것임.
        while (!q.isEmpty()) {
            Node temp = q.poll();
            if (maps[temp.y][temp.x]=='G') {//답을 찾을땨
                return temp.cnt;
            }
            for (int i = 0; i < 4; i++) {
                int nx = temp.x;
                int ny = temp.y;
                while (isRange(ny, nx)&&maps[ny][nx]!='D') {//한 방향으로 계속가는 것을 의미함.
                    ny += moveY[i];
                    nx += moveX[i];
                }
                //걸리기 직전의 인덱스로 돌아감.
                ny -= moveY[i];
                nx -= moveX[i];

                if((nx==temp.x&&ny== temp.y)||visited[ny][nx]) continue; //이전과 같은 위치이거나,
                visited[ny][nx]=true;//멈춰진 상태를 큐에 저장을 함.
                q.offer(new Node(ny, nx, temp.cnt + 1));
            }
        }
        return -1;
    }

    public static boolean isRange(int y, int x) {
        return(y>=0&&x>=0&&y<maps.length&&x<maps[0].length);

    }
}
