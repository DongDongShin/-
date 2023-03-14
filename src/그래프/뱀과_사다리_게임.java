package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 뱀과_사다리_게임 {


    static int[] map;
    static int[] cnt;
    static boolean[] visit;
    static int[] move;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());//처음 써보는 건데..
        map = new int[101];
        cnt = new int[101];
        move = new int[101];

        visit = new boolean[101];

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            move[n1] = n2;//다음으로 갈 index를 저장을 하는 것임
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            move[n1] = n2;
        }

        //지금까지 저장을 했음
        Bfs();

    }

    public static void Bfs() {
        Queue<Integer> q = new LinkedList<>();//인덱스들을 저장하는 것임.
        visit[1] = true;
        cnt[1] = 0;
        q.offer(1); // 시작 인덱스는 1이다
        while (!q.isEmpty()) {
            int curr = q.poll();
            if (curr == 100) {//해당 인덱스에 도착을 했음
                System.out.println(cnt[100]);
                return;
            }
            for (int i = 1; i <= 6; i++) {
                int next = curr + i;
                if (next > 100) {//다음 인덱스가
                    continue;
                }
                if (visit[next]) {//않이 외 않되....
                    continue;
                }
                visit[next] = true;//해당 인덱스를 true;
                if (move[next] != 0) {//뱀또는 사다리이고 다음 index를 방문하지 않았을때. &&를 하면... 기초가 부족. 하나
                    if (!visit[move[next]]) {
                        q.offer(move[next]);//다음으로 가는 거임
                        visit[move[next]] = true;
                        cnt[move[next]] = cnt[curr] + 1;

                    }

                } else {//그냥 일때
                    q.offer(next);
                    cnt[next] = cnt[curr] + 1;
                }
            }

        }
    }
}
