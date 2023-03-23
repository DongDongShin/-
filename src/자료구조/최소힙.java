package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최소힙 {


    static PriorityQueue<Integer> pq ;
    static ArrayList<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        list = new ArrayList<>();
        pq = new PriorityQueue<>();


        int n = Integer.parseInt(st.nextToken());

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            list.add(Integer.valueOf(st.nextToken()));
        }

        pq();

    }

    public static void pq() {

        for (Integer num : list) {
            if (num == 0) {
                if (pq.isEmpty()) {
                    System.out.println(0);
                }

                else
                    System.out.println(pq.poll());
            }
            else {
                pq.offer(num);
            }

        }

    }
}
