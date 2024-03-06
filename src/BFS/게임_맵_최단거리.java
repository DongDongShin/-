package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class 게임_맵_최단거리 {


    static int[] move_Y = {-1, 0, 1, 0};//상,우,하,좌
    static int[] move_X = {0, 1, 0, -1};//상,우,하,좌
    static int[][] arr;

    static class Node{
        int y;
        int x;
        int cnt;

        public Node(int y, int x,int cnt) {
            this.y = y;
            this.x = x;
            this.cnt=cnt;
        }
    }
    public static void main(String[] args) {
        arr = new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}}; //이렇게 하는 구남
        System.out.println(solution(arr));


    }


    public static int solution(int[][] maps) {
        //처음 시작하는 공간
        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        q.offer(new Node(0,0,1));
        while (!q.isEmpty()) {
            Node temp = q.poll();
            int y = temp.y;
            int x = temp.x;
            if (y == maps.length - 1 && x == maps[0].length - 1) {
                return temp.cnt;
            }
            for (int i = 0; i < 4; i++) {
                int ny = y + move_Y[i];
                int nx = x + move_X[i];
                if (ny >= 0 && ny < maps.length && nx >= 0 && nx < maps[0].length) {
                    if (!visited[ny][nx]&&maps[ny][nx]==1) {
                        q.offer(new Node(ny, nx, temp.cnt + 1));
                        visited[ny][nx]= true;
                    }
                }
            }
        }
        return -1;
    }
}
