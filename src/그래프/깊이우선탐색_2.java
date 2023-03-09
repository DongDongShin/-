package 그래프;

import java.lang.reflect.GenericDeclaration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class 깊이우선탐색_2 {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();;
    static int cnt=0;
    static int start=0;
    static int[] ans;
    static boolean[] visit;
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        start = sc.nextInt();
        ans = new int[N+1];
        for (int i = 0; i < N + 1; i++) {//인접리스트를 초기화 한다잉
            graph.add(new ArrayList<>());
        }

        visit = new boolean[N+1];//방문 여부를 체크하는 boolean 배열
        for (int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int end =sc.nextInt();
            graph.get(start).add(end);
            graph.get(end).add(start);
        }
        for (int i = 1; i < N + 1; i++) {//list를 역순으로 정렬하는 고런 느낌
            Collections.sort(graph.get(i),Collections.reverseOrder());
        }
        Dfs(start);
        for (int i = 1; i < N + 1; i++) {
            System.out.println(ans[i]);
        }

    }

    public static void Dfs(int vertex){
        visit[vertex] = true;
        cnt++;
        ans[vertex]= cnt;//탐색이 된 해당 vertex의 순서를 저장한다.
        for (int i = 0; i < graph.get(vertex).size(); i++) {//현재 리스트에 저장된 얘들을 탐색
            int next_vertex = graph.get(vertex).get(i);
            if(!visit[next_vertex]){//얘가 아직 탐색이 되지 않았다면
                Dfs(next_vertex);
            }
        }
    }
}
