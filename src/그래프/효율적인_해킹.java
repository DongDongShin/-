package 그래프;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 효율적인_해킹 {
    static boolean[] visited;
    static ArrayList<ArrayList> temps = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());//노드의 개수
        int N = Integer.parseInt(st.nextToken());//입력의 줄 라인
        temps = new ArrayList<>();
        int max = -1;
        for(int i=0;i<M+1;i++){
            temps.add(new ArrayList());
        }
        int[] answers = new int[M + 1];
        //A가 B를 신뢰를 하면 B가 감염이 되면 A도 감염이 되는 것을 의미한다.
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            temps.get(b).add(a);
        }
        for (int i = 1; i < visited.length; i++) {
            visited = new boolean[M + 1];//초기화를 함
            int cnt = BFS(i);
            max = Math.max(cnt, max);
            answers[i] = cnt;
        }
        for (int i = 1; i < answers.length; i++) {
            if(answers[i]==max) bw.write(i+" ");
        }
        bw.flush();
        bw.close();

    }

    public static int BFS(int idx) {
        int cnt = 1;
        visited[idx] = true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(idx);
        while (!q.isEmpty()) {
            int qidx = q.poll();
            ArrayList<Integer> temp = temps.get(qidx);
            for (Integer index : temp) {
                if(visited[index]) continue;
                visited[index]= true;
                cnt++;
                q.offer(index);
            }
        }
        return cnt;

    }
//    public static void dfs(int index){
//        ArrayList<Integer> temp = temps.get(index);
//        for (Integer i : temp) {
//            if(visited[i]) continue;;
//            visited[i] = true;
//            cnt++;
//            dfs(i);
//        }
//    }
}
