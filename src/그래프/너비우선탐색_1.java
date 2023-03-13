package 그래프;

import java.io.IOException;
import java.util.*;

public class 너비우선탐색_1 {
    static boolean visited[];
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static int N,M,R;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        R = sc.nextInt();
        for (int i = 0; i < N + 1; i++) {
            list.add(new ArrayList<>());
        }
        visit = new boolean[N+1];

        for (int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            list.get(start).add(end);
            list.get(end).add(start);
        }
        for (int i = 0; i < list.size(); i++) {
            Collections.sort(list.get(i));
        }
        Bfs(R);


    }

    public static void Bfs(int start) {

        Queue<Integer> q = new LinkedList<>();
        int[] ans = new int[N+1];
        int cnt=0;
        q.offer(start);
        ans[start] = ++cnt;
        visit[start] = true;

        while (!q.isEmpty()) {
            int vertex1 = q.poll();
            for (int i = 0; i < list.get(vertex1).size(); i++) {
                int vertex2 = list.get(vertex1).get(i);
                if(!visit[vertex2]){//다음 노드가 탐색되지 않으면
                    cnt++;
                    ans[vertex2] = cnt;
                    visit[vertex2]=true;
                    q.offer(vertex2);
                }
            }
        }
        for (int i = 1; i < ans.length; i++) {
            System.out.println(ans[i]);
        }

    }
}
