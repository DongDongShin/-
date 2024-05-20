package 유니온파인드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 집합의_표현 {
//
    static int n;
    static int m;
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parents = new int[n + 1];//집합을 초기화함.
        for (int i = 1; i < parents.length; i++) {
            parents[i]= i;
        }
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            //노드를 연결하기 위한 과정
            if (type == 0) {//노드를 연결하는 과정.
                union(a, b);
            }
            else{//같은 집합인지 아닌지를 판단하는 로직
                System.out.println(isSameSet(a,b));
            }
        }

    }

    public static void union(int a, int b) {
        int p1 = find(a);
        int p2 = find(b);
        //작은 얘가 루트가 되는 것임.
        if (p1 != p2) {
            if (p1 > p2) {
                parents[p1] = p2;
            }
            else {
                parents[p2]= p1;//부모 노드의
            }
        }

    }

    public static int find(int key){//트리의 루트르 찾는 코드
        if (parents[key] == key) {
            return key;
        }
        return parents[key]=find(parents[key]);

    }

    public static String isSameSet(int a, int b) {
        int p1 = find(a);
        int p2 = find(b);
        if(p1==p2) return "YES";
        else return "NO";
    }

}
