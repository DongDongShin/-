package dp;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

class Node {
    int t;//걸리는 시간
    int p;//가질수 있는 비용

    public Node(int t, int p) {
        this.t = t;
        this.p = p;
    }
}

public class 퇴사 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[n + 1];
        for (int i = 1; i < nodes.length; i++) { //일단 저장을 하고... 해당
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            nodes[i] = new Node(t, p);
        }
        int[] dp = new int[n + 1]; //해당 인덱스에서 내가 가장 많이 얻을 수 있는 생각해 내야함.
        //조건 해당 종료일이 N 일을 넘지 않아야한다.
        for (int i = 1; i < nodes.length; i++) {//i는 일을 표시함
            //일단 지금 날의 작업을 상담할 수 있는지를 계산해야함.
            if (nodes[i].t + i <= n+1) {
                dp[i] = nodes[i].p;//일단 해당 비용을 저장을 함
            }
            int max=0;
            for (int j = 1; j < i; j++) {//지금 인덱스 전까지 탐색을 하는건데 왜 ^^ㅣ발 이게 안되면 적 안되지
                 if (j+nodes[j].t <= i) {//해당 일수 + 해당 상담의 시간이 현재 인덱스보다 작아야함
                    max = Math.max(max,dp[j]);
                }

            }
            dp[i]+=max;

        }
        int answer=0;
        for (int i : dp) {
            answer = Math.max(answer,i);
        }
        System.out.println(answer);
    }
}
