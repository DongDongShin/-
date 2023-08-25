package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class BOJ12789 {

    public static Queue<Integer> q;
    public static Stack<Integer> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int min =1;
        q = new LinkedList<>();
        stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            q.offer(Integer.parseInt(st.nextToken()));
        }
        while (!q.isEmpty()) {
            if (q.peek() == min) {//현재 나가는 값이 제일 작은 값이라면
                min++;
                q.poll();
            }//스택 대기열도 고려를 해줘야함
            else if (!stack.isEmpty()&&stack.peek()==min) {
                min++;
                stack.pop();
            } else {
                stack.push(q.poll());
            }
        }
        while (!stack.isEmpty()) {
            if (stack.peek() == min) {
                min++;
                stack.pop();
            }
            else{
                System.out.println("Sad");
                return;
            }
        }
        System.out.println("Nice");

    }


}
