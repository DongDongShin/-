package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class AC {


    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            Deque<Integer> dq = new ArrayDeque<>();//처음으로 초기화
            String command = br.readLine();//command
            int size = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), "[],");
            for (int i = 0; i < size; i++) {
                dq.offer(Integer.parseInt(st.nextToken()));
            }
            AC(dq,command);


        }
    }

    public static void AC(Deque<Integer> dq, String command) {
        boolean isRight = true; //처음에는 정방향으로 커밋 왜 안돼.
        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) == 'R') {//방향을 바꾸는
                isRight = !isRight;
            } else {
                if (isRight) {
                    if (dq.pollFirst() == null) {
                        System.out.println("error");
                        return;
                    }
                } else {
                    if (dq.pollLast() == null) {
                        System.out.println("error");
                        return;
                    }
                }
            }
        }
        print(dq,isRight);
    }

    public static void print(Deque<Integer> dq, boolean isRight) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (dq.size() != 0) {//저장할께 있으면

            if (isRight){
                sb.append(dq.pollFirst());
                while(!dq.isEmpty()){
                    sb.append(","+dq.pollFirst());
                }
            }
            else{
                sb.append(dq.pollLast());
                while(!dq.isEmpty()){
                    sb.append(","+dq.pollLast());
                }
            }
        }
        sb.append("]");
        System.out.println(sb.toString());


    }
}
