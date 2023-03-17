package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

    public class 회전하는_큐 {

        static ArrayList<Integer> orders;
        static LinkedList<Integer> pq;
        static  int answer=0;
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            pq = new LinkedList<>();
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            orders = new ArrayList<>();
            int cnt = 1;
            while (N-- > 0) {
                pq.add(cnt);
                cnt++;
            }

            st = new StringTokenizer(br.readLine());
            while (M-- > 0) {
                orders.add(Integer.parseInt(st.nextToken()));
            }

            Dequeue();
            System.out.println(answer);
        }

        public static void Dequeue() {
            //pq 에는 어떤 값들이 저장
            //인덱스가 어디인지.. 어차피 해당 인덱스가 중요한거니깐
            for (int i = 0; i < orders.size(); i++) {
                int find = pq.indexOf(orders.get(i));
                //찾아야 하는 index 가 find 이제 얘가 어디에 있나
                int mid = pq.size() /2;
                if(find > mid){//오른쪽에 위치 되었음을 말
                    while (pq.getFirst() != orders.get(i)) {
                        pq.addFirst(pq.removeLast());
                        answer++;
                    }
                }
                else {
                    while (pq.getFirst()!= orders.get(i)) {
                        pq.addLast(pq.removeFirst());
                        answer++;
                    }

                }
                pq.remove();
            }
        }
    }


