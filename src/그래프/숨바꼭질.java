package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class 숨바꼭질 {
    static int N;
    static int M;
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    static int[] distances;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());//노드의 개수,
        M = Integer.parseInt(st.nextToken());//간선의 개수
        distances = new int[N + 1];
        int max =-1;
        int cnt=0;
        int answeridx=0;
        for (int i = 0; i < N+1; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            adj.get(start).add(end);
            adj.get(end).add(start);
        }
        //모든 노드들은 저장이 되어있으니깐 루트부터 탐색을 하고 distance를 ++시킴 1번 노드를 제외한
        BFS(1);
        for (int i = 1; i < distances.length; i++) {
            if(max<distances[i]){//더큰 수를 만나면 초기화를 해야함.
                cnt=1;
                answeridx=i;
                max = distances[i];
            }
            else if(max==distances[i]){
                cnt++;
            }
        }
        System.out.println(answeridx+" "+max+" "+cnt);

    }
    public static void BFS(int idx){
        Queue<Integer> q = new LinkedList<>();
        q.offer(idx);
        while (!q.isEmpty()) {
            int curr = q.poll();//다음 인덱스
            for (Integer index: adj.get(curr)) {
                if (index != 1 && distances[index] == 0) {//1번 노드가 아닌 이상 distance이 0이면 해당 인덱스는 탐색이 안된 상태
                    distances[index] = distances[curr]+1;
                    q.offer(index);
                }

            }
        }
    }
}
