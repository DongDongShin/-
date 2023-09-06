package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class AtoB {

    static class cnt{
        long cnt;
        long n;

        public cnt(long n, long cnt) {

            this.n = n;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        System.out.println(Bfs(A,B));


    }

    public static long Bfs(long A, long B){

        Queue<cnt> q = new LinkedList<>();
        q.offer(new cnt(A,0));
        while (!q.isEmpty()){
            cnt temp = q.poll();
            long num = temp.n;
            long cnt = temp.cnt;
            if (num == B) {
                return cnt+1;
            }
            if (num * 2 <= B) {
                q.offer(new cnt(num * 2, cnt + 1));
            }
            if (num *10+ 1 <= B) {
                q.offer(new cnt(num *10+ 1 , cnt + 1));
            }
        }

        return  -1;


    }
}
