package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 절댓값_힙 {

    static ArrayList<Integer> list;
    static PriorityQueue<Integer> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        list = new ArrayList<>();
        pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int abs1 = Math.abs(o1);
                int abs2 = Math.abs(o2);
                if (abs1 < abs2) {
                    return -1;//오름차순
                } else if (abs1 > abs2) {
                    return 1;//내림차순
                } else {//절댓값이 같을때.
                    if (o1 < o2) {
                        return -1;
                    } else if (o1 > o2) {
                        return 1;

                    }
                    else return 0;

                }

            }
        });
        int n = Integer.parseInt(st.nextToken());

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            list.add(Integer.parseInt(st.nextToken()));

        }

        pq();

        //절댓값으로 정렬을 하는데 으악. -1

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
