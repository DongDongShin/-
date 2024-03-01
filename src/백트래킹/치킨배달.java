package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 치킨배달 {

    static class Node{
        int y;
        int x;

        public Node(int y, int x) {//위치 정보를 저장함.
            this.y = y;
            this.x = x;
        }
    }
    static int N;
    static int M;
    static ArrayList<Node> homes;
    static ArrayList<Node> chickens;
    static int answer=Integer.MAX_VALUE;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        homes = new ArrayList<>();
        chickens = new ArrayList<>();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());//몇개의 치킨집을 살릴 것인가.
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp == 1) {//집일때.
                    homes.add(new Node(i, j));
                } else if (temp == 2) {
                    chickens.add(new Node(i, j));
                }
            }

        }
        visited = new boolean[chickens.size()];

        backtracking(0,0,new ArrayList<>());
        System.out.println(answer);

    }


    public static void backtracking(int depth,int idx,ArrayList<Integer> indexes) {

        if (depth == M) {
            findChickenLength(indexes);
            return;
        }
        for (int i = idx; i < chickens.size(); i++) {
            if (!visited[i]) {
                visited[i]= true;
                indexes.add(i);
                backtracking(depth+1,i+1,indexes);
                indexes.remove(indexes.size() - 1);
                visited[i]= false;
            }
        }

    }

    public static void findChickenLength(ArrayList<Integer> indexes) { //이 치킨집을 살리는 것임.
        int sum = 0;
        for (Node home : homes) {
            int minDistance=Integer.MAX_VALUE;
            for (Integer index : indexes) {
                minDistance = Math.min(minDistance,Math.abs(home.y-chickens.get(index).y)+Math.abs(home.x-chickens.get(index).x));
            }
            sum+=minDistance;
        }
        answer = Math.min(answer,sum);







    }
}
