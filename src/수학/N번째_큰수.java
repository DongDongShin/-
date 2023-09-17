package 수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N번째_큰수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        //pq 재정의.
        StringTokenizer st ;
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                pq.offer(Integer.parseInt(st.nextToken()));
            }
        }

        for(int i=0;i<N-1;i++){
            pq.poll();
        }
        System.out.println(pq.peek());

        //N번째 큰수를 찾음 여기서 는 전체 25개가 있는데 이건 21번째로 작은 수를 의미람
        //그니깐 한 줄에는 N개 가이


    }
}
