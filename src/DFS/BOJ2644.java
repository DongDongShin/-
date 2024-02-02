package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ2644 {


    static int n;
    static int child;
    static int parent;
    static int answer = -1;
    static boolean visited[];
    static ArrayList<Integer>[] adjlist; //배열 리스트

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        adjlist = new ArrayList[n+1];

        visited = new boolean[n + 1];
        for (int i = 1; i < n +1; i++) { //인덱스를 맞춰주기 위해서 일단 +1
            adjlist[i]= new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine(), " ");
        child = Integer.parseInt(st.nextToken());
        parent = Integer.parseInt(st.nextToken());



        int size = Integer.parseInt(br.readLine());

        //한 사람은 한번의 부모만 가능함.. 그러니깐 먼저 등록을하고 양방향에 표시된 거는 자동적으로 자식 - 부모관계가 적립됨.
        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int p =Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adjlist[p].add(c);
            adjlist[c].add(p);


        } //일단 인접리스트를 초기화 하였음
        DFS(child,parent,0);
        System.out.println(answer);

    }

    public static void DFS(int start, int end, int cnt) {
        visited[start] = true;//현재 이 노드는 방문을 한것 임
        if (start == end) {
            answer = cnt;
            return;
        }
        //이제 순회를 ㅎ하면 되는 거자자
        for(int i=0;i<adjlist[start].size();i++){
            //이제 탐색을 하는 것임..
            int next = adjlist[start].get(i);
            if(!visited[next]){
                //아직 탐색을 안했어??
                DFS(next,end,cnt+1);
            }


        }


    }


}
