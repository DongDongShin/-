package 그래프;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 깊이우선탐색 {

//    public static boolean [][] edges;//연결 여부 g헉 메모리 초과.. 인접리스트를 사용하자

    public static ArrayList<ArrayList<Integer>> list = new ArrayList<>();//인접행렬 대신에 어레이 리스트로
    public static int[] nodes;
    public static boolean[] visited;
    public static int[] order;
    static int cnt = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();//정정의 수
        int M = sc.nextInt();// 간선의 수
        int start = sc.nextInt();

//        edges = new boolean[N+1][N+1];
        for (int i = 0; i < N + 1; i++) {
            list.add(new ArrayList<>());//새로운 리스트들을 초기화
        }
        nodes = new int[N + 1];
        order = new int[N + 1];
        visited = new boolean[N + 1];//아직 어떠한 노드도 방문하지 않음

        for (int i = 0; i < M; i++) {//연결 여부를 설정
            int start_point = sc.nextInt();
            int end_point = sc.nextInt();
            list.get(start_point).add(end_point);
            list.get(end_point).add(start_point);
        }

        for (int i = 1; i < list.size(); i++) {
            Collections.sort(list.get(i));
        }
        Dfs(start);

        for (int i = 1; i < order.length; i++) {
            System.out.println(order[i]);
        }
    }


    //    public static void Dfs(int start,int cnt){// 인접행렬 탐색
//        order[start]= cnt;
//        visited[start]= true;
//        for(int i=1;i<nodes.length;i++){
//            if(!visited[i]&&edges[start][i]){
//                Dfs(i,cnt+1);
//            }
//        }
//    }
    public static void Dfs(int start) {// 인접행렬 탐색
        order[start] = cnt;
        visited[start] = true;
        for (int i = 0; i < list.get(start).size(); i++) {
            int next = list.get(start).get(i);//다음 인덱스
            if (!visited[next]) {
                cnt++;
                Dfs(next);
            }
        }
    }
}
