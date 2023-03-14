package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 프린터_큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cnt = Integer.parseInt(st.nextToken());

        while (cnt-- > 0) {//계속 루프를 도는 거잉
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            int find = Integer.parseInt(st.nextToken());//찾고자 하는 인덱스의 값.
            int[] arr = new int[size];
            ArrayList<Integer> list = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < size; i++) {
               list.add(Integer.parseInt(st.nextToken()));//list 로 가보자
            }
            System.out.println(print(list,find));

        }
    }
    public static int print(ArrayList<Integer> list,int find){
        Queue<Integer> pq = new LinkedList<>();
        int cnt =0;
        for (int i : list) {
            pq.offer(i);//일단 queue를 채워주는 것임
        }
        Collections.sort(list,Collections.reverseOrder());//내림차순으로 정렬
        //해당 인덱스가 어디에 있는지 판단을 해야함.
        //출력이 되는 조건 현재 제일 큰수보다 같거나 작으면 출력 그게 아니면 index -- 인덱스가 0이면 현재 큐의 사이즈로 이동
        while (!pq.isEmpty()) {
            int front = pq.poll();//일단 빼내..
            if(front >= list.get(0)){//이 경우에는 출력이 되는거임
                cnt++;
                list.remove(0);
                find--;
                if(find==-1){//찾고 있는 문서가 출력이 됨
                    return cnt;
                }
            }
            else{//만약 출력이 안된 경우에는 인덱스가 밀리기 때문에 find-- 만약 find <0 이라면 해당 q의 size-1로 변경
                find--;
                pq.offer(front);//지운거를 다시 넣어줘잉
                if (find < 0) {
                    find = pq.size()-1;
                }
            }
        }



        return -1;
    }
}
