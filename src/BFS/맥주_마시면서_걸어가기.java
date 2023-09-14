package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class XYS{
    int x;
    int y;
    XYS(int x, int y) {
        this.x=x;
        this.y=y;
    }

}

public class 맥주_마시면서_걸어가기 {



    static int t;//케이스의 갯수
    static int n;

    static XYS[] xys;
    static ArrayList<ArrayList<Integer>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            xys = new XYS[n+2];
            for (int i = 0; i < n + 2; i++) {
                st = new StringTokenizer(br.readLine()," ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                XYS temp = new XYS(x, y);
                xys[i]=temp; //배열에 일단 저장
            }
            list = new ArrayList<>();
            for (int i = 0; i < n + 2; i++) {
                list.add(new ArrayList<>());
            }
            for (int i = 0; i < n+1; i++) {
                XYS temp = xys[i];
                for (int j = i + 1; j < n + 2; j++) {
                    XYS temp2 = xys[j];
                    int distance = get_distance(temp.x,temp2.x,temp.y, temp2.y);
                    if (distance <= 1000) {
                        list.get(i).add(j);
                        list.get(j).add(i);
                    }
                }
            }
            if(BFS()) System.out.println("happy");
            else System.out.println("sad");
        }
    }
    public static boolean BFS(){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 2];
        q.offer(0);
        visited[0]= true;

        while (!q.isEmpty()) {
            int next = q.poll();
            if (next == n+1) {
                return true;
            }
            for (int i = 0; i < list.get(next).size(); i++) {
                if(!visited[list.get(next).get(i)]){//만약 얘가 아직 방문을 안했더라면
                    q.offer(list.get(next).get(i));
                    visited[list.get(next).get(i)]=true;
                }
            }
        }
        return false;
    }

    public static int get_distance(int x1,int x2,int y1,int y2){
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);

    }
}
