package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최대힙 {


    static PriorityQueue<Integer> pq ;
    static ArrayList<Integer> list;
    ////ㅓㅗ허허허
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        list = new ArrayList<>();
        pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {//내림 차순으로 정렬을 하는 거니깐;
                return o2-o1;
            }
        });


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
