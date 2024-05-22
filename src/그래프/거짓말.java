package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 거짓말 {
    static int N;//사람의 수
    static int M;//파티의 갯수
    static ArrayList<Integer> liar = new ArrayList<>();
    static int[] parents;
    static int answer = 0;
    static ArrayList<ArrayList<Integer>> parties = new ArrayList<>();//파티마다의 참여자들을 저장하는 리스트를 의미
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());//사람의 수
        M = Integer.parseInt(st.nextToken());//파티의 수
        parents = new int[N + 1];
        for (int i = 1; i < parents.length; i++) {
            parents[i]=i;//부모 노드의 초기화를 함.
        }
        for (int i = 0; i < M + 1; i++) {
            parties.add(new ArrayList<>());//리스트의 초기화.
        }
        st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        for (int i = 0; i < size; i++) {
            int idx = Integer.parseInt(st.nextToken());
            liar.add(idx);
        }
        for (int i = 1; i <= M; i++) {//파티에 저장이 되어있는 사람들을 저장함.
            st = new StringTokenizer(br.readLine());
            size = Integer.parseInt(st.nextToken());//파티에 참여하는 사람들.
            for (int j = 0; j < size; j++) {
                int person = Integer.parseInt(st.nextToken());
                parties.get(i).add(person);//파티에 참여되어 있는 사람들을 저장을 함.
                //각각의 노드의 루트를 부모를 첫번째 사람의 부모로 설정을 함.
            }
            for(int k=1;k<size;k++){
                union(parties.get(i).get(0),parties.get(i).get(k));
            }
        }

        for (int i = 1; i < parties.size(); i++) {
            boolean find = false;
            int reader = parties.get(i).get(0);
            for (int j = 0; j < liar.size(); j++) {
               if(isSame(reader,liar.get(j))) {
                   find =true;
                   break;
               }
            }
            if(!find) answer++;
        }

        System.out.println(answer);
    }

    public static boolean isSame(int a, int b) {
        int p1 = find(a);
        int p2 = find(b);
        if(p1==p2) return true;
        else return false;
    }

    public static int find(int a){
        if(parents[a]==a) return a; //재귀의 종료.

        else
            return parents[a]=find(parents[a]);
    }

    public static void union(int a, int b){
        int p1 = find(a);
        int p2 = find(b);

        if (p1 != p2) {//부모가 같지 않다면,
            parents[p2] = p1;//부모의 노드를 벼경을 함.
        }

    }
}
